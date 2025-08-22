package com.hvd.docs.google.document.ai.processor;

import com.google.cloud.documentai.v1.Document;
import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1.ProcessRequest;
import com.google.cloud.documentai.v1.ProcessResponse;
import com.hvd.docs.google.document.ai.DocumentDiscovery;
import com.hvd.docs.google.document.ai.schema.InvoiceJson;
import com.hvd.docs.google.document.ai.schema.ReceiptJson;
import com.hvd.docs.google.document.ai.schema.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Receipt {

    private final DocumentProcessorServiceClient client;

    private final ProcessorName processorName;

    @Autowired
    public Receipt(DocumentProcessorServiceClient client) {
        this(client, Processors.RECEIPT);
    }

    public Receipt(DocumentProcessorServiceClient client, ProcessorName processorName) {
        this.client = client;
        this.processorName = processorName;
    }

    public ReceiptJson process(String url, String contentType) {
        ProcessRequest.Builder builder = ProcessRequest.newBuilder().setName(processorName.receipt());
        new DocumentDiscovery().setup(url, contentType, builder);
        ProcessResponse result = client.processDocument(builder.build());
        Document document = result.getDocument();
        return new Schema().receipt(document);
    }
}
