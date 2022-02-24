package com.company.fileio;

import com.company.rgbcalculator.abst.IRgbValueCalculator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    private final static int MAXIMUM_IMAGE_LENGTH_IN_PIXELS = 150;
    private final IRgbValueCalculator rgbValueCalculator;

    private int imageWidth;
    private int imageHeight;
    private BufferedImage image;

    public ImageReader(IRgbValueCalculator calculator, String filePath) {
        File file = instantiateFile(filePath);
        this.image = convertFileToImage(file);
        this.rgbValueCalculator = calculator;
        this.imageHeight = image.getHeight();
        this.imageWidth = image.getWidth();
    }



    private BufferedImage resizeImage() {
        calculateImageHeightAndWidth();

        Image resultingImage = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    //TODO: Fix problem with scaling
    private void calculateImageHeightAndWidth() {
//        float scale;
//        if (imageWidth > imageHeight){
//            scale = (float) (((float)imageWidth / (float)imageHeight) + 0.10);
//            this.imageWidth = MAXIMUM_IMAGE_LENGTH_IN_PIXELS;
//            this.imageHeight = (int)(MAXIMUM_IMAGE_LENGTH_IN_PIXELS / scale);
//        }
//        else{
//            scale = (float) ((float)(imageHeight / imageWidth) + 0.10);
//            this.imageWidth = (int)(MAXIMUM_IMAGE_LENGTH_IN_PIXELS / scale);
//            this.imageHeight = MAXIMUM_IMAGE_LENGTH_IN_PIXELS;
//        }
        this.imageWidth = MAXIMUM_IMAGE_LENGTH_IN_PIXELS;
        this.imageHeight = MAXIMUM_IMAGE_LENGTH_IN_PIXELS;
    }

    private BufferedImage convertFileToImage(File file) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private boolean isImageTooBig() {
        return imageHeight > MAXIMUM_IMAGE_LENGTH_IN_PIXELS || imageWidth > MAXIMUM_IMAGE_LENGTH_IN_PIXELS;
    }


    private File instantiateFile(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public int[][] getRgbValueArray() {
        if (isImageTooBig())
            image = resizeImage();

        int[][] arr = new int[imageHeight][imageWidth];

        for (int y = 0; y < imageWidth; y++) {
            for (int x = 0; x < imageHeight; x++) {
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
