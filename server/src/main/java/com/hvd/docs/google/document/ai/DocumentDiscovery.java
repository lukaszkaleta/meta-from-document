package com.hvd.docs.google.document.ai;

import com.google.cloud.documentai.v1.GcsDocument;
import com.google.cloud.documentai.v1.ProcessRequest;
import com.google.cloud.documentai.v1.RawDocument;
import com.google.protobuf.ByteString;
import com.profsys.integrator.common.java.io.UrlAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DocumentDiscovery {

    private final Logger log = LoggerFactory.getLogger(DocumentDiscovery.class);

    public void setup(String url, String contentType, ProcessRequest.Builder builder) {
        if (url.startsWith("gs:")) {
            setupGcs(url, contentType, builder);
        } else if (url.startsWith("http")) {
            setupHttp(url, contentType, builder);
        } else {
            setupLocalFile(url, contentType, builder);
        }
    }

    private void setupHttp(String url, String contentType, ProcessRequest.Builder builder) {
        byte[] bytes = null;
        try {
            bytes = new UrlAccess(url).bytes();
        } catch (Exception e) {
            log.error("URL Access: {}", e.getMessage(), e);
        }
        setupRaw(bytes, contentType, builder);
    }

    private void setupLocalFile(String url, String contentType, ProcessRequest.Builder builder) {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(url));
        } catch (IOException e) {
            log.error("Local File: {}", e.getMessage(), e);
        }
        setupRaw(bytes, contentType, builder);
    }

    private void setupGcs(String url, String contentType, ProcessRequest.Builder builder) {
        GcsDocument gcsDocument = GcsDocument.newBuilder()
                .setMimeType(contentType)
                .setGcsUri(url)
                .build();
        builder.setGcsDocument(gcsDocument);
    }

    private void setupRaw(byte[] bytes, String contentType, ProcessRequest.Builder builder) {
        // Convert the image data to a Buffer and base64 encode it.
        ByteString content = ByteString.copyFrom(bytes);
        RawDocument document = RawDocument.newBuilder()
                .setContent(content)
                .setMimeType(contentType)
                .build();
        builder.setRawDocument(document);
    }
}
