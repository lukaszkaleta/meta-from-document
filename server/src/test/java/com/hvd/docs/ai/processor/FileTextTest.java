package com.hvd.docs.ai.processor;

import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.hvd.docs.google.document.ai.DocumentAiClient;
import com.hvd.integrator.common.env.loader.StaticEnvironment;
import com.hvd.docs.google.document.ai.processor.FileText;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class FileTextTest {

    @Test
    @Disabled
    void name() throws IOException {
        String url = "gs://ai-hackathon-2024/IMG_3675.jpg";
        DocumentProcessorServiceClient client = new DocumentAiClient().get();
        List<String> paragraphs = new FileText(client).paragraphs(url);
    }
}
