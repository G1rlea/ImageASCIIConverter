package com.company.fileIO;

import com.company.ascii_converter.abst.IAsciiConverter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AsciiFileWriter {
    FileWriter fileWriter;
    IAsciiConverter AsciiConverter;

    public AsciiFileWriter(IAsciiConverter asciiConverter) {
        this.AsciiConverter = asciiConverter;
        try {
            this.fileWriter = new FileWriter("assets/ascii_img/ASCII_img.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
