package com.hvd.docs.ai.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.hvd.docs.google.document.ai.DocumentAiClient;
import com.hvd.integrator.common.env.loader.StaticEnvironment;
import com.hvd.docs.google.document.ai.processor.Invoice;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class InvoiceTest {

    private final StaticEnvironment environment = new StaticEnvironment();
    private final DocumentProcessorServiceClient client = new DocumentAiClient().get();

    private final Invoice invoice;

    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        invoice = new Invoice(client);
    }

    @Test
    @Disabled
    void pdf() throws IOException {
        String url = "gs://ai-hackathon-2024/Examples/0122626300540903__12003.pdf";
        invoice.process(url, "application/pdf");
    }

    @Test
    void exampleEnglishInvoice() throws IOException {
        String url = "gs://ai-hackathon-2024/training/inn.png";
        invoice.process(url, "image/png");
    }
}
