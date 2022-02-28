package com.company;

import com.company.asciiconverter.BasicAsciiConverter;
import com.company.imageio.ImageWritter;
import com.company.imageio.ImageReader;
import com.company.rgbcalculator.EyeSensitiveRgbValueCalculator;

//God object
public class ImageAsciiConverter {

    public static void convert(String filePath) {
        ImageReader imageReader = new ImageReader(new EyeSensitiveRgbValueCalculator(), filePath);
        ImageWritter fileWriter = new ImageWritter(new BasicAsciiConverter(), filePath);

        var pixelRgbValues = imageReader.getRgbValueArray();
        fileWriter.writeAsciiImage(pixelRgbValues);
    }
}
