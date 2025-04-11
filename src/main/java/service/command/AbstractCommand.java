package service.command;

import service.user.imp.UserServiceDB;

public abstract class AbstractCommand implements Command {
    private String title;
    private UserServiceDB userServiceDB;

    protected AbstractCommand(String title) {
        this.title = title;
        this.userServiceDB = UserServiceDB.INSTANCE;
    }

    protected UserServiceDB getUserServiceDB() {
        return userServiceDB;
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
