package com.company.asciiconverter.data;

public enum AsciiCharactersDensity {
    HIGH_DENSITY("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'."),
    MEDIUM_DENSITY("Ñ@#W$9876543210?!abc;:+=-,._   "),
    LOW_DENSITY("Wwli:,. ");

    private final String density;

    AsciiCharactersDensity(String density) {
        this.density = density;
    }

    public String getDensity(){
        return density;
    }

}
