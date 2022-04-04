package console_app.json;

import com.google.gson.*;
import console_app.core.City;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CityCollectionDeserializer implements JsonDeserializer<ArrayList<City>> {
    @Override
    public ArrayList<City> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ArrayList<City> cityArrayList = new ArrayList<>();

        for (JsonElement jsonElement1: jsonElement.getAsJsonArray()){
            cityArrayList.add(jsonDeserializationContext.deserialize(jsonElement, City.class));
        }

        return cityArrayList;
    }
}
