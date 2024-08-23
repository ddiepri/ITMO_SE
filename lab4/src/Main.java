import enums.EmotionalState;
import enums.RoomType;
import architecture.furniture.Chair;
import architecture.furniture.Table;
import architecture.furniture.Wardrobe;
import architecture.items.Door;
import architecture.items.Taskbook;
import architecture.items.Window;
import architecture.sctructures.Apartment;
import architecture.sctructures.Room;
import characters.FrekenBock;
import characters.HousekeeperTamer;
import characters.Kid;
import characters.Someone;
import exceptions.FurnitureAlreadyInUseException;

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

        Wardrobe wardrobe = new Wardrobe();
        Wardrobe.WardrobeDoor wardrobeDoor = wardrobe.new WardrobeDoor("дверца шкафа");  
        Taskbook taskbook = new Taskbook();  
        Chair chair = new Chair(); 
        Table table = new Table(); 


        // малыш не считал, что это лучший способ позабавиться
        kid.considerBadIdea();

        // но ведь он обещал помогать карлсону чем сможет
        kid.promiseToHelp();

        // поэтому он тихонько подкрался к своему столу, сел на стул и открыл задачник
        try {
            kid.sneakToFurniture(table);
            kid.setEmotionalState(EmotionalState.QUIET);
            kid.performActionBasedOnEmotion();
            kid.sitOnFurniture(chair); 
            taskbook.open();
        } catch (FurnitureAlreadyInUseException e) {
            System.out.println("ошибка: " + e.getMessage());
        }

        // он слышал, как фрекен бок обшаривает шкаф
        kid.listen();
        try {
            frekenBock.search(wardrobe);  
        } catch (FurnitureAlreadyInUseException e) {
            System.out.println("ошибка: " + e.getMessage());
        }

        // сейчас она обернется - он ждал этого момента с огромным напряжением
        frekenBock.turnAround();
        kid.waitMoment();
        kid.setEmotionalState(EmotionalState.TENSE);
        kid.performActionBasedOnEmotion();

        // и в самом деле, она тут же вынырнула из недр шкафа, и первое, что она увидела, был малыш
        frekenBock.emergeFrom(wardrobe);
        frekenBock.see(kid);

        // она попятилась назад и прислонилась к дверцам шкафа
        frekenBock.stepBack();
        frekenBock.leanOn(wardrobeDoor);

        // так она простояла довольно долго, не говоря ни слова и не сводя с него глаз
        frekenBock.stand();
        frekenBock.setEmotionalState(EmotionalState.SILENT);
        frekenBock.performActionBasedOnEmotion();

        // она только несколько раз опускала веки, словно проверяя себя, не обман ли это зрения
        frekenBock.blinkEyes();

        // фрекен бок на это ничего не ответила. она стояла молча и о чем-то думала
        frekenBock.respondNothing(); 
        frekenBock.setEmotionalState(EmotionalState.SILENT);
        frekenBock.stand();
        frekenBock.performActionBasedOnEmotion();
        frekenBock.think();
        
        // тут малыш услышал, что кто-то осторожно запер снаружи дверь его комнаты. малыш расхохотался
        someone.setEmotionalState(EmotionalState.CAUTIOUS);
        someone.lock(door);
        someone.performActionBasedOnEmotion();
         
        kid.checkDoorStatus(door);
        kid.giggle();

        // лучший в мире укротитель домомучительниц явно влетел в квартиру через кухонное окно,
        // чтобы помочь домомучительнице понять на собственном опыте, что значит сидеть взаперти
        housekeeperTamer.setEmotionalState(EmotionalState.SUPERIOR);
        housekeeperTamer.performActionBasedOnEmotion();
        housekeeperTamer.flyIn(window);
        housekeeperTamer.helpUnderstand();
        housekeeperTamer.demonstrateLockedExperience();

        // фрекен бок ничего не заметила. она все еще стояла молча и, видно, что-то обдумывала
        frekenBock.noticeNothing();
        
        frekenBock.stand();
        frekenBock.setEmotionalState(EmotionalState.SILENT);
        frekenBock.performActionBasedOnEmotion();

        frekenBock.think();

        // наконец она взялась за ручку, нажала раз, другой, третий. но дверь не открывалась
        frekenBock.tryToOpenDoor(door);

        // тогда фрекен бок навалилась на нее всем телом, но и это не помогло 
        frekenBock.pushWithBody(door);
        
        // фрекен бок взревела
        frekenBock.roar();
    }
}