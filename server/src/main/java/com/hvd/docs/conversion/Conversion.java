package com.hvd.docs.conversion;

import com.hvd.docs.web.payload.InputDocument;
import com.profsys.integrator.common.java.io.FileName;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
public class Conversion {

    //JPEG, JPG, PNG, BMP, PDF, TIFF, TIF, GIF
    private static Set<String> supportedOutOfTheBox = Set.of(
            "application/pdf",
            "image/jpg",
            "image/jpeg",
            "image/png",
            "image/bmp",
            "image/tiff",
            "image/tif",
            "image/gif"
    );

    private static Map<String, String> fileExtensionMap = Map.of(
            "pdf", "application/pdf",
            "jpg", "image/jpeg",
            "jpeg", "image/jpeg",
            "png", "image/png",
            "bmp", "image/bmp",
            "tiff", "image/tiff",
            "tif", "image/tif",
            "gif", "image/gif",
            "docx","application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "xlsx","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
    );

    private static Map<String, Converter> converterMap = new HashMap<>();
    static {
        converterMap.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", new Docx());
        converterMap.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", new Xslx());
    }

    public Optional<Converter> converter(InputDocument inputDocument) {
        String contentType = inputDocument.contentType();
        if (contentType == null || contentType.isBlank()) {
            contentType = fileExtensionMap.get(new FileName(inputDocument.fileName()).extension());
            inputDocument.setContentType(contentType);
        }

        if (supportedOutOfTheBox.contains(contentType)) {
            return Optional.empty();
        }

        Converter converter = converterMap.get(contentType);
        if (converter == null) {
            converter = new JustText();
        }
        return Optional.of(converter);
    }
}
