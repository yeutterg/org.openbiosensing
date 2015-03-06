import java.util.List;

/**
 * Constructor for a 24 hour period of sleep.
 */
public class TotalSleep24h {
    private final int totalMinutesAsleep;
    private final int totalMinutesInBed;
    private final int totalBouts;
    private final List<SleepBout> sleepBouts;

    public int getTotalMinutesAsleep() {
        return totalMinutesAsleep;
    }

    public int getTotalMinutesInBed() {
        return totalMinutesInBed;
    }

    public int getTotalBouts() {
        return totalBouts;
    }

    public List<SleepBout> getSleepBouts() {
        return sleepBouts;
    }

    public TotalSleep24h(int totalMinutesAsleep, int totalMinutesInBed, int totalBouts, List<SleepBout> sleepBouts) {
        this.totalMinutesAsleep = totalMinutesAsleep;
        this.totalMinutesInBed = totalMinutesInBed;
        this.totalBouts = totalBouts;
        this.sleepBouts = sleepBouts;
    }

    @Override
    public String toString() {
        return "Sleep Record: \n" +
                "Total Minutes Asleep," + totalMinutesAsleep + '\n' +
                "Total Minutes In Bed," + totalMinutesInBed + '\n' +
                "Total Sleep Bouts," + totalBouts + '\n' +
                "Bout Details: \n" + sleepBouts.toString().replace("[", "").replace("]", "");
    }
}
