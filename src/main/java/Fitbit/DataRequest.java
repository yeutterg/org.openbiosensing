package Fitbit;

import java.util.Calendar;

/**
 * DataRequest: Handles requests for specific data points from the Fitbit API platform
 * @author Greg Yeutter
 */
public class DataRequest {

    /**
     * Gets user data for a specified day
     * @param date the date specification
     */
    public static void getUserDataForDay(Calendar date) {
        String fitbitDate = FitbitDateTime.getDate(date);
        TotalSleep24h lastNight = Request.getSleep(FitbitPropertyHandler.currentUser, fitbitDate);

        // Output last night's data to a csv file
        FileIO.minuteDataToCSV(FitbitPropertyHandler.currentUser, lastNight);
    }

}
