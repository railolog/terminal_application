package console_app.commands;

import console_app.collection.CollectionManager;

public class InfoCommand implements Command{
    private final CollectionManager collectionManager;

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
