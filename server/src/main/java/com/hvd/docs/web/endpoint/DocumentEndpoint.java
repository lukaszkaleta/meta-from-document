package com.hvd.docs.web.endpoint;

import com.hvd.docs.conversion.Conversion;
import com.hvd.docs.google.document.ai.processor.DocumentClassificator;
import com.hvd.docs.google.document.ai.processor.Invoice;
import com.hvd.docs.google.document.ai.processor.Receipt;
import com.hvd.docs.web.DocumentTask;
import com.hvd.docs.web.ProcessContext;
import com.hvd.docs.web.payload.InputDocument;
import com.hvd.docs.web.payload.OutputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentEndpoint {

	private final DocumentTask documentTask;

	@Autowired
	public DocumentEndpoint(DocumentTask documentTask) {
		this.documentTask = documentTask;
	}

	@PostMapping("/process")
    public ResponseEntity<OutputDocument> process(@RequestBody InputDocument inputDocument) {
		ProcessContext processContext = new ProcessContext();
		OutputDocument execute = documentTask.execute(inputDocument, processContext);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

	@PostMapping("/process/{type}")
	public ResponseEntity<OutputDocument> process(
			@RequestBody InputDocument inputDocument,
			@PathVariable String type) {
		ProcessContext processContext = new ProcessContext();
		OutputDocument execute = documentTask.execute(inputDocument, type, processContext);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
