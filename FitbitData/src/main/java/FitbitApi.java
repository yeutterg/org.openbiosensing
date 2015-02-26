import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 * Scribe OAuth 1.0a call to Fitbit API
 */
public class FitbitApi extends DefaultApi10a {
    public static final String BASE_URL = "http://api.fitbit.com/";
    private static final String REQUEST_TOKEN_RESOURCE = "api.fitbit.com/oauth/request_token";
    private static final String AUTHORIZE_URL = "https://api.fitbit.com/oauth/authorize?oauth_token=%s";
    private static final String ACCESS_TOKEN_RESOURCE = "api.fitbit.com/oauth/access_token";

    @Override
    public String getAccessTokenEndpoint() {
        return "https://" + ACCESS_TOKEN_RESOURCE;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return "https://" + REQUEST_TOKEN_RESOURCE;
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }
}
