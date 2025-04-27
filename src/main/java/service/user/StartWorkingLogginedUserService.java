package service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import exception.NoWishesInWishlistException;

public interface StartWorkingLogginedUserService {
    void startWorkWithUser(String username) throws JsonProcessingException, NoWishesInWishlistException;
}
