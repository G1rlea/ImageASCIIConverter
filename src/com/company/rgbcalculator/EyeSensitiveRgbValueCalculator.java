package com.company.rgbcalculator;

import com.company.rgbcalculator.abst.IRgbValueCalculator;

public class EyeSensitiveRgbValueCalculator implements IRgbValueCalculator {
    @Override
    public int getRGBValue(int red, int green, int blue) {
        return  (int)(0.21 * red + 0.72 * green + 0.07 * blue);
    }
}
