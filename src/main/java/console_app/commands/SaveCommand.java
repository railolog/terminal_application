package console_app.commands;

import console_app.collection.CollectionManager;

public class SaveCommand implements Command{
    CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.save();
    }
}
