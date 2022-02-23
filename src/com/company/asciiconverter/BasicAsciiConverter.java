package com.company.asciiconverter;

import com.company.asciiconverter.abst.IAsciiConverter;

public class BasicAsciiConverter implements IAsciiConverter {
    private final static String ASCII_CHARACTERS = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'.  ";
    private final static String DENSITY = "Ñ@#W$9876543210?!abc;:+=-,._   ";

    public char getChar(int rgbValue) {
        int asciiLength = ASCII_CHARACTERS.length() - 1;
        int charIndex = (int) (Math.ceil(((asciiLength) * rgbValue) / (float) 255));
//        charIndex = asciiLength - charIndex; // inverts the character
        return ASCII_CHARACTERS.charAt(charIndex);
    }
}
