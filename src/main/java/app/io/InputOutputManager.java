package app.io;

import app.commands.CommandWrapper;
import app.core.City;

import java.io.InputStream;
import java.util.Scanner;

public interface InputOutputManager {
    /**
     * Считывает команду
     * @return команда
     */
    CommandWrapper readCommand();

    /**
     * Осуществляет вывод с переносом строки.
     * Не работоает в файловом режиме
     * @param line строка, которую надо вывести
     */
    void println(String line);

    /**
     * Осуществляет вывод с переносом строки несмотря на режим
     * @param line строка, которую надо вывести
     */
    void printlnForce(String line);

    /**
     * Осуществляет вывод с переносом строки.
     * Не работоает в файловом режиме
     * @param line строка, которую надо вывести
     */
    void print(String line);

    /**
     * Осуществляет вывод ошибок
     * @param e текст ошибки
     */
    void printErr(String e);

    /**
     * Читает строку из входного потока
     * @return строка
     */
    String readLine();

    /**
     * Осуществляет чтение парметров Города
     * @return город
     */
    City readCity();

    /**
     * Устанавливает входной поток
     * @param path путь до файла
     */
    void setFileInput(String path);

    /**
     * Устанавливает входной поток
     * @param source поток ввода
     */
    void setScanner(Scanner source);

    /**
     * Устанавливает входной поток
     * @param source поток ввода
     */
    void setScanner(InputStream source);

    /**
     * Возвращается к предыдущему потоку ввода
     */
    void setPreviousScanner();

    String readPath();
}
