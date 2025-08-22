package com.hvd.docs.conversion;

import com.profsys.integrator.common.java.io.UrlAccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputDocumentStream {

    private final String url;
    public InputDocumentStream(String url) {
        this.url = url;
    }

    public InputStream get() {
        if (url.startsWith("http")) {
            try {
                return new UrlAccess(url).stream();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                return new FileInputStream(url);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
