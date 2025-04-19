package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.WishPriority;
import service.command.AbstractCommand;

public class CommandAddWishPriority extends AbstractCommand {
    public static final CommandAddWishPriority INSTANCE = new CommandAddWishPriority();

    private CommandAddWishPriority() {
        super("Добавить приоритет желанию");
    }

    @Override
    public boolean execute() throws JsonProcessingException {
        int wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
        WishPriority priority = getWishServiceDB().addPriority(wishlistId);
        getWishlistServiceDB().updatePriorityOfWish(wishlistId, getWishServiceDB().getCurrentWishName(), priority);
        return true;
    }
}
