package exception;

public class NoWishesInWishlistException extends Exception {
    public NoWishesInWishlistException() {}
    public NoWishesInWishlistException(String message) {
        super(message);
    }
}
