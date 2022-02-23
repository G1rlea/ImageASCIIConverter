package com.company.fileIO;

import com.company.rgb_calculator.abst.IRgbValueCalculator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    private final static int TARGET_WIDTH = 100;
    private final static int TARGET_HEIGHT = 100;
    private final IRgbValueCalculator rgbValueCalculator;

    private File file;
    private BufferedImage image;

    public ImageReader(IRgbValueCalculator calculator) {
        this.rgbValueCalculator = calculator;
    }

    public void setImagePath(String filePath) {
        instantiateFile(filePath);
        convertFileToImage();
    }

    private BufferedImage resizeImage(){
        BufferedImage resizedImage = new BufferedImage(TARGET_WIDTH, TARGET_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, TARGET_WIDTH, TARGET_HEIGHT, null);
        graphics2D.dispose();
        return resizedImage;
    }

    private void convertFileToImage() {
        try {
            image = ImageIO.read(file);
            image = resizeImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void instantiateFile(String filePath) {
        try {
            file = new File(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[][] getRgbValueArray() {
        int[][] arr = new int[image.getHeight()][image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = (rgb) & 0xff;
                arr[y][x] = rgbValueCalculator.getRGBValue(red, green, blue);
            }
        }
        return arr;
    }
}
