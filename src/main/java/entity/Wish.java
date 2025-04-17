package entity;

public class Wish {
    //связывается с вишлистом по wishId
    private int wishId;
    private String wishName;
    private String wishDescription;
    private String wishLink;
    private WishPriority priority;
    private int wishListId;

    public Wish(String wishName) {
        this.wishName = wishName;
    }

    //описание и ссылка опциональны - добавить опции "добавить описание" и "добавить ссылку"
    public void setWishDescription(String wishDescription) {
        this.wishDescription = wishDescription;
    }

    public void setWishLink(String wishLink) {
        this.wishLink = wishLink;
    }

    public String getWishName() {
        return wishName;
    }

    public String getWishDescription() {
        return wishDescription;
    }

    public String getWishLink() {
        return wishLink;
    }

    public WishPriority getPriority() {
        return priority;
    }


    //что будет у виша?
    //добавить описание, добавить ссылку на виш, добавить приоритетность
    //редактировать виш - редактировать имя, описание, ссылку, приоритетность
}
