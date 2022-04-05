package console_app.collection;

import java.util.ArrayList;

/**
 * Класс управляющий коллекцией
 * @author railolog
 * @version 1.0
 */
public interface CollectionManager<T> {
    /**
     * Функция получения уникального id
     * @return Возвращает id
     */
    long createUniqueId();

    /**
     * Устанавливает коллекцией, передаваемое ей значение
     * @param collection Коллекция для устаовки
     */
    void setCollection(ArrayList<T> collection);

    /**
     * Выводит информацию о коллекции
     */
    void showCollectionInfo();

    /**
     * Ввыодит содержимое коллекции
     */
    void printElements();

    /**
     * Запускает процесс добавление элемента в коллекцию
     */
    void addElement();

    /**
     * Обновляет значение элемента по id
     * @param id id элемента, который необходимо обновить
     */
    void update(long id);

    /**
     * Обновляет значение элемента по id
     * @param id id элемента, который необходимо обновить
     */
    void update(String id);

    /**
     * Возвращает индекс элемента в коллекции
     * @param id id элемента
     * @return Возвращает индекс
     */
    int getIndexById(long id);

    /**
     * Удаляет элемент коллекции
     * @param id id удаляемого элемента
     */
    void removeById(String id);

    /**
     * Очистка коллекции
     */
    void clearCollection();

    /**
     * Добавление элемента в коллекцию, если он больше максимального
     * существующего элемента
     */
    void addIfMax();

    /**
     * Перемешка коллекции
     */
    void shuffle();

    /**
     * Упорядычивает коллекцию в обратном порядке
     */
    void reorder();

    /**
     * Возвращает минимальный по полю creationDate
     * элемент
     * @see console_app.core.City#creationDate
     */
    void minByCreationDate();

    /**
     * Выводит элементы, значение поля которых, превышает данное
     * @param metersAboveSeaLevel сравниваемое значение
     * @see console_app.core.City#metersAboveSeaLevel
     */
    void filterGreaterThanSeaLevel(String metersAboveSeaLevel);

    /**
     * Сортирует коллекцию
     */
    void sort();

    /**
     * Сохраняет коллекцию по заданному пути
     * @param path путь до файла
     */
    void save(String path);

    /**
     * Группирует элементы по полю coordinates
     * @see console_app.core.City#coordinates
     */
    void groupCountingByCoordinates();
}
