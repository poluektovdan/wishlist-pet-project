package entity;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    //связть с таблицей Users через id (сделано)
    //сделать возможность создания нескольких вишлистов (на др, нг, годовщину). для этого использовать wishListName (сделано)
    private int userId;
    private int wishlistId;
    private String wishlistName;
    private List<Wish> wishlist;

    public Wishlist(String wishlistName) {
        this.wishlistName = wishlistName;
        this.wishlist = new ArrayList<>();
    }

    public List<Wish> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wish> wishlist) {
        this.wishlist = wishlist;
    }

    //что будет у вишлиста?
    //создать вишлист, посмотреть вишлисты, удалить вишлист (сделано), добавить виш в вишлист, удалить виш из вишлиста
}
