package com.hvd.docs.web;

import com.hvd.docs.conversion.Conversion;
import com.hvd.docs.conversion.Converter;
import com.hvd.docs.conversion.InputDocumentStream;
import com.hvd.docs.google.document.ai.processor.Receipt;
import com.hvd.docs.google.document.ai.schema.InvoiceJson;
import com.hvd.docs.google.document.ai.processor.DocumentClassificator;
import com.hvd.docs.google.document.ai.processor.Invoice;
import com.hvd.docs.google.document.ai.schema.ReceiptJson;
import com.hvd.docs.web.payload.InputDocument;
import com.hvd.docs.web.payload.OutputDocument;
import com.profsys.integrator.common.java.io.FileName;
import com.profsys.integrator.common.java.lang.WorkingDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;

@Component
public class DocumentTask {

    private final Logger log = LoggerFactory.getLogger(DocumentTask.class);

    private final DocumentClassificator documentClassificator;
    private final Invoice invoice;
    private final Receipt receipt;

    private final Conversion conversion;

    @Autowired
    public DocumentTask(DocumentClassificator documentClassificator, Invoice invoice, Receipt receipt, Conversion conversion) {
        this.documentClassificator = documentClassificator;
        this.invoice = invoice;
        this.receipt = receipt;
        this.conversion = conversion;
    }


    public OutputDocument execute(InputDocument inputDocument, String forceType, ProcessContext processContext) {
        InputDocument processingInputDocument = convertIfNeeded(inputDocument);
        return doParser(processingInputDocument, forceType, processContext);
    }

    private OutputDocument doParser(InputDocument processingInputDocument, String type, ProcessContext processContext) {
        switch (type) {
            case "invoice":
                return invoice(processingInputDocument, processContext);
            case "receipt":
                return receipt(processingInputDocument, processContext);
        }
        return null;
    }

    public OutputDocument execute(InputDocument inputDocument, ProcessContext processContext) {
        InputDocument processingInputDocument = convertIfNeeded(inputDocument);
        log.info("Classification: {} from {} of type {}", processingInputDocument.id(), processingInputDocument.url(), processingInputDocument.contentType());
        String type = documentClassificator.find(processingInputDocument.url(), processingInputDocument.contentType());
        return doParser(processingInputDocument, type, processContext);
    }

    public OutputDocument invoice(InputDocument inputDocument, ProcessContext processContext) {
        log.info("Processing Invoice: {} from {} of type {}", inputDocument.id(), inputDocument.url(), inputDocument.contentType());
        InvoiceJson invoiceJson = invoice.process(inputDocument.url(), inputDocument.contentType());
        return new OutputDocument(inputDocument, invoiceJson, processContext.time());
    }

    public OutputDocument receipt(InputDocument inputDocument, ProcessContext processContext) {
        log.info("Processing Receipt: {} from {} of type {}", inputDocument.id(), inputDocument.url(), inputDocument.contentType());
        ReceiptJson receiptJson = receipt.process(inputDocument.url(), inputDocument.contentType());
        return new OutputDocument(inputDocument, receiptJson, processContext.time());
    }

    private InputDocument convertIfNeeded(InputDocument inputDocument) {
        InputDocument processingInputDocument = inputDocument;
        Optional<Converter> converterOptional = conversion.converter(inputDocument);
        if (converterOptional.isPresent()) {
            log.info("Conversion: {} from {} of type {}", inputDocument.id(), inputDocument.url(), inputDocument.contentType());
            Converter converter = converterOptional.get();
            String extension = new FileName(inputDocument.url()).extension();
            String result = new WorkingDirectory().filePath(UUID.randomUUID() + "." + extension);
            InputStream stream = new InputDocumentStream(inputDocument.url()).get();
            try {
                converter.convert(stream, result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            processingInputDocument = InputDocument.fromLocalFile(result, "application/pdf", inputDocument);
        }
        return processingInputDocument;
    }
}
