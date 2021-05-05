package FPA.View;

import FPA.Controlers.RegistrationController;

import javax.swing.*;
import java.awt.*;

public class RegistrationView {
    private JButton btnRegister;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private RegistrationController controller;
    private JButton btnModerator;
    private JButton btnCustomer;
    private static String password = "password";
    public RegistrationView() {
        controller = new RegistrationController(this);
        final JFrame registration_frame = new JFrame("Lol-App Registration");
        registration_frame.setResizable(false);
        registration_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registration_frame.setVisible(true);
        registration_frame.setSize(500, 500);

        JPanel registration_panel = new JPanel(new GridBagLayout());
        registration_frame.getContentPane().add(registration_panel,BorderLayout.NORTH);
        GridBagConstraints register_constraint = new GridBagConstraints();
        registration_frame.add(registration_panel);





    }
}
