/**
 * Main Fitbit class
 */
public class Fitbit {

    User user;

    public static void main(String[] args) {
        // Load the program and authenticate if necessary
        startup();

        // Get the user's profile and write it to a file
        User currentUser = Request.getProfile();
        PropertyHandler.writeUser(currentUser);

        // Get most recent sleep data for the user
        TotalSleep24h lastNight = Request.getSleep(currentUser, DateTime.getCurrentDate());

        // Output last night's data to a csv file

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
