package org.example.service.parsers;

public class Digits extends Parser<Integer> {
    Digits(String name) {
        super(name);
    }

    @Override
    public boolean parseToClass(String str) {

        if (str != null && str.chars().allMatch(Character::isDigit)) {
            setValue(Integer.parseInt(str));
            return true;
        } else {
            return false;
        }

    }

}
