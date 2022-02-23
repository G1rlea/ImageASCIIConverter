package com.company;

public class Main {

    public static void main(String[] args) {
        ImageReader imageReader = new ImageReader("assets/img/amungus.jpg");
        imageReader.printImageSize();
        imageReader.getRGBValue();
    }
}
