package entity;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    //связть с таблицей Users через id
    //сделать возможность создания нескольких вишлистов (на др, нг, годовщину). для этого использовать wishListName
    private final int userId;
    private final int wishlistId;
    private String wishlistName;
    private List<Wish> wishlist;

    public Wishlist(int userId, int wishlistId, String wishlistName) {
        this.userId = userId;
        this.wishlistId = wishlistId;
        this.wishlistName = wishlistName;
        this.wishlist = new ArrayList<>();
    }

    //что будет у вишлиста?
    //создать вишлист, посмотреть вишлист, добавить виш в вишлист, удалить виш из вишлиста
}
