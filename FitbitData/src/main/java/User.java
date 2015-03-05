/**
 * Builder for a user
 */
public class User {
    private final String encodedId;
    private final String fullName;
    private final String gender;
    private final String city;
    private final String state;
    private final String country;
    private final String timeZone;
    private final String birthDate;
    private final int heightCm;
    private final Double weightKg;
    private final Double strideLengthRunningCm;
    private final Double strideLengthWalkingCm;


    private User(UserBuilder builder) {
        this.encodedId = builder.encodedId;
        this.fullName = builder.fullName;
        this.gender = builder.gender;
        this.city = builder.city;
        this.state = builder.state;
        this.country = builder.country;
        this.timeZone = builder.timeZone;
        this.birthDate = builder.birthDate;
        this.heightCm = builder.heightCm;
        this.weightKg = builder.weightKg;
        this.strideLengthRunningCm = builder.strideLengthRunningCm;
        this.strideLengthWalkingCm = builder.strideLengthWalkingCm;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public Double getStrideLengthRunningCm() {
        return strideLengthRunningCm;
    }

    public Double getStrideLengthWalkingCm() {
        return strideLengthWalkingCm;
    }

    @Override
    public String toString() {
        return "User{" +
                "encodedId='" + encodedId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg +
                ", strideLengthRunningCm=" + strideLengthRunningCm +
                ", strideLengthWalkingCm=" + strideLengthWalkingCm +
                '}';
    }

    public static class UserBuilder {
        private String encodedId;
        private String fullName;
        private String gender;
        private String city;
        private String state;
        private String country;
        private String timeZone;
        private String birthDate;
        private int heightCm;
        private Double weightKg;
        private Double strideLengthRunningCm;
        private Double strideLengthWalkingCm;

        public UserBuilder setEncodedId(String encodedId) {
            this.encodedId = encodedId;
            return this;
        }

        public UserBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public UserBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public UserBuilder setTimeZone(String timeZone) {
            this.timeZone = timeZone;
            return this;
        }

        public UserBuilder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder setHeightCm(String heightCm) {
            this.heightCm = Integer.parseInt(heightCm);
            return this;
        }

        public UserBuilder setWeightKg(String weightKg) {
            this.weightKg = Double.parseDouble(weightKg);
            return this;
        }

        public UserBuilder setStrideLengthRunningCm(String strideLengthRunningCm) {
            this.strideLengthRunningCm = Double.parseDouble(strideLengthRunningCm);
            return this;
        }

        public UserBuilder setStrideLengthWalkingCm(String strideLengthWalkingCm) {
            this.strideLengthWalkingCm = Double.parseDouble(strideLengthWalkingCm);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
