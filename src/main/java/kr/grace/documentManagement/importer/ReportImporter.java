package kr.grace.documentManagement.importer;

import kr.grace.documentManagement.Document;
import kr.grace.documentManagement.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static kr.grace.documentManagement.Attributes.*;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/25
 */

public class ReportImporter implements Importer {

    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLines(2, line -> false, BODY);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "REPORT");
        return new Document(attributes);
    }
}
