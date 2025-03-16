package service.command;

public abstract class AbstractCommand implements Command {
    private String title;

    protected AbstractCommand(String title) {
        this.title = title;
    }

    @Override
    public String getCommandName() {
        return title;
    }

    @Override
    public String toString() {
        return "AbstractCommand{" +
                "title='" + title + '\'' +
                '}';
    }
}
