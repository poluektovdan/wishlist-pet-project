package service.wish;

import entity.WishPriority;

public interface DBAddWishService {
    String createWish(int wishlistId);
    void removeWish(int wishlistId);
    WishPriority addPriority(int wishlistId);
    String addDescription(int wishlistId);
    String addWishLink(int wishlistId);
}
