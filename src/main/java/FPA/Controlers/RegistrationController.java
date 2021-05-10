package FPA.Controlers;

import FPA.Exceptions.AccAlreadyExistException;
import FPA.View.RegistrationView;
import FPA.Services.ModeratorSevices;

import javax.swing.*;

public class RegistrationController {
    private RegistrationView view;
    public JTextField username_test;
    public JPasswordField password_test;
    public JComboBox role;
    private ModeratorSevices ModeratorServices;

    public RegistrationController(RegistrationView view) {
        this.view = view;
    }


    public boolean checkAvailability(String username, String password, String role) {
        try {
            ModeratorServices.addUser(username, password, role);
            return true;
        } catch (AccAlreadyExistException e) {
            return false;
        }
    }
    public void handleRegisterAction() {
        try {
            ModeratorServices.addUser(username_test.getText(), password_test.getText(), (String) role.getSelectedItem());
        } catch (AccAlreadyExistException e) {
            System.out.println("Acc already exist!");
        }
    }


}
