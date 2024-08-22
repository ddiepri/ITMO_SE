package interfaces;

/**
 * interface representing lockable behavior
 */

public interface Lockable {
    void lock();             
    boolean isLocked();      
    void unlock();            
}