package com.hvd.docs.conversion;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Docx implements Converter {

    public void convert(InputStream inputStream, String result) throws IOException {
        try (XWPFDocument document = new XWPFDocument(inputStream); OutputStream pdfOutputStream = new FileOutputStream(result);) {
            XWPFWordExtractor ext = new XWPFWordExtractor(document);
            String text = ext.getText();
            Document pdfDocument = new Document();
            PdfWriter.getInstance(pdfDocument, pdfOutputStream);
            pdfDocument.open();
            pdfDocument.add(new Paragraph(text));
            pdfDocument.close();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
