package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileImageWriter implements FileWriter {

    public File file;
    public FileImageWriter(File file){
    this.file = file;
    }
    @Override
    public void write(BufferedImage bufferedImage) throws IOException {
        final FileOutputStream blurredImageOutputStream = new FileOutputStream(file);
        ImageIO.write(bufferedImage, "jpg", blurredImageOutputStream);
    }

    @Override
    public void read(BufferedImage bufferedImage, URL imageUrl) throws IOException {
        final Class<Main> mainClass = Main.class;

        bufferedImage = ImageIO.read(imageUrl);
    }

}

