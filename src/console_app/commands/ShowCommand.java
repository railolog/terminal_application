package console_app.commands;

import console_app.collection.CollectionManager;

public class ShowCommand implements Command{
    CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.printElements();
    }
}
