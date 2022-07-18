package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageReader implements FileWriter{

    public BufferedImage image;
    public ImageReader(BufferedImage image){
        this.image = image;
    }
    @Override
    public void write(BufferedImage bufferedImage) throws IOException {

    }

    @Override
    public void read(BufferedImage bufferedImage, URL imageUrl) throws IOException {
        final Class<Main> mainClass = Main.class;

        bufferedImage = ImageIO.read(imageUrl);

    }
}
