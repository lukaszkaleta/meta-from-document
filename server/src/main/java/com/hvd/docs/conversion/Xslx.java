package com.hvd.docs.conversion;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Xslx implements Converter {

    private final Logger log = LoggerFactory.getLogger(Xslx.class);
    @Override
    public void convert(InputStream inputStream, String result) throws IOException {
        try (OutputStream pdfOutputStream = new FileOutputStream(result);) {
            OPCPackage d= null;
            try {
                d = OPCPackage.open(inputStream);
            } catch (InvalidFormatException e) {
                throw new RuntimeException(e);
            }
            XSSFWorkbook wb = new XSSFWorkbook(d);
            XSSFExcelExtractor extractor = new XSSFExcelExtractor(wb);
            extractor.setFormulasNotResults(true);
            extractor.setIncludeSheetNames(false);
            String text = extractor.getText().replaceAll("\\t"," ").replaceAll("%","");

            new JustText().asPdf(pdfOutputStream, text);
        } catch (Exception e) {
            log.error("{}", e.getMessage(), e);
        }

    }
}
