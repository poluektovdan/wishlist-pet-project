package entity;

import java.util.List;

public class Wishlist {
    //связть с таблицей Users через id
    private final int userId;
    private final int wishlistId;
    private List<Wish> wishlist;

    public Wishlist(int userId, int wishlistId, List<Wish> wishlist) {
        this.userId = userId;
        this.wishlistId = wishlistId;
        this.wishlist = wishlist;
    }
}
