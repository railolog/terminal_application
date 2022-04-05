package console_app.commands;

import console_app.collection.CollectionManager;

public class RemoveByIdCommand implements Command{
    private CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.removeById(arg);
    }

    @Override
    public String toString() {
        return "удалить элемент из коллекции по его id";
    }
}
