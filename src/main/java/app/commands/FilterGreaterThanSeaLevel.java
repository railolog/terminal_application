package app.commands;

import app.collection.CollectionManager;

public class FilterGreaterThanSeaLevel implements Command{
    private CollectionManager collectionManager;

    public FilterGreaterThanSeaLevel(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.filterGreaterThanSeaLevel(arg);
    }

    @Override
    public String toString() {
        return "вывести элементы, значение поля metersAboveSeaLevel которых больше заданного";
    }
}
