import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.scribe.model.Verb;

/**
 * Make fitbit-specific OAuth requests and parse results to the appropriate output
 */
public class Request {

    /*
     * Get user profile data for the logged in user
     */
    public static User getProfile() {
        String input = OAuth.sendRequest(Verb.GET, "/1/user/-/profile.json");

        JsonElement jsonElement = new JsonParser().parse(input);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject = jsonObject.getAsJsonObject("user");

        User user = new User.UserBuilder()
                .setEncodedId(jsonObject.getAsJsonPrimitive("encodedId").toString().replace("\"", ""))
                .setFullName(jsonObject.getAsJsonPrimitive("fullName").toString().replace("\"", ""))
                .setGender(jsonObject.getAsJsonPrimitive("gender").toString().replace("\"", ""))
                .setCity(jsonObject.getAsJsonPrimitive("city").toString().replace("\"", ""))
                .setState(jsonObject.getAsJsonPrimitive("state").toString().replace("\"", ""))
                .setCountry(jsonObject.getAsJsonPrimitive("country").toString().replace("\"", ""))
                .setTimeZone(jsonObject.getAsJsonPrimitive("timezone").toString().replace("\"", ""))
                .setBirthDate(jsonObject.getAsJsonPrimitive("dateOfBirth").toString().replace("\"", ""))
                .setHeightCm(jsonObject.getAsJsonPrimitive("height").toString())
                .setWeightKg(jsonObject.getAsJsonPrimitive("weight").toString())
                .setStrideLengthRunningCm(jsonObject.getAsJsonPrimitive("strideLengthRunning").toString())
                .setStrideLengthWalkingCm(jsonObject.getAsJsonPrimitive("strideLengthWalking").toString())
                .build();

        return user;
    }

    /*
     * Get user profile data for an alternate user, given the encodedId
     */
    public static User getProfile(String encodedId) {
        String input = OAuth.sendRequest(Verb.GET, "/1/user/" + encodedId + "/profile.json");

        JsonElement jsonElement = new JsonParser().parse(input);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject = jsonObject.getAsJsonObject("user");

        User user = new User.UserBuilder()
                .setEncodedId(jsonObject.getAsJsonPrimitive("encodedId").toString().replace("\"", ""))
                .setFullName(jsonObject.getAsJsonPrimitive("fullName").toString().replace("\"", ""))
                .setGender(jsonObject.getAsJsonPrimitive("gender").toString().replace("\"", ""))
                .setCity(jsonObject.getAsJsonPrimitive("city").toString().replace("\"", ""))
                .setState(jsonObject.getAsJsonPrimitive("state").toString().replace("\"", ""))
                .setCountry(jsonObject.getAsJsonPrimitive("country").toString().replace("\"", ""))
                .setTimeZone(jsonObject.getAsJsonPrimitive("timezone").toString().replace("\"", ""))
                .setBirthDate(jsonObject.getAsJsonPrimitive("dateOfBirth").toString().replace("\"", ""))
                .setHeightCm(jsonObject.getAsJsonPrimitive("height").toString())
                .setWeightKg(jsonObject.getAsJsonPrimitive("weight").toString())
                .setStrideLengthRunningCm(jsonObject.getAsJsonPrimitive("strideLengthRunning").toString())
                .setStrideLengthWalkingCm(jsonObject.getAsJsonPrimitive("strideLengthWalking").toString())
                .build();

        return user;
    }
}
