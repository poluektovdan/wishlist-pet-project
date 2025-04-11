package service.command.imp;

import service.command.AbstractCommand;

public class CommandCreateWish extends AbstractCommand {
    public static final CommandCreateWish INSTANCE = new CommandCreateWish();

    private CommandCreateWish() {
        super("Создать желание");
    }

    @Override
    public boolean execute() {
        return true;
    }
}
