import java.util.Calendar;

/**
 * Created by Greg on 3/5/2015.
 */
public class DateTime {

    /*
     * Get the current date
     */
    public static String getCurrentDate() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        String month = String.format("%02d", now.get(Calendar.MONTH));
        String day = String.format("%02d", now.get(Calendar.DAY_OF_MONTH));
        return new String(year + "-" + month + "-" + day);
    }
}
