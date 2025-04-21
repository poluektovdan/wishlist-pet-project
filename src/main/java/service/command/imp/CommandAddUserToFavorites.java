package service.command.imp;

import service.command.AbstractCommand;

public class CommandAddUserToFavorites extends AbstractCommand {
    public static final CommandAddUserToFavorites INSTANCE = new CommandAddUserToFavorites();

    private CommandAddUserToFavorites() {
        super("Добавить пользователя в избранное");
    }

    @Override
    public boolean execute() {
        System.out.println("Этот функционал будет добавлен позже");
        return true;
    }
}
