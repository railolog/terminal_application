package app.commands;

import app.collection.CollectionManager;

public class ShuffleCommand implements Command{
    private CollectionManager collectionManager;

    public ShuffleCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.shuffle();
    }

    @Override
    public String toString() {
        return "перемешать элементы коллекции в случайном порядке";
    }
}
