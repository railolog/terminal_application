package console_app.collection;

import console_app.core.City;
import console_app.io.InputOutputManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class CityCollectionManager implements CollectionManager{
    Date creationDate;
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
        ioManager.println("ArrayList of Cities\nCreation Date: " + creationDate);
        ioManager.println("Number of elements: " + cityCollection.size());
    }

    @Override
    public void addElement() {
        City city = ioManager.readCity();
        city.setId(createUniqueId());
        cityCollection.add(city);
        sort();
    }

    @Override
    public void sort() {
        cityCollection.sort();
    }

    @Override
    public void printElements() {
        if (cityCollection.isEmpty()){
            ioManager.println("Коллекция пуста");
        }
        else{
            cityCollection.forEach(city -> ioManager.println(city.toString()));
        }
    }
}
