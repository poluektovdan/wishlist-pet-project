package service.user;

import entity.User;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;

import java.util.Optional;

public interface DBWorkingUserService {
    Optional<User> login() throws UserNotFoundException;
    Optional<User> registerUser() throws UserAlreadyExistsException;
    boolean getUserByLogin(String login);
}
