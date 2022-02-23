package com.company;

import com.company.ascii_converter.BasicAsciiConverter;
import com.company.fileIO.AsciiFileWriter;
import com.company.fileIO.ImageReader;
import com.company.rgb_calculator.EyeSensitiveRgbValueCalculator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ImageReader imageReader = new ImageReader( new EyeSensitiveRgbValueCalculator());
        imageReader.setImagePath("assets/img/vdovi.png");
        int[][] rgbValueArray = imageReader.getRgbValueArray();

        AsciiFileWriter fileWriter = new AsciiFileWriter(new BasicAsciiConverter());
        fileWriter.writeAsciiImage(rgbValueArray);


    }
}
