package org.example.service.exception;

public class NullArrayException extends RuntimeException {
    public NullArrayException() {
        super("Массив не может иметь значение null");
    }
}
