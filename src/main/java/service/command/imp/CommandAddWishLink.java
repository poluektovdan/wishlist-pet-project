package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.command.AbstractCommand;

public class CommandAddWishLink extends AbstractCommand {
    public static final CommandAddWishLink INSTANCE = new CommandAddWishLink();

    private CommandAddWishLink() { super("Добавить ссылку для желания");}

    @Override
    public boolean execute() throws JsonProcessingException {
        int wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
        String wishLink = getWishServiceDB().addWishLink(wishlistId);
        getWishlistServiceDB().updateWishLink(wishlistId, getWishServiceDB().getCurrentWishName(), wishLink);
        return true;
    }
}
