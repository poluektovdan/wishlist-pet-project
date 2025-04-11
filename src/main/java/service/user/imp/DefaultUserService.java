package service.user.imp;

import db.UsersDB;
import entity.User;
import exception.UserNotFoundException;
import service.command.Command;
import service.user.LoginUserService;
import service.user.StartWorkingUserService;
import util.UtilInput;

import java.util.List;

public class DefaultUserService implements StartWorkingUserService, LoginUserService {
    private List<Command> commandList;
    private UsersDB usersDB;

    public DefaultUserService(List<Command> commandList) {
        this.commandList = commandList;
        this.usersDB = UsersDB.INSTANCE;
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

    @Override
    public boolean login() {
        System.out.println("Введите логин");
        String login = UtilInput.getRequiredStringFromUser();
        System.out.println("Введите пароль");
        String password = UtilInput.getRequiredStringFromUser();

        if (usersDB.findUser(login,password)) {
            return true;
        } else {
            throw new UserNotFoundException("Не верный логин или пароль");
        }
    }
}
