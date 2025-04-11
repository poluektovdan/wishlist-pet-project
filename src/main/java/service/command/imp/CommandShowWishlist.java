package service.command.imp;

import service.command.AbstractCommand;

public class CommandShowWishlist extends AbstractCommand {
    public static final CommandShowWishlist INSTANCE = new CommandShowWishlist();

    private CommandShowWishlist() {
        super("Показать вишлист");
    }

    @Override
    public boolean execute() {
        return true;
    }
}
