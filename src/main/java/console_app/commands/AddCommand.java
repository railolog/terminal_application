package console_app.commands;

import console_app.collection.CollectionManager;

public class AddCommand implements Command{
    private CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.addElement();
    }

    @Override
    public String toString() {
        return "добавить новый элемент в коллекцию";
    }
}
