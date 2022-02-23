package com.company.service;

import com.company.service.abst.IRgbValueCalculator;

public class AverageRgbValueCalculator implements IRgbValueCalculator {

    @Override
    public int getRGBValue(int red, int green, int blue) {
        return (red + green + blue) / 3;
    }

}
