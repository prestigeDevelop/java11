package _Arrays;

public enum Level {
    HIGE(3), MEDIUM(2), LOW(1);

    private int level;

    Level(int level) {
        this.level = level;
    }

    int get() {
        return this.level;
    }
}
