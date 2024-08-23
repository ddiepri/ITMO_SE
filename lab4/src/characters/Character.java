package characters;

import java.util.Objects;

import enums.EmotionalState;

public abstract class Character {
    private String name;
    private EmotionalState emotionalState = EmotionalState.NEUTRAL;

    public Character() {
        this.name = "кто-то";
    }
    
    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public EmotionalState getEmotionalState() {
        return emotionalState;
    }

    public void setEmotionalState(EmotionalState emotionalState) {
        this.emotionalState = emotionalState;
    }

    public void performActionBasedOnEmotion() {
        System.out.print(emotionalState.getDescription());
    }

    @Override
    public String toString() {
        return "персонаж " + getName();
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        return ((Character) o).name.equals(this.name) && 
               ((Character) o).emotionalState == this.emotionalState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emotionalState);
    }
}