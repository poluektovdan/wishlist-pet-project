package service.user;

import entity.User;

import java.util.Optional;

public interface SearchUserService {
    Optional<User> getUserByLogin(String login);
}
