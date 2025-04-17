package service.wishlist;

public interface DBWishlistService {
    void createWishlist(int userId);
    void deleteWishlist(int userId);
    void getWishlists(int userId);
}
