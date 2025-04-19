package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.command.AbstractCommand;

public class CommandCreateWish extends AbstractCommand {
    public static final CommandCreateWish INSTANCE = new CommandCreateWish();

    private CommandCreateWish() {
        super("Создать желание");
    }

    @Override
    public boolean execute() throws JsonProcessingException {
        try {
            int wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
            String wishName = getWishServiceDB().createWish(wishlistId);
            getWishlistServiceDB().updateWishesInWishlist(wishlistId, wishName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
