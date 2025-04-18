import com.fasterxml.jackson.core.JsonProcessingException;
import service.command.Command;
import service.command.imp.CommandExit;
import service.command.imp.CommandLoginUser;
import service.command.imp.CommandRegisterUser;
import service.user.imp.DefaultUserService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        List<Command> commandsForLoginAndRegistration = new ArrayList<>(
                List.of(CommandLoginUser.INSTANCE,
                        CommandRegisterUser.INSTANCE,
                        CommandExit.INSTANCE));
        DefaultUserService userService = new DefaultUserService(commandsForLoginAndRegistration);
        userService.startWorkWithUser();
    }
}