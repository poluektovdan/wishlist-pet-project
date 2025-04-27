package exception;

public class WishlistNotFoundException extends Exception {
    public WishlistNotFoundException() {}
    public WishlistNotFoundException(String message) {
        super(message);
    }
}
