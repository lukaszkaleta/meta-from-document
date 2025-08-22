package com.hvd.docs.web.payload;

import com.hvd.docs.google.document.ai.schema.InvoiceJson;
import com.hvd.docs.google.document.ai.schema.ReceiptJson;

public class OutputDocument {

    private final InputDocument inputDocument;

    private final InvoiceJson invoice;
    private final ReceiptJson receipt;

    private final long processTime;

    public OutputDocument(InputDocument inputDocument, ReceiptJson receipt, long processTime) {
        this.inputDocument = inputDocument;
        this.receipt = receipt;
        this.invoice = null;
        this.processTime = processTime;
    }
    public OutputDocument(InputDocument inputDocument, InvoiceJson invoice, long processTime) {
        this.inputDocument = inputDocument;
        this.invoice = invoice;
        this.receipt = null;
        this.processTime = processTime;
    }

    public InputDocument getInputDocument() {
        return inputDocument;
    }

    public InvoiceJson getInvoice() {
        return invoice;
    }

    public ReceiptJson getReceipt() {
        return receipt;
    }

    public long getProcessTime() {
        return processTime;
    }
}
