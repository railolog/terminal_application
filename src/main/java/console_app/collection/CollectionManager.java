package console_app.collection;

import java.util.ArrayList;

/**
 * Класс управляющий коллекцией
 * @author railolog
 * @version 1.0
 */
public interface CollectionManager<T> {
    long createUniqueId();

    void setCollection(ArrayList<T> collection);

    void showCollectionInfo();

    void printElements();

    void addElement();

    void update(long id);

    void update(String id);

    int getIndexById(long id);

    void removeById(String id);

    void clearCollection();

    void addIfMax();

    void shuffle();

    void reorder();

    void minByCreationDate();

    void filterGreaterThanSeaLevel(String metersAboveSeaLevel);

    void sort();

    void save(String path);
}
