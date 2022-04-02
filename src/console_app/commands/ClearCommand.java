package console_app.commands;

import console_app.collection.CollectionManager;

public class ClearCommand implements Command{
    CollectionManager collectionManager;

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
