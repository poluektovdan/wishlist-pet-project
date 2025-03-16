package service.user;

import entity.User;

import java.util.Optional;

public interface LoginUserService {
    Optional<User> login();
}
