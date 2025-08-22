package com.hvd.docs.web.payload;

public class InputDocument {

    private String id;
    private String url;
    private String fileName;
    private String contentType;

    public String id() {
        return id;
    }

    public String url() {
        return url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String contentType() {
        return contentType;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public static InputDocument fromLocalFile(String result, String contentType, InputDocument inputDocument) {
        InputDocument localFileInputDocument = new InputDocument();
        localFileInputDocument.setUrl(result);
        localFileInputDocument.setId(inputDocument.id);
        localFileInputDocument.setContentType(contentType);
        return localFileInputDocument;
    }

    public String fileName() {
        return fileName;
    }
}
