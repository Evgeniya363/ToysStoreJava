package org.example.service;

import org.example.model.Toy;
import org.example.service.exception.ParseImpossibleException;
import org.example.service.parsers.Parser;
import org.example.service.parsers.ParserList;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    /**
     * Метод CreateHuman пробует распарсить слова из переданного списка
     * в объекты, перечисленные в классе ParserList, в случае успеха
     * возвращается ссылка на объект класса Human. В противном случае
     * выбрасывается исключение ParseImpossibleException
     *
     * @return ссылка на объект типа Human
     */
    public static Toy CreateToy(List<String> inputlist) throws ParseImpossibleException {

        List<Parser> parsList = ParserList.newList();
        List<String> list = new ArrayList<>(inputlist);

        /*Значение каждого валидного элемента list
        сохраняем в поле value соответствующего элемента parsList,
        после чего элемент удаляем из списка переданных параметров*/
        for (Parser pars : parsList) {
            for (String str : list) {
                if (pars.parseToClass(str.trim())) {
                    list.remove(str);
                    break;
                }
            }
        }

        // В списке list остаются только невалидные параметры
        if (!list.isEmpty()) {  // если они есть, выбрасываем исключение
            throw new ParseImpossibleException(list.toString(), ParserList.getNullNames().toString());
        }

        Toy toy;  // Создаем объект класса Toy
        toy = new Toy((int) parsList.get(0).getValue()
                , (int) parsList.get(1).getValue()
                , (String) parsList.get(2).getValue());
        return toy;
    }
}
