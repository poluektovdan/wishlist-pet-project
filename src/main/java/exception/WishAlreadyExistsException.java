package exception;

public class WishAlreadyExistsException extends Exception {
    public WishAlreadyExistsException() {}
    public WishAlreadyExistsException(String message) {
        super(message);
    }
}
