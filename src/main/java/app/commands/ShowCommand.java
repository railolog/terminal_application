package app.commands;

import app.collection.CollectionManager;

public class ShowCommand implements Command{
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.printElements();
    }

    @Override
    public String toString(){
        return "вывести все элементы коллекции";
    }
}
