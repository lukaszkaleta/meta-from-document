package com.hvd.docs.google.document.ai;

import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1.DocumentProcessorServiceSettings;

import java.io.IOException;

public class DocumentAiClient {

    private final String endpoint = new DocumentAiEndpoint().get();

    public DocumentAiClient() {
    }

    public DocumentProcessorServiceClient get() {
        DocumentProcessorServiceSettings settings = null;
        try {
            settings = DocumentProcessorServiceSettings.newBuilder().setEndpoint(endpoint).build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            return DocumentProcessorServiceClient.create(settings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
