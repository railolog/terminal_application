package app.commands;

import app.collection.CollectionManager;

public class GroupCountingCommand implements Command{
    private CollectionManager collectionManager;

    public GroupCountingCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.groupCountingByCoordinates();
    }

    @Override
    public String toString() {
        return "сгруппировать элементы коллекции по значению поля coordinates";
    }
}
