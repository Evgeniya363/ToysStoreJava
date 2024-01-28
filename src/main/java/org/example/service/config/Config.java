package org.example.service.config;

public class Config {
    private static int sizeArray = 3;
    private static int prizesNumber = 10;
    private static String path = "result.txt";

    public static void setSizeArray(int sizeArrayNew) {
        sizeArray = sizeArrayNew;
    }

    public static void setPrizesNumber(int prizesNewNumber) {
        prizesNumber = prizesNewNumber;
    }

    public static int getSizeArray() {
        return sizeArray;
    }

    public static int getPrizesNumber() {
        return prizesNumber;
    }

    public static void setPath(String path) {
        Config.path = path;
    }

    public static String getPath() {
        return path;
    }
}
