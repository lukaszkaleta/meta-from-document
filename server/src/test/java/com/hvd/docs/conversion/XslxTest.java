package com.hvd.docs.conversion;

import com.profsys.integrator.common.java.lang.WorkingDirectory;
import com.profsys.integrator.common.java.util.ClassFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class XslxTest {

    @Test
    void sample1() throws IOException {
        InputStream inputStream = new ClassFile(XslxTest.class).fileStreamWithExtension("sample1.xlsx");
        String result = new WorkingDirectory().filePath("target/result.pdf");
        new Xslx().convert(inputStream, result);
    }
}