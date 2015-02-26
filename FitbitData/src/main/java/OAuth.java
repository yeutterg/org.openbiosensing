import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Authenticate a user to the Fitbit API
 */
public class OAuth extends FitbitApi {

    static String API_KEY;
    static String API_SECRET;

    /*
     * Connect to the Fitbit API
     */
    public static void setupOAuth() {

        // Read in credentials
        readCredentials();

        // Create the OAuthService Object
        OAuthService service = new ServiceBuilder()
                .provider(FitbitApi.class)
                .apiKey(API_KEY)
                .apiSecret(API_SECRET)
                .build();

        // Get the request token
        Token requestToken = service.getRequestToken();

        // Make the user validate the request token

        // Get the access token

        // Sign the request


    }


    /*
     * Read credentials from /resources/FitbitCredentials.txt file
     */
    private static void readCredentials() {
        File file = new File("src/main/resources/FitbitCredentials.txt");
        List<String> lines = new ArrayList<String>();

        // Read credentials from file
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: FitbitCredentials.txt file not found.");
            System.exit(-1);
        }

        // Assign credentials to variables
        API_KEY = lines.get(0);
        API_SECRET = lines.get(1);


    }
}
