import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.scribe.model.Verb;

import java.util.ArrayList;
import java.util.List;

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

    /*
     * Get sleep for a specific user on a specific date
     */
    public static TotalSleep24h getSleep(User user, String date) {
        String input = OAuth.sendRequest(Verb.GET, "/1/user/" + user.getEncodedId()
                + "/sleep/date/" + date + ".json");

        JsonElement jsonElement = new JsonParser().parse(input);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // Go through summary first to get the number of bouts
        jsonElement = jsonObject.getAsJsonObject("summary");
        JsonObject jsonObject1 = jsonElement.getAsJsonObject();
        int totalMinutesAsleep = Integer.parseInt(jsonObject1.getAsJsonPrimitive("totalMinutesAsleep").toString());
        int totalMinutesInBed = Integer.parseInt(jsonObject1.getAsJsonPrimitive("totalTimeInBed").toString());
        int totalBouts = Integer.parseInt(jsonObject1.getAsJsonPrimitive("totalSleepRecords").toString());

        // Iterate through sleep for the number of bouts
        List<SleepBout> sleepBouts = new ArrayList<SleepBout>();
        JsonArray jsonArray = jsonObject.getAsJsonArray("sleep");
        for (int i = 0; i < totalBouts; i++) {
            jsonObject = jsonArray.get(i).getAsJsonObject();

            // Get number of minutes in bed
            int minsInBed = Integer.parseInt(jsonObject.getAsJsonPrimitive("timeInBed").toString());

            // Build minute-by-minute data into a List
            List<MinuteDataPt> minuteData = new ArrayList<MinuteDataPt>();
            jsonArray = jsonObject.getAsJsonArray("minuteData");
            for (int j = 0; j < minsInBed; j++) {
                jsonObject1 = jsonArray.get(j).getAsJsonObject();
                String time = jsonObject1.getAsJsonPrimitive("dateTime").toString();
                int amp = Integer.parseInt(jsonObject1.getAsJsonPrimitive("value").toString().replace("\"", ""));
                minuteData.add(new MinuteDataPt(time, amp));
            }

            SleepBout bout = new SleepBout.SleepBoutBuilder()
                    .setNumAwakenings(jsonObject.getAsJsonPrimitive("awakeCount").toString())
                    .setAwakeDurationMs(jsonObject.getAsJsonPrimitive("awakeDuration").toString())
                    .setSleepDurationMs(jsonObject.getAsJsonPrimitive("duration").toString())
                    .setEfficiency(jsonObject.getAsJsonPrimitive("efficiency").toString())
                    .setIsMainSleep(jsonObject.getAsJsonPrimitive("isMainSleep").toString())
                    .setLogId(jsonObject.getAsJsonPrimitive("logId").toString())
                    .setMinutesAfterWakeup(jsonObject.getAsJsonPrimitive("minutesAfterWakeup").toString())
                    .setMinutesAsleep(jsonObject.getAsJsonPrimitive("minutesAsleep").toString())
                    .setMinutesAwake(jsonObject.getAsJsonPrimitive("minutesAwake").toString())
                    .setMinutesToFallAsleep(jsonObject.getAsJsonPrimitive("minutesToFallAsleep").toString())
                    .setNumRestless(jsonObject.getAsJsonPrimitive("restlessCount").toString())
                    .setRestlessDurationMs(jsonObject.getAsJsonPrimitive("restlessDuration").toString())
                    .setStartTime(jsonObject.getAsJsonPrimitive("startTime").toString())
                    .setMinutesInBed(jsonObject.getAsJsonPrimitive("timeInBed").toString())
                    .setMinuteData(minuteData)
                    .build();

            sleepBouts.add(bout);
        }

        return new TotalSleep24h(totalMinutesAsleep, totalMinutesInBed, totalBouts, sleepBouts);
    }
}
