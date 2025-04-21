package service.wish;

import entity.WishPriority;

public interface DBAddWishService {
    String createWish(int wishlistId);
    void removeWish(int wishlistId);
    WishPriority addPriority(int wishlistId, String wishName);
    String addDescription(int wishlistId, String wishName);
    String addWishLink(int wishlistId, String wishName);
}
