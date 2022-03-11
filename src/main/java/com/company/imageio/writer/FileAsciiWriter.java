package com.company.imageio.writer;

import com.company.asciiconverter.abst.AsciiConverter;
import com.company.imageio.writer.abst.AsciiWriter;
import lombok.Builder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAsciiWriter implements AsciiWriter {

    private FileWriter fileWriter;
    private final String filePath;
    private final AsciiConverter asciiConverter;

    @Builder
    private FileAsciiWriter(AsciiConverter asciiConverter, String filePath) {
        this.filePath = filePath;
        this.asciiConverter = asciiConverter;
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
            for (var row: arr) {
                for (int element: row){
                    writer.write(asciiConverter.getChar(element));
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
