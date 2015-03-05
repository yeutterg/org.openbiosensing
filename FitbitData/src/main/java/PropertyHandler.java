import org.scribe.model.Token;
import org.scribe.model.Verifier;

import java.io.*;
import java.util.Properties;

/**
 * Read and write properties files, located in the resources folder
 */
public class PropertyHandler {

    /*
     * Load API Key and Secret from api.properties file
     */
    public static String[] loadApi() {
        Properties apiProps = new Properties();
        try {
            InputStream resourceStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("api.properties");
            apiProps.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading properties.");
            System.exit(-1);
        }

        String key = apiProps.getProperty("key");
        String secret = apiProps.getProperty("secret");

        return new String[] {key, secret};
    }

    /*
     * Load authorization information from authorization.properties file
     */
    public static String[] loadAuthorization() {
        Properties authProps = new Properties();
        try {
            InputStream resourceStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("authorization.properties");
            authProps.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading authorization details.");
            System.exit(-1);
        }

        String accesstoken = authProps.getProperty("accesstoken");
        String secret = authProps.getProperty("secret");
        String rawresponse = authProps.getProperty("rawresponse");
        String verifier = authProps.getProperty("verifier");

        if (accesstoken == null || secret == null || rawresponse == null || verifier == null) {
            return null;
        }
        String[] returnVal = {accesstoken, secret, rawresponse, verifier};
        return returnVal;
    }

    /*
     * Write authorization information to authorization.properties file
     */
    public static void writeAuthorization(Token accessToken, String verifier) {
        try {
            Properties authProps = new Properties();
            authProps.setProperty("accesstoken", accessToken.getToken());
            authProps.setProperty("secret", accessToken.getSecret());
            authProps.setProperty("rawresponse", accessToken.getRawResponse());
            authProps.setProperty("verifier", verifier);

            File f = new File("src/main/resources/authorization.properties");
            OutputStream resourceStream = new FileOutputStream(f);
            authProps.store(resourceStream, "Updated: " + System.currentTimeMillis());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * Load specific user based on encoded Id
     */
    public static User loadUser(String encodedId) {
        Properties userProps = new Properties();
        try {
            InputStream resourceStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(encodedId + ".properties");
            userProps.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading user " + encodedId + " details.");
            System.exit(-1);
        }

        User user = new User.UserBuilder()
                .setEncodedId(userProps.getProperty("encodedId"))
                .setFullName(userProps.getProperty("fullName"))
                .setGender(userProps.getProperty("gender"))
                .setCity(userProps.getProperty("city"))
                .setState(userProps.getProperty("state"))
                .setCountry(userProps.getProperty("country"))
                .setTimeZone(userProps.getProperty("timeZone"))
                .setBirthDate(userProps.getProperty("birthDate"))
                .setHeightCm(userProps.getProperty("heightCm"))
                .setWeightKg(userProps.getProperty("weightKg"))
                .setStrideLengthRunningCm(userProps.getProperty("strideLengthRunningCm"))
                .setStrideLengthWalkingCm(userProps.getProperty("strideLengthWalkingCm"))
                .build();

        return user;
    }

    /*
     * Write user information to encodedId.properties file
     */
    public static void writeUser(User user) {
        try {
            Properties userProps = new Properties();
            userProps.setProperty("encodedId", user.getEncodedId());
            userProps.setProperty("fullName", user.getFullName());
            userProps.setProperty("gender", user.getGender());
            userProps.setProperty("city", user.getCity());
            userProps.setProperty("state", user.getState());
            userProps.setProperty("country", user.getCountry());
            userProps.setProperty("timeZone", user.getTimeZone());
            userProps.setProperty("birthDate", user.getBirthDate());
            userProps.setProperty("heightCm", Integer.toString(user.getHeightCm()));
            userProps.setProperty("weightKg", Double.toString(user.getWeightKg()));
            userProps.setProperty("strideLengthRunningCm", Double.toString(user.getStrideLengthRunningCm()));
            userProps.setProperty("strideLengthWalkingCm", Double.toString(user.getStrideLengthWalkingCm()));

            File f = new File("src/main/resources/" + user.getEncodedId() + ".properties");
            OutputStream resourceStream = new FileOutputStream(f);
            userProps.store(resourceStream, "Updated: " + System.currentTimeMillis());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
