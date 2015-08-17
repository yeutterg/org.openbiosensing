package Fitbit;

import Fitbit.FitbitApi;
import Fitbit.FitbitPropertyHandler;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

/**
 * Authenticate a user to the Fitbit.Fitbit API
 * Read calls are currently limited to 150 calls/hour
 */
public class OAuth {

    static String API_KEY;
    static String API_SECRET;
    static OAuthService service;
    static Token accessToken;
    static Verifier verifier;

    /*
     * Authorize Fitbit.Fitbit API if not authorized previously
     */
    public static void authorize() {

        // Read in credentials and create the OAuthService object
        setup();

        // Get the request token
        final Token requestToken = service.getRequestToken();

        // Make the user validate the request token
        System.out.println("Go to the following link and authorize the app:");
        System.out.println(service.getAuthorizationUrl(requestToken));
        System.out.println("Copy the PIN you are given and paste it here:");

        // Wait to continue until user pastes in the access PIN
        final String v = new Scanner(System.in).nextLine();

        // Get the access token
        verifier = new Verifier(v);
        accessToken = service.getAccessToken(requestToken, verifier);

        // Send a request for the user's profile info, and print it
        String response = sendRequest(Verb.GET, "/1/user/-/profile.json");
        System.out.println(response);

        // Write authorization details to authorization.properties file
        FitbitPropertyHandler.writeFitbitAuthorization(accessToken, v);
    }

    /*
     * Reconnect to the API if previously verified
     */
    public static void reconnect(String[] auth) {
        setup();
        accessToken = new Token(auth[0], auth[1], auth[2]);
        verifier = new Verifier(auth[3]);
    }

    /*
     * Set up the API by loading the API credentials and OAuthService object
     */
    public static void setup() {
        readCredentials();
        loadService();
    }

    /*
     * Read in API credentials
     */
    public static void readCredentials() {
        String[] api = FitbitPropertyHandler.loadFitbitApi();
        API_KEY = api[0];
        API_SECRET = api[1];
    }

    /*
     * Load the OAuthService object
     */
    public static void loadService() {
        service = new ServiceBuilder()
                .provider(FitbitApi.class)
                .apiKey(API_KEY)
                .apiSecret(API_SECRET)
                .build();
    }

    /*
     * Send a request and return the response
     */
    public static String sendRequest(Verb verb, String urlTail) {
        // Create the request
        OAuthRequest request = new OAuthRequest(verb, "https://api.fitbit.com" + urlTail);

        // Sign the request
        service.signRequest(accessToken, request);

        // Send the request and return the response
        Response response = request.send();
        return response.getBody();
    }
}
