package app.commands;

import app.collection.CollectionManager;

public class AddIfMaxCommand implements Command{
    private CollectionManager collectionManager;

    public AddIfMaxCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.addIfMax();
    }

    @Override
    public String toString() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }
}
