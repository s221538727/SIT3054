package com.example.unitconverterapp.util;

public class WeightConverter {

    public static double getWeightResult(String source, String dest, String value) {
        double sourceWtInKg = getSourceWtInKg(source, Double.parseDouble(value));
        return getDestWtFromKg(dest, sourceWtInKg);
    }

    private static double getSourceWtInKg(String source, double value) {
        switch (source) {
            case "Pound": return 0.453592 * value;
            case "KG": return value;
            case "Ounce": return .0283495 * value;
            case "Ton": return 907.185 * value;
        }
        return 0;
    }

    private static double getDestWtFromKg(String dest, double value) {
        switch (dest) {
            case "Pound": return value/0.453592;
            case "KG": return value;
            case "Ounce": return value/.0283495;
            case "Ton": return value/907.185;
        }
        return 0;
    }

    public static boolean isWeightUnit(String unit) {
        switch (unit) {
            case "Pound":
            case "KG":
            case "Ounce":
            case "Ton":
                return true;
        }
        return false;
    }
}
