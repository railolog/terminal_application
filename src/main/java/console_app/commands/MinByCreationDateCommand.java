package console_app.commands;

import console_app.collection.CollectionManager;

public class MinByCreationDateCommand implements Command{
    private CollectionManager collectionManager;

    public MinByCreationDateCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.minByCreationDate();
    }

    @Override
    public String toString() {
        return "вывести любой объект из коллекции, значение поля creationDate которого является минимальным";
    }
}
