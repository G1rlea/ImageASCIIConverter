package com.company;

import com.company.asciiconverter.BasicAsciiConverter;
import com.company.fileio.AsciiFileWriter;
import com.company.fileio.ImageReader;

//God object
public class ImageAsciiConverter {

    private final String filePath;

    public ImageAsciiConverter(String filePath){
        this.filePath = filePath;
    }

    public void convert(){
        ImageReader imageReader = new ImageReader( (a,b,c) -> (a+b+c) / 3 , filePath);
        int[][] rgbValueArray = imageReader.getRgbValueArray();

        AsciiFileWriter fileWriter = new AsciiFileWriter(new BasicAsciiConverter(), filePath);
        fileWriter.writeAsciiImage(rgbValueArray);

    }
}
