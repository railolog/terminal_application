package console_app.commands;

import console_app.collection.CollectionManager;

public class ShuffleCommand implements Command{
    CollectionManager collectionManager;

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
