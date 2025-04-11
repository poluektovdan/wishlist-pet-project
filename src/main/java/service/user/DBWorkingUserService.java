package service.user;

public interface DBWorkingUserService {
    boolean login();
    boolean registerUser();
    boolean getUserByLogin(String login);
}
