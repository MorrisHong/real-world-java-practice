package kr.grace.documentManagement.importer;

import kr.grace.documentManagement.Document;

import java.io.File;
import java.io.IOException;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/25
 */

public interface Importer {
    Document importFile(File file) throws IOException;
}
