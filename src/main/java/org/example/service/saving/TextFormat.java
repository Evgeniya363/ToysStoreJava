package org.example.service.saving;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* Класс TextFormat описывает сохранение объекта  в текстовый файл
*/public class TextFormat implements SaveFormatter<String> {

    /**
     * Метод Записи данные в файл
     */
    public void save(String o, String path) {
        File file = new File(path);

        try (FileWriter writer = new FileWriter(file,true)) {
            // Записываем данные в файл
            writer.append(o);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода/вывода при работе с файлом " + path);
        }
    }

}
