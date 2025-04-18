package service.wish;

public interface DBAddWishService {
    String createWish(int wishlistId);
    void removeWish(int wishlistId);
    void addPriority(int wishlistId);
    String addDescription(int wishlistId);
    void addWishLink(int wishlistId);
}
