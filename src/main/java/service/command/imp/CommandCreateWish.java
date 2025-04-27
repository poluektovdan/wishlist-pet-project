package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import exception.NoWishlistException;
import exception.WishAlreadyExistsException;
import exception.WishlistNotFoundException;
import service.command.AbstractCommand;

import java.util.Optional;

public class CommandCreateWish extends AbstractCommand {
    public static final CommandCreateWish INSTANCE = new CommandCreateWish();

    private CommandCreateWish() {
        super("Создать желание");
    }

    @Override
    public boolean execute() throws JsonProcessingException {
        try {
            Optional<Integer> wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
            if (wishlistId.isPresent()) {
                String wishName = getWishServiceDB().createWish(wishlistId.get());
                getWishlistServiceDB().updateWishesInWishlist(wishlistId.get(), wishName);
            }
        } catch (NoWishlistException | WishlistNotFoundException | WishAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
