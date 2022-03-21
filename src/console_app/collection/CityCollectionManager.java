package console_app.collection;

import console_app.core.City;
import console_app.io.InputOutputManager;

import java.util.ArrayList;
import java.util.HashSet;

public class CityCollectionManager implements CollectionManager{
    InputOutputManager ioManager;
    ArrayList<City> cityCollection = new ArrayList<>();
    HashSet<Long> collectionIdSet = new HashSet<>();

    public CityCollectionManager(InputOutputManager ioManager){
        this.ioManager = ioManager;
    }

    @Override
    public long createUniqueId() {
        if (cityCollection.isEmpty()){
            collectionIdSet.add(1L);
            return 1;
        }
        else{
            Long id  = cityCollection.get(cityCollection.size() - 1).getId();
            while (collectionIdSet.contains(id)){
                id++;
            }
            collectionIdSet.add(id);
            return id;
        }
    }

    @Override
    public void showCollectionInfo() {
        ioManager.println("'Info'");
    }
}
