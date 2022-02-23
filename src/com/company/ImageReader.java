package com.company;

import com.company.entity.PixelRGB;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {
    private static String ASCII_CHARACTERS = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'.";
    static File file;
    BufferedImage image;

    public ImageReader(String filePath) {
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

    public PixelRGB getRGBValue(){


        for (int y = 0; y < image.getHeight(); y++){
            for (int x = 0; x < image.getWidth(); x++){
                int rgb = image.getRGB(x, y);
                int lum = (rgb >> 24) & 0xff;
                int red = (rgb>>16) & 0xff;
                int green = (rgb>>8) & 0xff;
                int blue = rgb & 0xff;
                int med = (int) (0.21 * red + 0.72 * green + 0.07 * blue);
//                int med = (red + blue + green) / 3;
                System.out.print( getChar(med) + " ");
            }
            System.out.println();
        }
//        System.out.println("Lum " + lum);
//        System.out.println("Red " + red);
//        System.out.println("Green " + green);
//        System.out.println("Blue " + blue);

        return new PixelRGB(0, 0, 0);
    }

    public void printImageSize() {
        float rbgValue = 123;
        System.out.println();


//        System.out.println(file.canRead());
//        System.out.printf("Height: %d\n", image.getHeight());
//        System.out.printf("Width: %d\n", image.getWidth());
    }

    private char getChar(int rgbValue){
        int charIndex = (ASCII_CHARACTERS.length() - 1) - (int) Math.ceil(((ASCII_CHARACTERS.length() - 1) * rgbValue) / (float) 255);
        return ASCII_CHARACTERS.charAt(charIndex);
    }

}
