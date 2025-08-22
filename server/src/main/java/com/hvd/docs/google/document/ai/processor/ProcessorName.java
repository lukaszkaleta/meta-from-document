package com.hvd.docs.google.document.ai.processor;

public class ProcessorName {

    private final String projectId;
    private final String location;
    private final String id;

    public ProcessorName(String id) {
        this("profsys-9999", "eu", id);
        //this("925842327854", "eu", id);
    }

    public ProcessorName(String projectId, String location, String id) {
        this.projectId = projectId;
        this.location = location;
        this.id = id;
    }

    public String invoice() {
        return url();
    }

    public String ocr() {
        return url();
    }

    public String documentType() {
        return url();
    }

    public String url() {
        return "projects/%s/locations/%s/processors/%s".formatted(projectId, location, id);
    }

    public String receipt() {
        return url();
    }
}
