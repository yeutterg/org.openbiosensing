package Utils;

/**
 * Constructor for a minute data point
 */
public class MinuteDataPt {
    private final String dateTime;
    private final int amp;

    public String getDateTime() {
        return dateTime;
    }

    public int getAmp() {
        return amp;
    }

    public MinuteDataPt(String dateTime, int amp) {
        this.dateTime = dateTime;
        this.amp = amp;
    }

    @Override
    public String toString() {
        return "Utils.MinuteDataPt{" +
                "dateTime='" + dateTime + '\'' +
                ", amp=" + amp +
                '}';
    }
}
