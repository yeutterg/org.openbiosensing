import java.util.List;

/**
 * Builder for a single bout of sleep
 */
public class SleepBout {
    private final int logId;
    private final String startTime;
    private final boolean isMainSleep;
    private final int efficiency;
    private final int numAwakenings;
    private final int numRestless;
    private final int minutesToFallAsleep;
    private final int minutesAsleep;
    private final int minutesAwake;
    private final int minutesAfterWakeup;
    private final int minutesInBed;
    private final long sleepDurationMs;
    private final long awakeDurationMs;
    private final long restlessDurationMs;
    private final List<MinuteDataPt> minuteData;

    private SleepBout(SleepBoutBuilder builder) {
        this.logId = builder.logId;
        this.startTime = builder.startTime;
        this.isMainSleep = builder.isMainSleep;
        this.efficiency = builder.efficiency;
        this.numAwakenings = builder.numAwakenings;
        this.numRestless = builder.numRestless;
        this.minutesToFallAsleep = builder.minutesToFallAsleep;
        this.minutesAsleep = builder.minutesAsleep;
        this.minutesAwake = builder.minutesAwake;
        this.minutesAfterWakeup = builder.minutesAfterWakeup;
        this.minutesInBed = builder.minutesInBed;
        this.sleepDurationMs = builder.sleepDurationMs;
        this.awakeDurationMs = builder.awakeDurationMs;
        this.restlessDurationMs = builder.restlessDurationMs;
        this.minuteData = builder.minuteData;
    }

    public int getLogId() {
        return logId;
    }

    public String getStartTime() {
        return startTime;
    }

    public long getSleepDurationMs() {
        return sleepDurationMs;
    }

    public boolean isMainSleep() {
        return isMainSleep;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public int getNumAwakenings() {
        return numAwakenings;
    }

    public int getNumRestless() {
        return numRestless;
    }

    public int getMinutesToFallAsleep() {
        return minutesToFallAsleep;
    }

    public int getMinutesAsleep() {
        return minutesAsleep;
    }

    public int getMinutesAwake() {
        return minutesAwake;
    }

    public int getMinutesAfterWakeup() {
        return minutesAfterWakeup;
    }

    public int getMinutesInBed() {
        return minutesInBed;
    }

    public long getAwakeDurationMs() {
        return awakeDurationMs;
    }

    public long getRestlessDurationMs() {
        return restlessDurationMs;
    }

    public List<MinuteDataPt> getMinuteData() {
        return minuteData;
    }

    public static class SleepBoutBuilder {
        private int logId;
        private String startTime;
        private boolean isMainSleep;
        private int efficiency;
        private int numAwakenings;
        private int numRestless;
        private int minutesToFallAsleep;
        private int minutesAsleep;
        private int minutesAwake;
        private int minutesAfterWakeup;
        private int minutesInBed;
        private long sleepDurationMs;
        private long awakeDurationMs;
        private long restlessDurationMs;
        private List<MinuteDataPt> minuteData;

        public SleepBoutBuilder setLogId(String logId) {
            this.logId = Integer.parseInt(logId);
            return this;
        }

        public SleepBoutBuilder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public SleepBoutBuilder setIsMainSleep(String isMainSleep) {
            this.isMainSleep = Boolean.parseBoolean(isMainSleep);
            return this;
        }

        public SleepBoutBuilder setEfficiency(String efficiency) {
            this.efficiency = Integer.parseInt(efficiency);
            return this;
        }

        public SleepBoutBuilder setNumAwakenings(String numAwakenings) {
            this.numAwakenings = Integer.parseInt(numAwakenings);
            return this;
        }

        public SleepBoutBuilder setNumRestless(String numRestless) {
            this.numRestless = Integer.parseInt(numRestless);
            return this;
        }

        public SleepBoutBuilder setMinutesToFallAsleep(String minutesToFallAsleep) {
            this.minutesToFallAsleep = Integer.parseInt(minutesToFallAsleep);
            return this;
        }

        public SleepBoutBuilder setMinutesAsleep(String minutesAsleep) {
            this.minutesAsleep = Integer.parseInt(minutesAsleep);
            return this;
        }

        public SleepBoutBuilder setMinutesAwake(String minutesAwake) {
            this.minutesAwake = Integer.parseInt(minutesAwake);
            return this;
        }

        public SleepBoutBuilder setMinutesAfterWakeup(String minutesAfterWakeup) {
            this.minutesAfterWakeup = Integer.parseInt(minutesAfterWakeup);
            return this;
        }

        public SleepBoutBuilder setMinutesInBed(String minutesInBed) {
            this.minutesInBed = Integer.parseInt(minutesInBed);
            return this;
        }

        public SleepBoutBuilder setSleepDurationMs(String sleepDurationMs) {
            this.sleepDurationMs = Long.parseLong(sleepDurationMs, 10);
            return this;
        }

        public SleepBoutBuilder setAwakeDurationMs(String awakeDurationMs) {
            this.awakeDurationMs = Long.parseLong(awakeDurationMs, 10);
            return this;
        }

        public SleepBoutBuilder setRestlessDurationMs(String restlessDurationMs) {
            this.restlessDurationMs = Long.parseLong(restlessDurationMs, 10);
            return this;
        }

        public SleepBoutBuilder setMinuteData(List<MinuteDataPt> minuteData) {
            this.minuteData = minuteData;
            return this;
        }

        public SleepBout build() {
            return new SleepBout(this);
        }
    }

    @Override
    public String toString() {
        return "SleepBout{" +
                "logId=" + logId +
                ", startTime='" + startTime + '\'' +
                ", isMainSleep=" + isMainSleep +
                ", efficiency=" + efficiency +
                ", numAwakenings=" + numAwakenings +
                ", numRestless=" + numRestless +
                ", minutesToFallAsleep=" + minutesToFallAsleep +
                ", minutesAsleep=" + minutesAsleep +
                ", minutesAwake=" + minutesAwake +
                ", minutesAfterWakeup=" + minutesAfterWakeup +
                ", minutesInBed=" + minutesInBed +
                ", sleepDurationMs=" + sleepDurationMs +
                ", awakeDurationMs=" + awakeDurationMs +
                ", restlessDurationMs=" + restlessDurationMs +
                '}';
    }
}
