package org.openbiosensing;

import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;

import java.util.Scanner;

/**
 * Created by Greg on 1/25/2015.
 */
public class Fitbit {
    private String apiKey = "1cc9c62eb82f40a5910cced078f3a0a5";
    private String apiSecret = "693ec81e319641208ee7569b50cb7665";
    private String PROTECTED_RESOURCE_URL = "http://api.fitbit.com/1/user/-/profile.json";

    // Create OAuthService Object
    OAuthService service = new ServiceBuilder()
            .provider(FitbitOAuth.class)
            .apiKey(apiKey)
            .apiSecret(apiSecret)
            .build();

    // Get Request Token
    Token requestToken = service.getRequestToken();

    // Validate Request Token
    String authUrl = service.getAuthorizationUrl(requestToken);

    // Get Access Token
    System.out.println("Please enter the verifier: ")
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    Verifier v = new Verifier(input);
    Token accessToken = service.getAccessToken(requestToken, v);

    // Sign Request
    OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
    service.signRequest();
    Response response = request.send();
    System.out.println(response.getBody());


}
