package service.command.imp;

import service.command.AbstractCommand;

public class CommandShowWishlists extends AbstractCommand {
    public static final CommandShowWishlists INSTANCE = new CommandShowWishlists();

    private CommandShowWishlists() {
        super("Показать вишлисты");
    }

    @Override
    public boolean execute() {
        getWishlistServiceDB().getWishlists(getUserServiceDB().getUserId());
        return true;
    }
}
