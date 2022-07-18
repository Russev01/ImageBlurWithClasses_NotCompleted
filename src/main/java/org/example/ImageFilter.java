package org.example;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ImageFilter {

    int blurImage(BufferedImage bufferedImage, int x, int y, int z) throws IOException;
    void getBlurred (BufferedImage bufferedImage, int width, int height, int blurRadius, BufferedImage blurredImage)
            throws IOException;
}
