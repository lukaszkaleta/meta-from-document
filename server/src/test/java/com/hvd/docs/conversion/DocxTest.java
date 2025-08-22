package com.hvd.docs.conversion;

import com.profsys.integrator.common.java.lang.WorkingDirectory;
import com.profsys.integrator.common.java.util.ClassFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class DocxTest {

    @Test
    void sample1() throws IOException {
        InputStream inputStream = new ClassFile(DocxTest.class).fileStreamWithExtension("sample1.docx");
        String result = new WorkingDirectory().filePath("target/result.pdf");
        new Docx().convert(inputStream, result);
    }

    @Test
    void sample2() throws IOException {
        InputStream inputStream = new ClassFile(DocxTest.class).fileStreamWithExtension("sample2.docx");
        String result = new WorkingDirectory().filePath("target/result.pdf");
        new Docx().convert(inputStream, result);
    }

}