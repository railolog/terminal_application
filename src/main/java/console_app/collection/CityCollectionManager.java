package console_app.collection;

import console_app.core.City;
import console_app.core.CityCreationDateComparator;
import console_app.exceptions.CityInteractionException;
import console_app.exceptions.CityNotExistsException;
import console_app.io.FileManager;
import console_app.io.InputOutputManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

public class CityCollectionManager implements CollectionManager<City>{
    /** Дата создания */
    private Date creationDate;

    /**
     * Класс осуществляющий ввод-вывод
     */
    private InputOutputManager ioManager;

    /**
     * Коллекция, которой управляет класс
     */
    private ArrayList<City> cityCollection = new ArrayList<>();

    /**
     * id хранимых элементов
     */
    private HashSet<Long> collectionIdSet = new HashSet<>();

    /**
     * Класс, осуществляющий сохранение и загрузку коллекции
     */
    private FileManager fileManager = new FileManager();

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
    public void setCollection(ArrayList<City> collection) {
        collectionIdSet.clear();
        cityCollection.clear();

        for (City city: collection){
            if (collectionIdSet.contains(city.getId())){
                ioManager.printErr("Элемент с id " + city.getId() + " уже есть в коллекции, текущий будет пропущен");
            }
            else {
                collectionIdSet.add(city.getId());
                cityCollection.add(city);
            }
        }
        ioManager.printlnForce("Файл считан");
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
        ioManager.printlnForce("ArrayList of Cities\nCreation Date: " + creationDate);
        ioManager.printlnForce("Number of elements: " + cityCollection.size());
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
        ioManager.printlnForce("Элемент успешно добавлен");
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
        ioManager.printlnForce("Элемент успешно обновлён");
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
        Collections.sort(cityCollection);
    }

    @Override
    public void printElements() {
        if (cityCollection.isEmpty()){
            ioManager.printlnForce("Коллекция пуста");
        }
        else{
            cityCollection.forEach(city -> ioManager.printlnForce(city.toString()));
        }
    }

    /**
     * Удаляет элемент коллекции
     * @param id id удаляемого элемента
     */
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

        ioManager.printlnForce("Элемент успешно удалён");
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
        ioManager.printlnForce("Коллекция успешно очищена");
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
            City maxCity = Collections.max(cityCollection);
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
                ioManager.printlnForce("Элемент успешно добавлен");
                sort();
            }
            else {
                ioManager.printlnForce("Элемент не больше максимального элемента коллекции");
            }
        }
    }

    @Override
    public void minByCreationDate() {
        if(cityCollection.size() == 0){
            ioManager.printlnForce("Коллекция пуста");
        }
        else{
            ioManager.printlnForce(Collections.min(cityCollection, new CityCreationDateComparator()).toString());
        }
    }

    @Override
    public void filterGreaterThanSeaLevel(String metersAboveSeaLevel) {
        try {
            filterGreaterThanSeaLevel(Long.parseLong(metersAboveSeaLevel));
        }
        catch (NumberFormatException e){
            ioManager.printErr("Введено не целое число");
        }
    }

    /**
     * Выводит элементы, значение поля которых, превышает данное
     * @param metersAboveSeaLevel сравниваемое значение
     * @see console_app.core.City#metersAboveSeaLevel
     */
    public void filterGreaterThanSeaLevel(long metersAboveSeaLevel) {
        if (cityCollection.size() == 0){
            ioManager.printlnForce("Коллекция пуста");
        }
        else {
            boolean shown = false;
            for (City city: cityCollection){
                if (city.getMetersAboveSeaLevel() != null && city.getMetersAboveSeaLevel() > metersAboveSeaLevel){
                    ioManager.printlnForce(city.toString());
                    shown = true;
                }
            }

            if (!shown){
                ioManager.printlnForce("В коллекции нет элементов со значением поля metersAboveSeaLevel больше заданного");
            }
        }
    }

    @Override
    public void groupCountingByCoordinates() {
        int[] groups = new int[]{0, 0, 0, 0};

        if (cityCollection.size() == 0){
            ioManager.printlnForce("Коллекция пуста");
        }
        else {
            for (City city: cityCollection){
                groups[city.getCoordinates().getQuarter() - 1]++;
            }
            ioManager.printlnForce("Распределение городов по четвертям:");
            for (int i = 0; i < groups.length; i++){
                ioManager.printlnForce((i + 1) + ": " + groups[i]);
            }
        }
    }

    @Override
    public void save(String path) {
        try {
            fileManager.save(cityCollection, path);
            ioManager.printlnForce("Коллекция сохранена в файл " + path);
        }
        catch (NullPointerException e){
            ioManager.printErr("Не введено имя файла");
        }
        catch (IOException e){
            ioManager.printErr("не удалось сохранить коллекцию в файл\n" + e.getMessage());
        }
    }
}
