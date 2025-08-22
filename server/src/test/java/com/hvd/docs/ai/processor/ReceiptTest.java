package com.hvd.docs.ai.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.hvd.docs.google.document.ai.DocumentAiClient;
import com.hvd.docs.google.document.ai.processor.Invoice;
import com.hvd.docs.google.document.ai.processor.Receipt;
import com.hvd.integrator.common.env.loader.StaticEnvironment;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReceiptTest {
    private final DocumentProcessorServiceClient client = new DocumentAiClient().get();

    private final Receipt receipt;

    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        receipt = new Receipt(client);
    }

    @Test
    @Disabled
    void pdf() throws IOException {
        String url = "gs://ai-hackathon-2024/Examples/0122626300540903__12003.pdf";
        receipt.process(url, "application/pdf");
    }

    @Test
    @Disabled
    void exampleEnglishInvoice() throws IOException {
        String url = "gs://ai-hackathon-2024/training/inn.png";
        receipt.process(url, "image/png");
    }
}
