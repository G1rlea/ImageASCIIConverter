package com.company;

import com.company.asciiconverter.BasicAsciiConverter;
import com.company.fileio.AsciiFileWriter;
import com.company.fileio.ImageReader;
import com.company.rgbcalculator.EyeSensitiveRgbValueCalculator;

//God object
public class ImageAsciiConverter {

    public static void convert(String filePath) {
        ImageReader imageReader = new ImageReader(new EyeSensitiveRgbValueCalculator(), filePath);
        AsciiFileWriter fileWriter = new AsciiFileWriter(new BasicAsciiConverter(), filePath);

        var pixelRgbValues = imageReader.getRgbValueArray();
        fileWriter.writeAsciiImage(pixelRgbValues);
    }
}
