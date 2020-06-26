package kr.grace.documentManagement.importer;

import kr.grace.documentManagement.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static kr.grace.documentManagement.Attributes.*;

/**
 * @author : Eunmo Hong
 * @since : 2020/06/25
 */

public class ImageImporter implements Importer{


    @Override
    public Document importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "image");

        return new Document(attributes);
    }
}
