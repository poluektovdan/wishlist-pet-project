package service.command.imp;

import service.command.AbstractCommand;

public class CommandExit extends AbstractCommand {
    public static final CommandExit INSTANCE = new CommandExit();

    private CommandExit() {super("Выход");}

    @Override
    public boolean execute() {
        return false;
    }
}
