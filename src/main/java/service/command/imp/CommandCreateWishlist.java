package service.command.imp;

import service.command.AbstractCommand;

public class CommandCreateWishlist extends AbstractCommand {
    public static final CommandCreateWishlist INSTANCE = new CommandCreateWishlist();

    private CommandCreateWishlist() {
        super("Создать вишлист");
    }

    @Override
    public boolean execute() {
        return true;
    }
}
