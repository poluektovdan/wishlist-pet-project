package service.user.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import service.command.ChooseCommand;
import service.command.Command;
import service.user.StartWorkingNewUserService;

import java.util.List;

public class DefaultUserService implements StartWorkingNewUserService, ChooseCommand {
    private final List<Command> commandList;

    public DefaultUserService(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void startWorkWithUser() throws JsonProcessingException {
        System.out.println("Привет, дорогой пользователь");
        boolean isWorking = chooseCommand(commandList);
        while (isWorking) {
            isWorking = chooseCommand(commandList);
        }
    }
}
