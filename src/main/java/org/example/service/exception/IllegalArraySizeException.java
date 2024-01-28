package org.example.service.exception;

public class IllegalArraySizeException extends RuntimeException{

    public IllegalArraySizeException() {
        super("Неверная длина массива");
    }
    public IllegalArraySizeException(int size) {
        super("Неверная длина массива" + ": " + size);
    }

    public IllegalArraySizeException(int size, int minSize) {
        super("Неверная длина массива: " + size +
                "Минимальная длина: " +minSize);
    }
}
