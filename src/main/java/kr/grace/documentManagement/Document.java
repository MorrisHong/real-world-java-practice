package kr.grace.documentManagement;

import kr.grace.documentManagement.importer.Importer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/25
 */

public class Document {
    private final Map<String, String> attributes;

    public Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
