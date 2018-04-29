package me.brunorsouza.testesantander.webservice

import com.google.gson.*
import java.lang.reflect.Type


/**
 * Created by brunosouza.
 */
class Deserializer : JsonDeserializer<Any> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Any {

        var action: JsonElement = json.asJsonObject

        if (json.asJsonObject.get("error") != null) {
            action = json.asJsonObject.get("error")
        }

        return Gson().fromJson(action, typeOfT)

    }
}