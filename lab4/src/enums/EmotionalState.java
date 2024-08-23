package enums;

public enum EmotionalState {
    SILENT(" молча\n"),
    QUIET(" тихонько\n"),
    CAUTIOUS(" осторожно\n"),
    SUPERIOR("лучший в мире "),
    NEUTRAL("нейтрально"),
    TENSE(" с огромным напряжением\n");

    private final String description;

    EmotionalState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}