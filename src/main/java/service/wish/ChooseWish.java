package service.wish;

import entity.Wish;
import service.wishlist.imp.WishlistServiceDB;
import util.UtilInput;

import java.util.List;
import java.util.Optional;

public interface ChooseWish {
    default String getWishes(WishlistServiceDB wishlistServiceDB, int wishlistId) {
        String currentWishName = null;
        System.out.println("Выбирете желание, которому хотите добавить описание");
        Optional<List<Wish>> wishes = wishlistServiceDB.getWishlistAsList(wishlistId);
        if (wishes.isPresent()) {
            for(int i=0; i<wishes.get().size(); i++) {
                System.out.println(i + ". " + wishes.get().get(i));
            }
            int userChoice = UtilInput.getRequiredIntFromUser(0,wishes.get().size());
            for(int i=0; i<wishes.get().size(); i++) {
                Wish wish = wishes.get().get(i);
                if(wishes.get().get(userChoice).equals(wish)) {
                    currentWishName = wish.getWish_name();
                }
            }
        }
        return currentWishName;
    }
}
