package service.user.imp;

import entity.User;
import exception.UserNotFoundException;
import service.command.Command;
import service.user.LoginUserService;
import service.user.SearchUserService;
import service.user.StartWorkingUserService;
import util.UtilInput;

import java.util.List;
import java.util.Optional;

public class DefaultUserService implements StartWorkingUserService, LoginUserService, SearchUserService {
    private List<Command> commandList;
    private List<User> userList;

    public DefaultUserService(List<Command> commandList, List<User> userList) {
        this.commandList = commandList;
        this.userList = userList;
    }

    @Override
    public void startWorkWithUser(String username) {
        System.out.println("Привет, " + username);
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
    public Optional<User> login() {
        System.out.println("Введите логин");
        String login = UtilInput.getRequiredStringFromUser();
        System.out.println("Введите пароль");
        String password = UtilInput.getRequiredStringFromUser();
        Optional<User> user = getUserByLogin(login);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        } else {
            throw new UserNotFoundException("Не верный логин или пароль");
        }
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
