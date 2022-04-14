package app.commands;

import app.collection.CollectionManager;

public class ReorderCommand implements Command{
    private CollectionManager collectionManager;

    public ReorderCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.reorder();
    }

    @Override
    public String toString() {
        return "отсортировать коллекцию в порядке, обратном нынешнему";
    }
}
