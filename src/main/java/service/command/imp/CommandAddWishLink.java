package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import exception.NoWishlistException;
import exception.WishlistNotFoundException;
import service.command.AbstractCommand;
import service.wish.ChooseWish;

import java.util.Optional;

public class CommandAddWishLink extends AbstractCommand implements ChooseWish {
    public static final CommandAddWishLink INSTANCE = new CommandAddWishLink();

    private CommandAddWishLink() { super("Добавить ссылку для желания");}

    @Override
    public boolean execute() throws JsonProcessingException {
        try {
            Optional<Integer> wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
            if (wishlistId.isPresent()) {
                String currentWishName = getWishes(getWishlistServiceDB(), wishlistId.get(), "ссылку");
                String wishLink = getWishServiceDB().addWishLink(wishlistId.get(), currentWishName);
                getWishlistServiceDB().updateWishLink(wishlistId.get(), currentWishName, wishLink);
            }
        } catch (NoWishlistException | WishlistNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
