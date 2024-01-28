package org.example.service.parsers;

public class Symbols extends Parser<String> {

    Symbols(String name) {
        super(name);
    }

    @Override
    public boolean parseToClass(String str) {
        if (str != null && !str.isEmpty() ) {
            setValue(str);
            return true;
        } else {
            return false;
        }
    }

}
