package com.hvd.docs.web;

public class ProcessContext {

    private final long started;
    public ProcessContext() {
        this.started = System.nanoTime();
    }

    public long time() {
        return System.nanoTime() - started;
    }
}
