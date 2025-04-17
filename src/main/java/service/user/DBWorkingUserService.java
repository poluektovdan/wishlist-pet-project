package service.user;

import entity.User;

import java.util.Optional;

public interface DBWorkingUserService {
    Optional<User> login();
    Optional<User> registerUser();
    boolean getUserByLogin(String login);
}
