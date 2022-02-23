package com.company;

import com.company.service.EyeSensitiveRgbValueCalculator;

public class Main {

    public static void main(String[] args) {
        ImageReader imageReader = new ImageReader("assets/img/pokemon_1.png", new EyeSensitiveRgbValueCalculator());
        imageReader.printAsciiImage();
    }
}
