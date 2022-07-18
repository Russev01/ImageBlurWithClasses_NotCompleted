package org.example;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public interface FileWriter {
    void write(BufferedImage bufferedImage) throws IOException;
    void read(BufferedImage bufferedImage, URL imageUrl) throws IOException;
}
