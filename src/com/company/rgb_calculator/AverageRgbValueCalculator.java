package com.company.rgb_calculator;

import com.company.rgb_calculator.abst.IRgbValueCalculator;

public class AverageRgbValueCalculator implements IRgbValueCalculator {

    @Override
    public int getRGBValue(int red, int green, int blue) {
        return (red + green + blue) / 3;
    }

}
