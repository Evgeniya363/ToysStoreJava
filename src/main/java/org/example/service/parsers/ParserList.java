package org.example.service.parsers;


import java.util.ArrayList;
import java.util.List;

public class  ParserList {
    private final static List<Parser> parsList;
    private final static int size;

    static {
        parsList = new ArrayList<>();
        parsList.add(new Digits("идентификатор(числовой)"));
        parsList.add(new Digits("частота_выпадания(числовой)"));
        parsList.add(new Symbols("Наименование(строковый)"));


        size = parsList.size();
    }

    public static List<Parser> newList() {
        for(Parser pars : parsList) {
            pars.resetValue();
        }
        return parsList;
    }

    public static int size() {
        return size;
    }

    public static List<String> getNullNames(){
        List<String> list = new ArrayList<>();
        for (Parser pars : parsList) {
            if (pars.getValue() == null)
                list.add(pars.getName());
        }
        return list;
    }
}
