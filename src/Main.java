import characters.FrekenBock;
import characters.Kid;
import characters.HousekeeperTamer;
import characters.Someone;
import enums.EmotionalState;
import enums.RoomType;
import architecture.Door;
import architecture.Window;
import architecture.Room;
import architecture.Apartment;


public class Main {
    public static void main(String[] args) {

        Door door = new Door();
        Window window = new Window();

        Room kitchen = new Room(RoomType.KITCHEN);
        Room roomKid = new Room(RoomType.ROOMKID);

        door.setRoom(roomKid); 
        window.setRoom(kitchen); 

        Apartment apartment = new Apartment();
        apartment.addRoom(kitchen);
        apartment.addRoom(roomKid);

        FrekenBock frekenBock = new FrekenBock();
        Kid kid = new Kid();
        HousekeeperTamer housekeeperTamer = new HousekeeperTamer();
        Someone someone = new Someone();


        // Фрекен Бок на это ничего не ответила. Она стояла молча и о чем-то думала. 
        frekenBock.respondNothing(); 
        frekenBock.setEmotionalState(EmotionalState.SILENT);
        frekenBock.stand();
        frekenBock.performActionBasedOnEmotion();
        frekenBock.think();
        
        // Тут Малыш услышал, что кто-то осторожно запер снаружи дверь его комнаты. Малыш расхохотался. 
        someone.setEmotionalState(EmotionalState.CAUTIOUS);
        someone.lock(door);
        someone.performActionBasedOnEmotion();
         
        kid.checkDoorStatus(door);
        kid.giggle();

        // Лучший в мире укротитель домомучительниц явно влетел в квартиру через кухонное окно,
        // чтобы помочь домомучительнице понять на собственном опыте, что значит сидеть взаперти.
        housekeeperTamer.setEmotionalState(EmotionalState.SUPERIOR);
        housekeeperTamer.performActionBasedOnEmotion();
        housekeeperTamer.flyIn(window);
        housekeeperTamer.helpUnderstand();
        housekeeperTamer.demonstrateLockedExperience();
    }
}