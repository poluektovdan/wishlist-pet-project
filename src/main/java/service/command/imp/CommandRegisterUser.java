package service.command.imp;

import service.command.AbstractCommand;

public class CommandRegisterUser extends AbstractCommand {
    public static final CommandRegisterUser INSTANCE = new CommandRegisterUser();

    private CommandRegisterUser() {
        super("Регистрация");
    }

    @Override
    public boolean execute() {
        try {
            if (getUserServiceDB().registerUser().isPresent()) {
                System.out.println("Вы успешно зарегестрированы!");
                System.out.println("Войдите в личный кабинет");
                CommandLoginUser.INSTANCE.execute();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
