package com.example.unitconverterapp.util;

public class LengthConverter {

    public static double getLenResult(String source, String dest, String value) {
        double sourceTempInCelsius = getSourceLenInCM(source, Double.parseDouble(value));
        return getDestLenFromCM(dest, sourceTempInCelsius);
    }

    private static double getSourceLenInCM(String source, double value) {
        switch (source) {
            case "Inch": return value * 2.54;
            case "Foot": return value * 30.48;
            case "Yard": return value * 91.44;
            case "Mile": return value * 1.60934 * 100000;
            case "CM": return value;
            case "KM": return value * 100000;
        }
        return 0;
    }

    private static double getDestLenFromCM(String dest, double value) {
        switch (dest) {
            case "Inch": return value / 2.54;
            case "Foot": return value / 30.48;
            case "Yard": return value / 91.44;
            case "Mile": return (value / 1.60934) / 100000;
            case "CM": return value;
            case "KM": return value / 100000;
        }
        return 0;
    }

    public static boolean isLenUnit(String unit) {
        switch (unit) {
            case "Inch":
            case "Foot":
            case "Yard":
            case "Mile":
            case "CM":
            case "KM":
                return true;
        }
        return false;
    }
}
