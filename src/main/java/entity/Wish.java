package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wish {
    //связывается с вишлистом по wishId
    @JsonProperty("wish_name")
    private String wish_name;
    @JsonProperty("wish_description")
    private String wish_description;
    @JsonProperty("wish_link")
    private String wish_link;
    @JsonProperty("priority")
    private WishPriority priority;

    public Wish(String wish_name) {
        this.wish_name = wish_name;
    }

    //описание и ссылка опциональны - добавить опции "добавить описание" и "добавить ссылку"
    public void setWishDescription(String wishDescription) {
        this.wish_description = wishDescription;
    }

    public void setWishLink(String wishLink) {
        this.wish_link = wishLink;
    }

    public String getWishName() {
        return wish_name;
    }

    public String getWishDescription() {
        return wish_description;
    }

    public String getWishLink() {
        return wish_link;
    }

    public WishPriority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Wish{" +
                ", wish_name='" + wish_name + '\'' +
                ", wish_description='" + wish_description + '\'' +
                ", wish_link='" + wish_link + '\'' +
                ", priority=" + priority +
                '}';
    }


    //что будет у виша?
    //добавить описание, добавить ссылку на виш, добавить приоритетность
    //редактировать виш - редактировать имя, описание, ссылку, приоритетность
}
