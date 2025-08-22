package com.hvd.docs.google.document.ai.processor;

import com.google.cloud.documentai.v1.*;
import com.hvd.docs.google.document.ai.DocumentDiscovery;
import com.hvd.integrator.common.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DocumentClassificator {

    private final DocumentProcessorServiceClient client;

    private final ProcessorName processorName;

    @Autowired
    public DocumentClassificator(DocumentProcessorServiceClient client) {
        this(client, Processors.DOCUMENT_TYPE);
    }

    public DocumentClassificator(DocumentProcessorServiceClient client, ProcessorName processorName) {
        this.client = client;
        this.processorName = processorName;
    }

    public String find(String gsUrl, String contentType) {
        ProcessRequest.Builder builder = ProcessRequest.newBuilder().setName(processorName.invoice());
        new DocumentDiscovery().setup(gsUrl, contentType, builder);
        ProcessResponse result = client.processDocument(builder.build());
        Document documentResponse = result.getDocument();
        List<Document.Entity> entitiesList = documentResponse.getEntitiesList();
        return entitiesList
            .stream()
            .max(Comparator.comparing(Document.Entity::getConfidence))
            .map(Document.Entity::getType)
            .orElse("undefined");
    }
}
