package service.command;

import service.user.imp.UserServiceDB;
import service.wish.imp.WishServiceDB;
import service.wishlist.imp.WishlistServiceDB;

public abstract class AbstractCommand implements Command {
    private String title;
    private UserServiceDB userServiceDB;
    private WishlistServiceDB wishlistServiceDB;
    private WishServiceDB wishServiceDB;

    protected AbstractCommand(String title) {
        this.title = title;
        this.userServiceDB = UserServiceDB.INSTANCE;
        this.wishlistServiceDB = WishlistServiceDB.INSTANCE;
        this.wishServiceDB = WishServiceDB.INSTANCE;
    }

    protected UserServiceDB getUserServiceDB() {
        return userServiceDB;
    }

    protected WishlistServiceDB getWishlistServiceDB() {
        return wishlistServiceDB;
    }

    protected WishServiceDB getWishServiceDB() {
        return wishServiceDB;
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
