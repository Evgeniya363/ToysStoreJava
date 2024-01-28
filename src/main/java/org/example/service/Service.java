package org.example.service;

import org.example.model.Toy;
import org.example.model.ToysList;
import org.example.service.config.Config;
import org.example.service.exception.ParseImpossibleException;
import org.example.service.saving.SaveFormatter;
import org.example.service.saving.TextFormat;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.PriorityQueue;

public class Service {
    private ToysList toys;
    private PriorityQueue<Toy> toysQueue;
    private List<Toy> prizes;
    private String path = Config.getPath();


    public Service(String[] str) throws ParseImpossibleException {
        try {
            // Создаем список игрушек
            toys = PrizeFundCreator.toysCreate(str);
            // Создаем призовой фонд / остаток товаров на складе
            toysQueue = PrizeFundCreator.toysQueueCreate(toys);
            //Разыгрываем призы
            prizes = PrizeDrow.execute(toysQueue);
            //Сохраняем результат
            save(new TextFormat());
            System.out.println("Резальтаты розыгрыша записаны в файл " + path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void save(SaveFormatter saveFormatter) throws IOException {
        String timeStamp = new SimpleDateFormat("от dd.MM.yyyy HH:mm:ss")
                .format(Calendar.getInstance().getTime());

        StringBuilder sb =new StringBuilder();
        sb.append("\nРозыгрыш ")
          .append(timeStamp)
          .append("\nКоличество призов: ")
          .append(Config.getPrizesNumber())
          .append("\n\nРазыгрываемые позиции:\n")
          .append(toys)
          .append("\nВыигранные игрушки:\n")
          .append(prizes);

        saveFormatter.save(sb.toString(), path);
    }
}
