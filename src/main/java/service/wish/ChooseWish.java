package service.wish;

import entity.Wish;
import exception.NoWishesInWishlistException;
import service.wishlist.imp.WishlistServiceDB;
import util.UtilInput;

import java.util.List;
import java.util.Optional;

public interface ChooseWish {
    default String getWishes(WishlistServiceDB wishlistServiceDB, int wishlistId, String whatToEdit) {
        String currentWishName = null;
        System.out.println("Выбирете желание, которому хотите добавить " + whatToEdit);
        try{
            Optional<List<Wish>> wishes = wishlistServiceDB.getWishlistAsList(wishlistId);
            if (wishes.isPresent()) {
                for(int i=0; i<wishes.get().size(); i++) {
                    System.out.println(i+1 + ". " + wishes.get().get(i));
                }
                int userChoice = UtilInput.getRequiredIntFromUser(1,wishes.get().size());
                for(int i=0; i<wishes.get().size(); i++) {
                    Wish wish = wishes.get().get(i);
                    if(wishes.get().get(userChoice-1).equals(wish)) {
                        currentWishName = wish.getWish_name();
                    }
                }
            }
        } catch(NoWishesInWishlistException e){
            System.out.println(e.getMessage());
        }

        return currentWishName;
    }
}
