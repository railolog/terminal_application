package console_app.commands;

import console_app.collection.CollectionManager;

public class UpdateCommand implements Command{
    CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.update(arg);
    }

    @Override
    public String toString() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
