package service.command;

import util.UtilInput;

import java.util.List;

public interface ChooseCommand {
    default boolean chooseCommand(List<Command> commandList) {
        System.out.println("Выбери команду, которую хочешь выполнить");
        for (int i = 1; i <= commandList.size(); i++) {
            System.out.printf("%s - %s%n", i, commandList.get(i - 1).getCommandName());
        }
        int numberChoose = UtilInput.getRequiredIntFromUser(1, commandList.size());
        return commandList.get(numberChoose - 1).execute();
    }
}
