package com.company;

import com.company.service.abst.IRgbValueCalculator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    private static String ASCII_CHARACTERS = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
    static File file;
    BufferedImage image;
    IRgbValueCalculator rgbValueCalculator;

    public ImageReader(String filePath, IRgbValueCalculator calculator) {
        this.rgbValueCalculator = calculator;
        instantiateFile(filePath);
        convertFileToImage();
    }

    private void convertFileToImage() {
        try {
            image = ImageIO.read(file);
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

    public void printAsciiImage(){
        for (int y = 0; y < image.getHeight(); y++){
            for (int x = 0; x < image.getWidth(); x++){
                int rgb = image.getRGB(x, y);
                int red = (rgb>>16) & 0xff;
                int green = (rgb>>8) & 0xff;
                int blue = rgb & 0xff;
                System.out.print( getChar(rgbValueCalculator.getRGBValue(red, green, blue)) + " ");
            }
            System.out.println();
        }
    }


    private char getChar(int rgbValue){
        int charIndex = (ASCII_CHARACTERS.length() - 1) - (int) Math.ceil(((ASCII_CHARACTERS.length() - 1) * rgbValue) / (float) 255);
        return ASCII_CHARACTERS.charAt(charIndex);
    }

}
