import db.UsersDB;
import entity.User;
import service.command.Command;
import service.command.imp.CommandExit;
import service.user.imp.DefaultUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UsersDB instance = UsersDB.INSTANCE;

        List<Command> commands = new ArrayList<>(
                List.of(CommandExit.INSTANCE));
        DefaultUserService userService = new DefaultUserService(commands);
        boolean userLogined = true;
        while (userLogined) {
            try {
                if(userService.login()) {
                    userLogined = false;
                    userService.startWorkWithUser();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}