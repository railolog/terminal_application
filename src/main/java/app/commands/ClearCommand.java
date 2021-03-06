package app.commands;

import app.collection.CollectionManager;

public class ClearCommand implements Command{
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.clearCollection();
    }

    @Override
    public String toString() {
        return "очистить коллекцию";
    }
}
