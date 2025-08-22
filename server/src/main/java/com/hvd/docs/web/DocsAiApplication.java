package com.hvd.docs.web;

import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.hvd.docs.google.document.ai.DocumentAiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hvd.docs")
public class DocsAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocsAiApplication.class, args);
	}

	@Bean
	public DocumentProcessorServiceClient documentProcessorServiceClient() {
		return new DocumentAiClient().get();
	}
}
