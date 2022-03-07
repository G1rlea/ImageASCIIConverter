package com.company.rgbcalculator;

import com.company.rgbcalculator.abst.IRgbValueCalculator;

public class AverageRgbValueCalculator implements IRgbValueCalculator {

    @Override
    public int getRGBValue(int red, int green, int blue) {
        return (red + green + blue) / 3;
    }

}
