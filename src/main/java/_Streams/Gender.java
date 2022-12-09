package _Streams;

public enum Gender {

    MALE("male"), FEMALE("female");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String get() {
        return gender;
    }

}
