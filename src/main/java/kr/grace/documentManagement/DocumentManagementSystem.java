package kr.grace.documentManagement;

import kr.grace.documentManagement.importer.ImageImporter;
import kr.grace.documentManagement.importer.Importer;
import kr.grace.documentManagement.importer.LetterImporter;
import kr.grace.documentManagement.importer.ReportImporter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/25
 */

public class DocumentManagementSystem {
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("jpg", new ImageImporter());
    }
}
