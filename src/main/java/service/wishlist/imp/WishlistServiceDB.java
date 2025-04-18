package service.wishlist.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.WishlistsDB;
import entity.Wish;
import service.wishlist.DBWishlistService;
import util.UtilInput;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int findWishlistId(int userId) {
        System.out.println("Введите название вишлиста, в который вы хотите добавить желание");
        String wishlistName = UtilInput.getRequiredStringFromUser();
        return wishlistsDB.findWishlistId(wishlistName, userId);
    }

    @Override
    public void updateWishesInWishlist(int wishlistID, String wishName) throws JsonProcessingException {
        String wishlist = getWishlist(wishlistID);
        if(wishlist != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Wish> wishes = objectMapper.readValue(wishlist, new TypeReference<List<Wish>>() {});
            wishes.add(new Wish(wishName));
            wishlistsDB.updateWishesInWishlist(wishes, wishlistID);
        } else {
            wishlistsDB.updateWishesInWishlist(initializeNewWishlist(wishName), wishlistID);
        }
    }

    @Override
    public String getWishlist(int wishlistID) {
        return wishlistsDB.getWishlist(wishlistID);
    }

    private List<Wish> initializeNewWishlist(String wishName) {
        List<Wish> wishes = new ArrayList<>();
        wishes.add(new Wish(wishName));
        return wishes;
    }

    public void updateDescriptionOfWish(int wishlistID, String description, String wishName) throws JsonProcessingException {
        String wishlist = getWishlist(wishlistID);
        if(wishlist != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Wish> wishes = objectMapper.readValue(wishlist, new TypeReference<List<Wish>>() {});
            for(Wish wish : wishes) {
                if(wish.getWishName().equals(wishName)) {
                    wish.setWishDescription(description);
                }
            }
            wishlistsDB.updateWishesInWishlist(wishes, wishlistID);
        }
    }
}
