package com.company;

import com.company.asciiconverter.BasicAsciiConverter;
import com.company.asciiconverter.data.AsciiCharactersDensity;
import com.company.imageio.FileAsciiWriter;
import com.company.imageio.ImageReader;
import com.company.imageio.abst.AsciiWriter;
import com.company.rgbcalculator.EyeSensitiveRgbValueCalculator;

//God object
public class ImageAsciiConverter {

    public static void convert(String filePath) {
        ImageReader imageReader = new ImageReader(new EyeSensitiveRgbValueCalculator(), filePath);
        AsciiWriter fileWriter = new FileAsciiWriter(new BasicAsciiConverter(AsciiCharactersDensity.LOW_DENSITY), filePath);

        var pixelRgbValues = imageReader.getRgbValueArray();
        fileWriter.writeAsciiImage(pixelRgbValues);
    }
}
