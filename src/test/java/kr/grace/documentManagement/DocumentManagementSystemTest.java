package kr.grace.documentManagement;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/26
 */

class DocumentManagementSystemTest {

    private static final String RESOURCES =
            "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE_BLOGGS = "Joe Bloggs";


    DocumentManagementSystem system = new DocumentManagementSystem();

    @Test
    void shouldImportFile() throws Exception {
        system.importFile(LETTER);

        Document document = onlyDocument();

        assertAttributeEquals(LETTER, document, Attributes.PATH);
    }

    private void assertAttributeEquals(String expectedValue, Document document, String attributeName) {
        assertEquals(
                expectedValue,
                document.getAttribute(attributeName),
                "Document has the wrong value for " + attributeName
        );
    }

    private Document onlyDocument() {
        List<Document> documents = system.contents();
        assertEquals(1, documents.size());
        return documents.get(0);
    }

}