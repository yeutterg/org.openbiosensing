/**
 * Created by Greg on 3/4/2015.
 */
public class Fitbit {

    public static void main(String[] args) {
        startup();
    }

    /*
     * Start the application
     */
    public static void startup() {
        // Check if user already authorized. If not, run through auth process
        String[] auth = PropertyHandler.loadAuthorization();
        if (auth == null) {
            OAuth.authorize();
        } else {
            OAuth.reconnect(auth);
        }

    }
}
