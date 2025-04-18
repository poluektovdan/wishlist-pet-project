package service.wish.imp;

import db.WishDB;
import entity.WishPriority;
import service.wish.DBAddWishService;
import util.UtilInput;

import java.util.ArrayList;
import java.util.List;

public class WishServiceDB implements DBAddWishService {
    private final WishDB wishDB = WishDB.INSTANCE;
    public static final WishServiceDB INSTANCE = new WishServiceDB();

    private WishServiceDB() {}

    @Override
    public String createWish(int wishlistId) {
        System.out.println("Введите название");
        String wishName = UtilInput.getRequiredStringFromUser();
        return wishDB.createWish(wishName, wishlistId);
    }

    @Override
    public void removeWish(int wishlistId) {
        System.out.println("Введите название желания, которое хотите удалить");
        String wishName = UtilInput.getRequiredStringFromUser();
        wishDB.removeWish(wishName, wishlistId);
    }

    @Override
    public void addPriority(int wishlistId) {
        System.out.println("Введите название желания, которому хотите добавить приоритет");
        String wishName = UtilInput.getRequiredStringFromUser();
        System.out.println("Выберите приоритет");
        List<WishPriority> prioritiesList = new ArrayList<>(
                List.of(WishPriority.ONE,
                        WishPriority.TWO,
                        WishPriority.THREE,
                        WishPriority.FOUR,
                        WishPriority.FIVE)
        );
        for (WishPriority priority : prioritiesList) {
            System.out.println(priority.getPriority());
        }
        int userChoice = UtilInput.getRequiredIntFromUser(1, prioritiesList.size());
        switch (userChoice) {
            case 1:
                wishDB.addWishPriority(wishName, wishlistId, WishPriority.ONE);
                break;
            case 2:
                wishDB.addWishPriority(wishName, wishlistId, WishPriority.TWO);
                break;
            case 3:
                wishDB.addWishPriority(wishName, wishlistId, WishPriority.THREE);
                break;
            case 4:
                wishDB.addWishPriority(wishName, wishlistId, WishPriority.FOUR);
                break;
            case 5:
                wishDB.addWishPriority(wishName, wishlistId, WishPriority.FIVE);
                break;
            default:
                break;
        }
    }

    @Override
    public String addDescription(int wishlistId) {
        System.out.println("Введите название желания, которому хотите добавить описание");
        String wishName = UtilInput.getRequiredStringFromUser();
        System.out.println("Напишите описание");
        String description = UtilInput.getRequiredStringFromUser();
        return wishDB.addWishDescription(wishName, wishlistId, description);
    }

    @Override
    public void addWishLink(int wishlistId) {
        System.out.println("Введите название желания, которому хотите добавить ссылку");
        String wishName = UtilInput.getRequiredStringFromUser();
        System.out.println("Напишите ссылку");
        String link = UtilInput.getRequiredStringFromUser();
        wishDB.addWishLink(wishName, wishlistId, link);
    }
}
