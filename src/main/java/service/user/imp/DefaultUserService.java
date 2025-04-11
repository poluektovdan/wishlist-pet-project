package service.user.imp;

import service.command.Command;
import service.user.StartWorkingUserService;
import util.UtilInput;

import java.util.List;

public class DefaultUserService implements StartWorkingUserService {
    private List<Command> commandList;

    public DefaultUserService(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void startWorkWithUser() {
        System.out.println("Привет, дорогой пользователь");
        boolean isWorking = chooseCommand();
        while (isWorking) {
            isWorking = chooseCommand();
        }
    }


    private boolean chooseCommand() {
        System.out.println("Выбери команду, которую хочешь выполнить");
        for (int i = 1; i <= commandList.size(); i++) {
            System.out.printf("%s - %s%n", i, commandList.get(i-1).getCommandName());
        }
        int numberChoose = UtilInput.getRequiredIntFromUser(1, commandList.size());
        return commandList.get(numberChoose-1).execute();
    }
}
