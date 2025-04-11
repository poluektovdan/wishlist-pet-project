package service.user.imp;

import db.UsersDB;
import exception.UserNotFoundException;
import service.user.DBWorkingUserService;
import util.UtilInput;

public class UserServiceDB implements DBWorkingUserService {
    private final UsersDB usersDB = UsersDB.INSTANCE;
    public static final UserServiceDB INSTANCE = new UserServiceDB();

    private UserServiceDB() {}

    @Override
    public boolean login() {
        System.out.println("Введите логин");
        String login = UtilInput.getRequiredStringFromUser();
        System.out.println("Введите пароль");
        String password = UtilInput.getRequiredStringFromUser();

        if (usersDB.findUser(login, password)) {
            return true;
        } else {
            throw new UserNotFoundException("Не верный логин или пароль");
        }
    }

    @Override
    public boolean registerUser() {
        System.out.println("Введите логин");
        String login = UtilInput.getRequiredStringFromUser();
        System.out.println("Введите пароль");
        String password = UtilInput.getRequiredStringFromUser();
        if(getUserByLogin(login)) {
            System.out.println("Такой пользователь уже существует");
            return false;
        } else {
            usersDB.addUser(login, password);
            return true;
        }
    }

    @Override
    public boolean getUserByLogin(String login) {
        return usersDB.findUser(login);
    }
}
