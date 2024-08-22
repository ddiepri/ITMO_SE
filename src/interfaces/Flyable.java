package interfaces;

import architecture.RoomItem;

/**
 * interface representing flyable behavior
 */

public interface Flyable {
    void flyIn(RoomItem location);    
    void flyOut();                
    void setSpeed(int speed);      
}