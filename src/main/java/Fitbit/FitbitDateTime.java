package Fitbit;

import java.util.Calendar;
import java.util.Date;

/**
 * Handles date/time requests in the Fitbit-specific format
 * @author Greg Yeutter
 */
public class FitbitDateTime {

    /**
     * Gets the date in Fitbit-specific format from a Java Calendar object
     * @param date The Calendar parameter with the specific day specified
     * @return The date in Fitbit-specific format
     */
    public static String getDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        String month = String.format("%02d", date.get(Calendar.MONTH));
        String day = String.format("%02d", date.get(Calendar.DAY_OF_MONTH));
        return new String(year + "-" + month + "-" + day);
    }

    /**
     * Gets the current date
     * @return The current date in the Fitbit-specific format
     */
    public static String getCurrentDate() {
        Calendar now = Calendar.getInstance();
        return getDate(now);
    }

    /**
     * Gets date from n days ago TODO DEPRECATE
     * @return The specified date in the Fitbit-specific format
     */
    public static String getDateInPast(int daysPrior) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, -daysPrior);
        int year = now.get(Calendar.YEAR);
        String month = String.format("%02d", now.get(Calendar.MONTH));
        String day = String.format("%02d", now.get(Calendar.DAY_OF_MONTH));
        return new String(year + "-" + month + "-" + day);
    }
}
