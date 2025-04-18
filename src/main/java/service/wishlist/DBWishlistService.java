package service.wishlist;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DBWishlistService {
    void createWishlist(int userId);
    void deleteWishlist(int userId);
    void getWishlists(int userId);
    int findWishlistId(int userId);
    void updateWishesInWishlist(int wishlistID, String wishName) throws JsonProcessingException;
    String getWishlist(int wishlistID);
}
