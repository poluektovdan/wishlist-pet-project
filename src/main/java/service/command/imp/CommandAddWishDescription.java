package service.command.imp;

import com.fasterxml.jackson.core.JsonProcessingException;
import exception.NoWishlistException;
import exception.WishlistNotFoundException;
import service.command.AbstractCommand;
import service.wish.ChooseWish;

import java.util.Optional;

public class CommandAddWishDescription extends AbstractCommand implements ChooseWish {
    public static final CommandAddWishDescription INSTANCE = new CommandAddWishDescription();

    private CommandAddWishDescription() {
        super("Добавить описание желанию");
    }


    @Override
    public boolean execute() throws JsonProcessingException {
        try{
            Optional<Integer> wishlistId = getWishlistServiceDB().findWishlistId(getUserServiceDB().getUserId());
            if(wishlistId.isPresent()) {
                String currentWishName = getWishes(getWishlistServiceDB(), wishlistId.get(), "описание");
                String wishDescription = getWishServiceDB().addDescription(wishlistId.get(), currentWishName);
                getWishlistServiceDB().updateDescriptionOfWish(wishlistId.get(), wishDescription, currentWishName);
            }
        } catch (NoWishlistException | WishlistNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
