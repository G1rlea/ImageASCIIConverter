package com.company.imageio;

import com.company.asciiconverter.abst.IAsciiConverter;
import com.company.imageio.abst.AsciiWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAsciiWriter implements AsciiWriter {

    private FileWriter fileWriter;
    private final String filePath;
    private final IAsciiConverter AsciiConverter;

    public FileAsciiWriter(IAsciiConverter asciiConverter, String filePath) {
        this.filePath = filePath;
        this.AsciiConverter = asciiConverter;
        try {
            this.fileWriter = new FileWriter("assets/ascii_img/" + getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName(){
        int slashIndex = filePath.lastIndexOf('/') + 1;
        int pointIndex = filePath.lastIndexOf('.') + 1;
        return filePath.substring(slashIndex, pointIndex) + "txt";
    }

    public void writeAsciiImage(int[][] arr){
        BufferedWriter writer = new BufferedWriter(fileWriter);
        try {
            for (var a: arr) {
                for (int aa: a){
                    writer.write(AsciiConverter.getChar(aa));
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
