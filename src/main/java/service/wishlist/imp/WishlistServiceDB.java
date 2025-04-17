package service.wishlist.imp;

import db.WishlistsDB;
import service.wishlist.DBWishlistService;
import util.UtilInput;

public class WishlistServiceDB implements DBWishlistService {
    private final WishlistsDB wishlistsDB = WishlistsDB.INSTANCE;
    public static final WishlistServiceDB INSTANCE = new WishlistServiceDB();

    private WishlistServiceDB() {}

    @Override
    public void createWishlist(int userId) {
        System.out.println("Введите название вишлиста");
        String wishlistName = UtilInput.getRequiredStringFromUser();
        wishlistsDB.addWishlist(wishlistName, userId);
    }

    @Override
    public void deleteWishlist(int userId) {
        System.out.println("Введите название вишлиста, который хотите удалить");
        String wishlistName = UtilInput.getRequiredStringFromUser();
        if(findWishlist(wishlistName, userId)) {
            wishlistsDB.removeWishlist(wishlistName, userId);
        } else {
            System.out.println("Вишлиста с таким названием не найдено");
        }
    }

    @Override
    public void getWishlists(int userId) {
        System.out.println(wishlistsDB.getWishlists(userId));
    }

    private boolean findWishlist(String wishlistName, int userId) {
        return wishlistsDB.findWishlist(wishlistName, userId);
    }
}
