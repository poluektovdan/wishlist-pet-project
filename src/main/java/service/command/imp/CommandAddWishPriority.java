package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.WishPriority;
import exception.NoWishlistException;
import exception.WishlistNotFoundException;
import service.command.AbstractCommand;
import service.wish.ChooseWish;

import java.util.Optional;

public class CommandAddWishPriority extends AbstractCommand implements ChooseWish {
    public static final CommandAddWishPriority INSTANCE = new CommandAddWishPriority();

    private CommandAddWishPriority() {
        super("Добавить приоритет желанию");
    }

    @Override
    public boolean execute() throws JsonProcessingException {
        try {
            Optional<Integer> wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
            if (wishlistId.isPresent()) {
                String currentWishName = getWishes(getWishlistServiceDB(), wishlistId.get(), "приоритет");
                WishPriority priority = getWishServiceDB().addPriority(wishlistId.get(), currentWishName);
                getWishlistServiceDB().updatePriorityOfWish(wishlistId.get(), currentWishName, priority);
            }
        } catch (NoWishlistException | WishlistNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
