package FPA.Controlers;

import FPA.Exceptions.UsernameOrPasswordIncorrectException;
import FPA.Exceptions.WrongRoleException;
import FPA.Services.ModeratorSevices;
import FPA.View.LogInView;

import java.io.IOException;

public class LogInController {
    private LogInView view;
    private ModeratorSevices ModeratorServices;

    public LogInController(LogInView view) {
        this.view = view;
    }

    public boolean checkAcc(String username, String password) {
        try {
            ModeratorServices.checkUser(username,password);
            return true;
        } catch (UsernameOrPasswordIncorrectException | IOException e) {
            return false;
        }
    }

    public boolean checkRole(String username, String role) {

        try {
            ModeratorServices.checkR(username,role);
            return true;
        }catch(WrongRoleException e)
        {
            return false;
        }

    }


}
