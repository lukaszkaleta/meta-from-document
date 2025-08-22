package com.hvd.docs.web.endpoint;

import com.hvd.docs.conversion.Conversion;
import com.hvd.docs.google.document.ai.processor.DocumentClassificator;
import com.hvd.docs.google.document.ai.processor.Invoice;
import com.hvd.docs.google.document.ai.processor.Receipt;
import com.hvd.docs.web.DocumentTask;
import com.hvd.docs.web.ProcessContext;
import com.hvd.docs.web.payload.InputDocument;
import com.hvd.docs.web.payload.InputDocuments;
import com.hvd.docs.web.payload.OutputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class DocumentBatchEndpoint {

    ExecutorService sseMvcExecutor = Executors.newCachedThreadPool();

    private final DocumentTask documentTask;

    @Autowired
    public DocumentBatchEndpoint(DocumentTask documentTask) {
        this.documentTask = documentTask;
    }

    /**
     *
     */
    @PostMapping("/batch/process")
    public SseEmitter process(@RequestBody InputDocuments inputDocuments) {
        SseEmitter emitter = new SseEmitter();
        sseMvcExecutor.execute(() -> {
            try {
                List<InputDocument> docs = inputDocuments.getList();
                for(InputDocument inputDocument : docs) {
                    ProcessContext processContext = new ProcessContext();
                    OutputDocument execute = documentTask.execute(inputDocument, processContext);
                    emitter.send(execute);
                }
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }

    @PostMapping("/batch/process/{type}")
    public SseEmitter processType(@RequestBody InputDocuments inputDocuments, @PathVariable String type) {
        SseEmitter emitter = new SseEmitter();
        sseMvcExecutor.execute(() -> {
            try {
                List<InputDocument> docs = inputDocuments.getList();
                for(InputDocument inputDocument : docs) {
                    ProcessContext processContext = new ProcessContext();
                    OutputDocument execute = documentTask.execute(inputDocument, type, processContext);
                    emitter.send(execute);
                }
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }
}
