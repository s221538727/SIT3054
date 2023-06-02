package com.example.unitconverterapp.util;

public class TempConverter {

    public static double getTempResult(String source, String dest, String value) {
        double sourceTempInCelsius = getSourceTempInCelsius(source, Double.parseDouble(value));
        return getDestWtFromCelsius(dest, sourceTempInCelsius);
    }

    private static double getSourceTempInCelsius(String source, double value) {
        switch (source) {
            case "Celsius": return value;
            case "Fahrenheit": return (value - 32) / 1.8;
            case "Kelvin": return value - 273.15;
        }
        return 0;
    }

    private static double getDestWtFromCelsius(String dest, double value) {
        switch (dest) {
            case "Celsius": return value;
            case "Fahrenheit": return (value * 1.8) + 32;
            case "Kelvin": return value + 273.15;
        }
        return 0;
    }

    public static boolean isTempUnit(String unit) {
        switch (unit) {
            case "Celsius":
            case "Fahrenheit":
            case "Kelvin": return true;
        }
        return false;
    }
}
