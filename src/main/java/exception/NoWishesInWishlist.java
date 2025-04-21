package exception;

public class NoWishesInWishlist extends RuntimeException {
    public NoWishesInWishlist(String message) {
        super(message);
    }
}
