package app.commands;

import app.collection.CollectionManager;

public class InfoCommand implements Command{
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String arg) {
        collectionManager.showCollectionInfo();
    }

    public String toString(){
        return "вывести информацию о коллекции";
    }
}
