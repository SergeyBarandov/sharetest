package logger;

import config.Settings;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс Log - шаблон лога (из чего состоит).
 *
 * @author Pavlov Artem
 * @since 03.03.2018
 */
public class Log implements Comparable<Log> {
    /**
     * Объект типа Date для хранения полной даты и времени.
     */
    private final Date dateCreate;

    /**
     * Описание лога.
     */
    private final String description;

    /**
     * Статус лога (Ошибка, Коннект, Дисконнект и т.д.).
     */
    private final Status status;

    /**
     * Вид даты при выводе. Задаётся в файле "server.properties" или формат по умолчанию "dd.MM.yyyy".
     */
    private final String formatDate;

    /**
     * Вид времени при выводе. Задаётся в файле "server.properties" или формат по умолчанию "hh:mm:ss".
     */
    private final String formatTime;

    /**
     * Конструктор для класса Log.
     * Обязательна передача данных при создании объекта "status" и "description"
     *
     * @param status      - статус лога (Ошибка, Коннект, Дисконнект и т.д.);
     * @param description - описание лога;
     */
    Log(Status status, String description) {
        this.dateCreate = new Date();
        this.description = description;
        this.status = status;
        this.formatDate = Settings.FORMAT_DATE.get();
        this.formatTime = Settings.FORMAT_TIME.get();
    }

    /**
     * Метод лля естественной сортировки. Используется для хранения данных в бинарных деревьях.
     * В данной реализации сортировка происходит по возрастанию. Сравнение происходит по дате и времени.
     *
     * @param o объект такого же типа (Log) для сравнения;
     * @return возвращает число. Если число < 0, то объект "o" больше этого объекта
     * если число > 0, то объект "o" меньше этого объекта
     * или 0 при равенстве.
     */
    @Override
    public int compareTo(Log o) {
        return o != null ? dateToString().compareTo(o.dateToString()) : 0;
    }

    /**
     * Получаем полный формат даты и времени.
     * *
     *
     * @return полный формат даты и времени;
     */
    private String getFullFormat() {
        return String.format("%s %s", this.formatDate, this.formatTime);
    }


    /**
     * Переводим объект Date в читабельный вид по заданному формату.
     * По умолчанию формат даты: dd.MM.yyyy; формат времени: hh:mm:ss
     * Пример вывода: 20.07.1984 20:07:38
     * Формат можно установить свой в файле "server.properties";
     *
     * @return возвращает дату в виде строки по заданному формату;
     */
    private String dateToString() {
        return new SimpleDateFormat(getFullFormat()).format(this.dateCreate);
    }

    /**
     * Возвращаем наш объект в виде строки.
     * [статус][дата и время]: описание лога;
     * Пример: [ERROR][20.01.2018 20:06:38]: сервер прервал свою работу;
     *
     * @return возвращает объект в виде строки;
     */
    @Override
    public String toString() {
        return String.format("[%s][%s]: %s;", this.status, dateToString(), this.description);
    }
}
