package Fitbit;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 * Scribe Authorization URLS for Fitbit.Fitbit API
 */
public class FitbitApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "https://api.fitbit.com/oauth/authorize?oauth_token=%s";

    @Override
    public String getAccessTokenEndpoint() {
        return "https://api.fitbit.com/oauth/access_token";
    }

    @Override
    public String getRequestTokenEndpoint() {
        return "https://api.fitbit.com/oauth/request_token";
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }
}
