package com.company.rgbcalculator;

import com.company.rgbcalculator.abst.RgbValueCalculator;

public class AverageRgbValueCalculator implements RgbValueCalculator {

    @Override
    public int getRGBValue(int red, int green, int blue) {
        return (red + green + blue) / 3;
    }

}
