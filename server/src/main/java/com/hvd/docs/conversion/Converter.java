package com.hvd.docs.conversion;

import java.io.IOException;
import java.io.InputStream;

public interface Converter {

    void convert(InputStream inputStream, String result) throws IOException;
}
