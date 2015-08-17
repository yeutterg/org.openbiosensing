package Misfit;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;

/**
 * Misfit API: Handles the connection with the Misfit API
 * @author Greg Yeutter
 */
public class MisfitApi extends DefaultApi20 {

    /**
     * Gets the Misfit API access token endpoint
     * @return The Misfit access token endpoint
     */
    @Override
    public String getAccessTokenEndpoint() {
        return null;
    }

    /**
     * Gets the Misfit API authorization URL
     * @param oAuthConfig The OAuth Configuration
     * @return The Misfit authorization URL
     */
    @Override
    public String getAuthorizationUrl(OAuthConfig oAuthConfig) {
        return null;
    }
}
