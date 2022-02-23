package com.company.ascii_converter;

import com.company.ascii_converter.abst.IAsciiConverter;

public class BasicAsciiConverter implements IAsciiConverter {
    private final static String ASCII_CHARACTERS = "Ñ$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
    private final static String DENSITY = "Ñ@#W$9876543210?!abc;:+=-,._   ";

    public char getChar(int rgbValue) {
        int asciiLength = ASCII_CHARACTERS.length() - 1;
        int charIndex = (int) (Math.ceil(((asciiLength) * rgbValue) / (float) 255));
        int invertedCharIndex = asciiLength - charIndex;
        return ASCII_CHARACTERS.charAt(charIndex);
    }
}
