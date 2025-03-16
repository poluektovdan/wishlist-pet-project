import entity.User;
import service.command.Command;
import service.command.imp.CommandExit;
import service.user.imp.DefaultUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Command> commands = new ArrayList<>(
                List.of(CommandExit.INSTANCE));
        List<User> users = new ArrayList<>();
        users.add(new User(1, "admin", "admin"));
        DefaultUserService userService = new DefaultUserService(commands, users);
        boolean userLogined = true;
        while (userLogined) {
            try {
                Optional<User> user = userService.login();
                if(user.isPresent()) {
                    userLogined = false;
                    userService.startWorkWithUser(user.get().getLogin());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}