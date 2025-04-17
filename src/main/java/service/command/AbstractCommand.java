package service.command;

import service.user.imp.UserServiceDB;
import service.wishlist.imp.WishlistServiceDB;

public abstract class AbstractCommand implements Command {
    private String title;
    private UserServiceDB userServiceDB;
    private WishlistServiceDB wishlistServiceDB;

    protected AbstractCommand(String title) {
        this.title = title;
        this.userServiceDB = UserServiceDB.INSTANCE;
        this.wishlistServiceDB = WishlistServiceDB.INSTANCE;
    }

    protected UserServiceDB getUserServiceDB() {
        return userServiceDB;
    }

    protected WishlistServiceDB getWishlistServiceDB() {
        return wishlistServiceDB;
    }

    @Override
    public String getCommandName() {
        return title;
    }

    @Override
    public String toString() {
        return "AbstractCommand{" +
                "title='" + title + '\'' +
                '}';
    }
}
