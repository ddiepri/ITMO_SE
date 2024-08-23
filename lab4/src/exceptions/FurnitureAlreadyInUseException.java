package exceptions;

public class FurnitureAlreadyInUseException extends RuntimeException {
    public FurnitureAlreadyInUseException(String message) {
        super(message);
    }
}