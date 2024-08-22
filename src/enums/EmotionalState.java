package enums;

public enum EmotionalState {
    SILENT(" молча\n"),
    CAUTIOUS(" осторожно\n"),
    SUPERIOR("лучший в мире "),
    NEUTRAL("нейтрально");

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

    public static EmotionalState value(String description) {
        for (EmotionalState state : values()) {
            if (state.getDescription().equals(description)) {
                return state;
            }
        }
        return null;
    }
}
