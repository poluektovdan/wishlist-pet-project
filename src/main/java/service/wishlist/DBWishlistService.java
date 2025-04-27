package service.wishlist;

import com.fasterxml.jackson.core.JsonProcessingException;
import exception.NoWishlistException;
import exception.WishAlreadyExistsException;
import exception.WishlistNotFoundException;

import java.util.Optional;

public interface DBWishlistService {
    void createWishlist(int userId);
    void deleteWishlist(int userId);
    void getWishlists(int userId);
    Optional<Integer> findWishlistId(int userId) throws NoWishlistException, WishlistNotFoundException;
    void updateWishesInWishlist(int wishlistID, String wishName) throws JsonProcessingException, WishAlreadyExistsException;
    String getWishlist(int wishlistID);
}
