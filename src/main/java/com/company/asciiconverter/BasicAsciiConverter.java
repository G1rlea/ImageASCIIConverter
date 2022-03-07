package com.company.asciiconverter;

import com.company.asciiconverter.abst.IAsciiConverter;
import com.company.asciiconverter.data.AsciiCharactersDensity;

public class BasicAsciiConverter implements IAsciiConverter {

    private final String asciiCharactersDensity;

    public BasicAsciiConverter(AsciiCharactersDensity asciiCharactersDensity) {
        this.asciiCharactersDensity = asciiCharactersDensity.getDensity();
    }

    public BasicAsciiConverter(){
        this.asciiCharactersDensity = AsciiCharactersDensity.HIGH_DENSITY.getDensity();
    }

    @Override
    public char getChar(int rgbValue) {
        int asciiLength = asciiCharactersDensity.length() - 1;
        int charIndex = (int) (Math.ceil(((asciiLength) * rgbValue) / (float) 255));
//        charIndex = asciiLength - charIndex; // inverts the character in the opposite side
        return asciiCharactersDensity.charAt(charIndex);
    }
}
