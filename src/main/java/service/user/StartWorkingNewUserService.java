package service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import exception.NoWishesInWishlistException;

public interface StartWorkingNewUserService {
    void startWorkWithUser() throws JsonProcessingException, NoWishesInWishlistException;
}
