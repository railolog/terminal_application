package console_app.json;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDeserializer implements JsonDeserializer<ZonedDateTime> {
    @Override
    public ZonedDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        int     year = jsonObject.get("year").getAsInt(),
                month = jsonObject.get("month").getAsInt(),
                day = jsonObject.get("day").getAsInt(),
                hour = jsonObject.get("hour").getAsInt(),
                minute = jsonObject.get("minute").getAsInt(),
                second = jsonObject.get("second").getAsInt(),
                nano = jsonObject.get("nano").getAsInt();

        String zoneId = jsonObject.get("zoneId").getAsString();
        ZoneId parsedZoneId = ZoneId.of(zoneId);

        return ZonedDateTime.of(year, month, day, hour, minute, second, nano, parsedZoneId);
    }
}
