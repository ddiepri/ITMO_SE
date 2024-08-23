package architecture.furniture;

import enums.FurnitureType;

public class Wardrobe extends Furniture {

    private WardrobeDoor door;

    public Wardrobe() {
        super(FurnitureType.WARDROBE);
        this.door = new WardrobeDoor("дверца шкафа");
    }

    public void search() {
        System.out.println(getType() + " обшаривается");
        if (door.isOpen()) {
            System.out.println("Поиск внутри шкафа возможен.");
        } else {
            System.out.println("Дверца шкафа закрыта. Откройте её для поиска.");
        }
    }

    // нестатический вложенный класс 
    public class WardrobeDoor {
        private String name;
        private boolean isOpen;

        public WardrobeDoor(String name) {
            this.name = name;
            this.isOpen = false;
        }

        public void open() {
            if (!isOpen) {
                System.out.println(name + " открывается.");
                isOpen = true;
            } else {
                System.out.println(name + " уже открыта.");
            }
        }

        public void close() {
            if (isOpen) {
                System.out.println(name + " закрывается.");
                isOpen = false;
            } else {
                System.out.println(name + " уже закрыта.");
            }
        }

        public boolean isOpen() {
            return isOpen;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }

    public void openDoor() {
        door.open();
    }

    public void closeDoor() {
        door.close();
    }

    public WardrobeDoor getDoor() {
        return door;
    }
}