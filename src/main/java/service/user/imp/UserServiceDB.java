package service.user.imp;

import db.UsersDB;
import entity.User;
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
            throw new UserNotFoundException("Не верный логин или пароль");
        }
    }

    @Override
    public Optional<User> registerUser() {
        System.out.println("Введите логин");
        String login = UtilInput.getRequiredStringFromUser();
        System.out.println("Введите пароль");
        String password = UtilInput.getRequiredStringFromUser();
        if(getUserByLogin(login)) {
            System.out.println("Такой пользователь уже существует");
            return Optional.empty();
        } else {
            usersDB.addUser(login, password);
            return Optional.of(new User(usersDB.findUserId(login), login, password));
        }
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

    public UsersDB getUsersDB() {
        return usersDB;
    }
}
