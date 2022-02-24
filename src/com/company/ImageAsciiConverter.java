package com.company;

import com.company.asciiconverter.BasicAsciiConverter;
import com.company.fileio.AsciiFileWriter;
import com.company.fileio.ImageReader;
import com.company.rgbcalculator.EyeSensitiveRgbValueCalculator;

//God object
public class ImageAsciiConverter {

    private final String filePath;

    public ImageAsciiConverter(String filePath){
        this.filePath = filePath;
    }

    public void convert(){
        ImageReader imageReader = new ImageReader( new EyeSensitiveRgbValueCalculator(), filePath);
        var pixelRgbValues = imageReader.getRgbValueArray();

        AsciiFileWriter fileWriter = new AsciiFileWriter(new BasicAsciiConverter(), filePath);
        fileWriter.writeAsciiImage(pixelRgbValues);

    }
}
