package com.company;

import com.company.fileIO.ImageReader;
import com.company.rgb_calculator.EyeSensitiveRgbValueCalculator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ImageReader imageReader = new ImageReader( new EyeSensitiveRgbValueCalculator());
        imageReader.setImagePath("assets/img/pokemon_1.png");
        int[][] ints = imageReader.getRgbValueArray();
        for (var a: ints) {
            System.out.println(Arrays.toString(a));
        }
    }
}
