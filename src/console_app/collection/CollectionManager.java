package console_app.collection;

/**
 * Класс управляющий коллекцией
 * @author railolog
 * @version 1.0
 */
public interface CollectionManager<T> {
    long createUniqueId();

    void showCollectionInfo();
}
