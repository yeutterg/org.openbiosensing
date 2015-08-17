package Fitbit;

import Utils.MinuteDataPt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Import/export files
 */
public class FileIO {

    /*
     * Save user data from a night of sleep to a CSV file
     */
    public static void minuteDataToCSV(User user, TotalSleep24h sleep) {
        String name = user.getFullName();
        String date = sleep.getSleepBouts().get(0).getStartTime().substring(1, 11);

        // Prompt user for a file save location
//        System.out.println("Input a location to save the file, and press enter");
//        Scanner sc = new Scanner(System.in);
//        String fileLocation = sc.nextLine();
//        sc.close();

        // Generate CSV file with time-series data
        try {
            FileWriter w = new FileWriter(name + "_" + date + ".csv");

            // Header: user info, sleep info
            w.append(user.toString());
            w.append('\n');
            w.append(sleep.toString());
            w.append('\n');

            // Get number of sleep bouts
            int numBouts = sleep.getTotalBouts();

            // Iterate through all bouts
            for (int i = 0; i < numBouts; i++) {
                w.append("Bout " + i+1 + "\n");

                // Iterate through all minute data points
                List<MinuteDataPt> minuteData = sleep.getSleepBouts().get(i).getMinuteData();
                for (MinuteDataPt pt : minuteData) {
                    w.append(pt.getDateTime());
                    w.append(',');
                    w.append(Integer.toString(pt.getAmp()));
                    w.append("\n");
                }

                w.flush();
                w.close();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e);
            System.exit(-1);
        }


    }
}
