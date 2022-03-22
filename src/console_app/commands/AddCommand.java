package console_app.commands;

import console_app.collection.CollectionManager;

public class AddCommand implements Command{
    CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.addElement();
    }
}
