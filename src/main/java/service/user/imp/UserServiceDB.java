package service.user.imp;

import db.UsersDB;
import entity.User;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import service.user.DBWorkingUserService;
import util.UtilInput;

import java.util.Optional;

public class UserServiceDB implements DBWorkingUserService {
    private final UsersDB usersDB = UsersDB.INSTANCE;
    public static final UserServiceDB INSTANCE = new UserServiceDB();

    private int userId;

    private UserServiceDB() {}

    @Override
    public Optional<User> login() {
        System.out.println("Введите логин");
        String login = UtilInput.getRequiredStringFromUser();
        System.out.println("Введите пароль");
        String password = UtilInput.getRequiredStringFromUser();

        if (usersDB.findUser(login, password)) {
            return Optional.of(new User(usersDB.findUserId(login), login, password));
        } else {
            System.out.println("Не верный логин или пароль");
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> registerUser() {
        System.out.println("Введите логин");
        String login = UtilInput.getRequiredStringFromUser();
        if(getUserByLogin(login)) {
            System.out.println("Такой пользователь уже существует, придумайте другой логин");
            return Optional.empty();
        }

        System.out.println("Введите пароль");
        String password = UtilInput.getRequiredStringFromUser();
        usersDB.addUser(login, password);
        return Optional.of(new User(usersDB.findUserId(login), login, password));
    }

    @Override
    public boolean getUserByLogin(String login) {
        return usersDB.findUser(login);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
