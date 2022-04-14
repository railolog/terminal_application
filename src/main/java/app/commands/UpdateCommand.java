package app.commands;

import app.collection.CollectionManager;

public class UpdateCommand implements Command{
    private CollectionManager collectionManager;

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
