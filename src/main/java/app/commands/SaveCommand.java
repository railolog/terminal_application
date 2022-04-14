package app.commands;

import app.collection.CollectionManager;

public class SaveCommand implements Command{
    private CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.save(arg);
    }

    @Override
    public String toString() {
        return "сохранить коллекцию в файл";
    }
}
