package com.hvd.docs.ai.processor;

import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.hvd.docs.google.document.ai.DocumentAiClient;
import com.hvd.docs.google.document.ai.processor.DocumentClassificator;
import com.hvd.integrator.common.env.loader.StaticEnvironment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DocumentClassificatorTest {

    private final DocumentProcessorServiceClient client = new DocumentAiClient().get();
    private final DocumentClassificator documentClassificator = new DocumentClassificator(client);

    @Test
    @Disabled
    void test() {
        String url = "gs://ai-hackathon-2024/Examples/0122626300540903__12003.pdf";
        String t = documentClassificator.find(url, "application/pdf");
        Assertions.assertNotNull(t);
    }
}
