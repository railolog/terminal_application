package console_app.collection;

import console_app.core.City;
import console_app.core.CityComparator;
import console_app.exceptions.CityInteractionException;
import console_app.exceptions.CityNotExistsException;
import console_app.io.InputOutputManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

public class CityCollectionManager implements CollectionManager{
    Date creationDate;
    InputOutputManager ioManager;
    ArrayList<City> cityCollection = new ArrayList<>();
    HashSet<Long> collectionIdSet = new HashSet<>();

    public CityCollectionManager(InputOutputManager ioManager){
        creationDate = new Date();
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
    public int getIndexById(long id) throws CityNotExistsException{
        for (int i = 0; i < cityCollection.size(); i++){
            if (id == cityCollection.get(i).getId()){
                return i;
            }
        }
        throw new CityNotExistsException("В коллекции нет элемента с id " + id);
    }

    @Override
    public void showCollectionInfo() {
        ioManager.println("ArrayList of Cities\nCreation Date: " + creationDate);
        ioManager.println("Number of elements: " + cityCollection.size());
    }

    @Override
    public void addElement() {
        City city;
        try {
            city = ioManager.readCity();
        }
        catch (CityInteractionException e){
            ioManager.printErr("не удалось добавить элемент. " + e.getMessage());
            return;
        }
        city.setId(createUniqueId());
        cityCollection.add(city);
        ioManager.println("Элемент успешно добавлен");
        sort();
    }

    @Override
    public void update(long id) {
        int cityIndex;

        try {
            cityIndex = getIndexById(id);
        }
        catch (CityNotExistsException e){
            ioManager.printErr(e.getMessage());
            return;
        }

        City newCity;

        try{
            newCity = ioManager.readCity();
        }
        catch (CityInteractionException e){
            ioManager.printErr("не удалось считать элемент. " + e.getMessage());
            return;
        }

        newCity.setId(id);
        cityCollection.set(cityIndex, newCity);
    }

    @Override
    public void update(String id){
        try {
            update(Long.parseLong(id));
        }
        catch (NumberFormatException e){
            ioManager.printErr("введён id не являющийся целым числом");
        }
    }

    @Override
    public void sort() {
        cityCollection.sort(new CityComparator());
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

    public void removeById(long id){
        int index;

        try {
            index = getIndexById(id);
        }
        catch (CityNotExistsException e){
            ioManager.printErr(e.getMessage());
            return;
        }

        cityCollection.remove(index);

        ioManager.println("Элемент успешно удалён");
    }

    @Override
    public void removeById(String id) {
        try {
            removeById(Long.parseLong(id));
        }
        catch (NumberFormatException e){
            ioManager.printErr("введён id не являющийся целым числом");
        }
    }

    @Override
    public void clearCollection() {
        cityCollection.clear();
        ioManager.println("Коллекция успешно очищена");
    }

    @Override
    public void reorder() {
        Collections.reverse(cityCollection);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cityCollection);
    }

    @Override
    public void addIfMax() {
        if (cityCollection.size() == 0){
            addElement();
        }
        else {
            City maxCity = Collections.max(cityCollection, new CityComparator());
            City city;
            try {
                city = ioManager.readCity();
            }
            catch (CityInteractionException e){
                ioManager.printErr("не удалось добавить элемент. " + e.getMessage());
                return;
            }

            if (city.compareTo(maxCity) > 0){
                city.setId(createUniqueId());
                cityCollection.add(city);
                ioManager.println("Элемент успешно добавлен");
                sort();
            }
            else {
                ioManager.println("Элемент не больше максимального элемента коллекции");
            }
        }
    }

    
}
