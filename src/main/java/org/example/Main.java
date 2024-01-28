package org.example;

import org.example.service.Service;
import org.example.service.exception.ParseImpossibleException;

public class Main {
    public static void main(String[] args) throws ParseImpossibleException {
        String[] str = {
                "1, 2, Конструктор",
                "2, 3, Робот",
                "3, 5, Kукла"
        };
        new Service(str);
    }
}