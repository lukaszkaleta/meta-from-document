package com.hvd.docs.google.document.ai;

public class DocumentAiEndpoint {

    private final String location;

    public DocumentAiEndpoint() {
        this("eu");
    }

    public DocumentAiEndpoint(String location) {
        this.location = location;
    }

    public String location() {
        return this.location;
    }

    public String get() {
        return "%s-documentai.googleapis.com:443".formatted(location);
    }
}
