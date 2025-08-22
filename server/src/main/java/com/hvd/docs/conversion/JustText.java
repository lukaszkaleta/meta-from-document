package com.hvd.docs.conversion;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.profsys.integrator.common.java.lang.string.StringInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JustText implements Converter {

    public void convert(InputStream inputStream, String result) throws IOException {
        try (OutputStream pdfOutputStream = new FileOutputStream(result);) {
            String text = new StringInputStream(inputStream).read();
            this.asPdf(pdfOutputStream, text);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void asPdf(OutputStream pdfOutputStream, String text) throws DocumentException {
        Document pdfDocument = new Document();
        PdfWriter.getInstance(pdfDocument, pdfOutputStream);
        pdfDocument.open();
        pdfDocument.add(new Paragraph(text));
        pdfDocument.close();
    }
}
