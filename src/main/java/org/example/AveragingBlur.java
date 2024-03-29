package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AveragingBlur implements ImageFilter {
    public BufferedImage file;
    public AveragingBlur(BufferedImage file){
        this.file = file;
    }
    @Override
    public int blurImage(BufferedImage image, int x, int y, int radius){
        int side = radius * 2 + 1;
        int pixelCount = side * side - 1;
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        float brightnessSum = 0.0f;


        for (int row = -radius; row <= radius; row++) {
            for (int col = -radius; col <= radius; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }
                final int rgb = image.getRGB(x + col, y + row);
                final Color color = new Color(rgb);

                final float[] hsbColor =
                        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                final float brightness = hsbColor[2];
                brightnessSum += brightness;
                //                int red = rgb & 0xFF_00_00;
                //                int green = rgb & 0x00_FF_00;
                //                int blue = rgb & 0x00_00_FF;
                //                redSum += red;
                //                greenSum += green;
                //                blueSum += blue;
            }
        }

//        final int redAvg = redSum / pixelCount;
//        final int greenAvg = greenSum / pixelCount;
//        final int blueAvg = blueSum / pixelCount;
//        int newRgb = redAvg | greenAvg | blueAvg;
//        final int newRgbPadded = newRgb | 0xFF_00_00_00;
        final float brightnessAvg = brightnessSum / pixelCount;
        final int currentPixel = image.getRGB(x, y);
        final Color currentPxColor = new Color(currentPixel);
        final float[] currentPxHsb = Color.RGBtoHSB(currentPxColor.getRed(), currentPxColor.getGreen(),
                currentPxColor.getBlue(), null);
        currentPxHsb[2] = brightnessAvg;
        final int calcuatedPixel = Color.HSBtoRGB(currentPxHsb[0], currentPxHsb[1], currentPxHsb[2]);
        return calcuatedPixel;
    }
@Override
    public void getBlurred (BufferedImage bufferedImage, int width, int height, int blurRadius, BufferedImage blurredImage) {
        AveragingBlur averaging = new AveragingBlur(bufferedImage);
        for (int x = blurRadius; x < width - blurRadius; x++) {
            for (int y = blurRadius; y < height - blurRadius; y++) {
                blurredImage.setRGB(x, y, averaging.blurImage(bufferedImage, x, y, blurRadius));
            }
        }
    }

    }

