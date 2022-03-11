package com.company;

import com.company.asciiconverter.BasicAsciiConverter;
import com.company.asciiconverter.data.AsciiCharactersDensity;
import com.company.imageio.writer.FileAsciiWriter;
import com.company.imageio.reader.ImageReader;
import com.company.imageio.writer.abst.AsciiWriter;
import com.company.rgbcalculator.EyeSensitiveRgbValueCalculator;

//God object
public class ImageAsciiConverter {

    public static void convert(String filePath) {

        ImageReader reader = ImageReader.builder()
                .calculator(new EyeSensitiveRgbValueCalculator())
                .filePath(filePath)
                .build();

        AsciiWriter fileWriter = FileAsciiWriter.builder()
                .asciiConverter(new BasicAsciiConverter(AsciiCharactersDensity.LOW_DENSITY))
                .filePath(filePath)
                .build();

        var pixelRgbValues = reader.getRgbValueArray();
        fileWriter.writeAsciiImage(pixelRgbValues);
    }
}
