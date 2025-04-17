package service.wishlist;

import entity.Wish;
import entity.Wishlist;

public interface WishlistService {
    Wishlist getWishlist(int id);
    void addWishToList(Wish wish);
    void removeWishFromList(Wish wish);
}
