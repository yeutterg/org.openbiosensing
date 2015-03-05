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
}
