package service.command;

public interface Command {

    boolean execute();

    String getCommandName();
}
