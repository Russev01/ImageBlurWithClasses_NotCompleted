package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Arrays;

/**
 * @author Miroslav Kovachev
 * ${DATE}
 * Methodia Inc.
 */
public class Main {

    public static void main(String[] args) {
        try {
            final Class<Main> mainClass = Main.class;
            final ClassLoader classLoader = mainClass.getClassLoader();
            final URL imageUrl = classLoader.getResource("download.jpg");
            final BufferedImage bufferedImage = ImageIO.read(imageUrl);

            final int height = bufferedImage.getHeight();
            final int width = bufferedImage.getWidth();
            final int rgb = bufferedImage.getRGB(0, 0);
            int blurRadius = 2;

            final BufferedImage blurredImage = new BufferedImage(width, height, bufferedImage.getType());
            //----------------------------------------------------------------------------------------------
            AveragingBlur averaging = new AveragingBlur(bufferedImage);
            averaging.getBlurred (bufferedImage, width, height, blurRadius, blurredImage);
            //------------------------------------------------------------------------------------------------
            final String outputPath = classLoader.getResource("").getPath();
            final File outputFile = new File(outputPath + "/blurred.jpg");
            //-------------------------------------------------------------------------------------------------
            FileImageWriter fileWriter = new FileImageWriter(outputFile);
            fileWriter.write(blurredImage);
            //-------------------------------------------------------------------------------------------------

        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

}