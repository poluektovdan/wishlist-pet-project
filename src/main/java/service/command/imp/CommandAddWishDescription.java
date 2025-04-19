package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.command.AbstractCommand;
import util.UtilInput;

public class CommandAddWishDescription extends AbstractCommand {
    public static final CommandAddWishDescription INSTANCE = new CommandAddWishDescription();

    private CommandAddWishDescription() {
        super("Добавить описание желанию");
    }


    @Override
    public boolean execute() throws JsonProcessingException {
        int wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
        String wishDescription = getWishServiceDB().addDescription(wishlistId);
        getWishlistServiceDB().updateDescriptionOfWish(wishlistId, wishDescription, getWishServiceDB().getCurrentWishName());
        return true;
    }
}
