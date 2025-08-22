package com.hvd.docs.google.document.ai.processor;

import com.google.cloud.documentai.v1.*;
import com.hvd.integrator.common.env.Environment;

import java.util.ArrayList;
import java.util.List;

/**
 * OCR function.
 */
public class FileText {

    private final DocumentProcessorServiceClient client;

    private final ProcessorName processorName;

    public FileText(DocumentProcessorServiceClient client) {
        this(client, Processors.OCR);
    }

    public FileText(DocumentProcessorServiceClient client, ProcessorName processorName) {
        this.client = client;
        this.processorName = processorName;
    }

    public String rawText(String bucket, String fileName, String contentType) {
        String bucketPrefix = "dev-fs";
        String gsUrl = "gs://%s-%s/%s".formatted(bucketPrefix, bucket, fileName);

        return rawText(gsUrl, contentType);
    }

    private String rawText(String gsUrl, String contentType) {
        GcsDocument gcsDocument = GcsDocument.newBuilder()
                .setMimeType(contentType)
                .setGcsUri(gsUrl)
                .build();
        ProcessRequest request = ProcessRequest.newBuilder()
                .setName(processorName.ocr())
                .setGcsDocument(gcsDocument)
                .build();
        ProcessResponse result = client.processDocument(request);
        Document documentResponse = result.getDocument();
        return documentResponse.getText();
    }


    public List<String> paragraphs(String url) {
        GcsDocument gcsDocument = GcsDocument.newBuilder()
                .setMimeType("image/png")
                .setGcsUri(url)
                .build();
        ProcessRequest request = ProcessRequest.newBuilder()
                .setName(processorName.ocr())
                .setGcsDocument(gcsDocument)
                .build();
        ProcessResponse result = client.processDocument(request);
        Document documentResponse = result.getDocument();

        // Get all of the document text as one big string
        String text = documentResponse.getText();

        // Read the text recognition output from the processor
        System.out.println("The document contains the following paragraphs:");
        Document.Page firstPage = documentResponse.getPages(0);
        List<Document.Page.Paragraph> paragraphs = firstPage.getParagraphsList();

        List<String> paragraphList = new ArrayList<>();
        for (Document.Page.Paragraph paragraph : paragraphs) {
            String paragraphText = getText(paragraph.getLayout().getTextAnchor(), text);
            paragraphList.add(paragraphText);
        }

        return paragraphList;
    }

    private static String getText(Document.TextAnchor textAnchor, String text) {
        if (textAnchor.getTextSegmentsList().size() > 0) {
            int startIdx = (int) textAnchor.getTextSegments(0).getStartIndex();
            int endIdx = (int) textAnchor.getTextSegments(0).getEndIndex();
            return text.substring(startIdx, endIdx);
        }
        return "[NO TEXT]";
    }
}
