package entity;

public class Wish {
    private String wishName;
    private String wishDescription;
    private String wishLink;
    private WishPriority priority;

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
}
