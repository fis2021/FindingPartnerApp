package FPA.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInView {
    public LogInView() {
        final JFrame log_in_frame = new JFrame("Lol-App");
        log_in_frame.setVisible(true);
        log_in_frame.setSize(500,500);
        JPanel log_in_panel = new JPanel(new GridBagLayout());
        log_in_frame.getContentPane().add(log_in_panel,BorderLayout.NORTH);
        GridBagConstraints log_in_constraint = new GridBagConstraints();

        JButton log_in = new JButton("Log in");
        log_in_panel.add(log_in,log_in_constraint);

        JButton register = new JButton("Register");
        log_in_constraint.gridx = 1;
        log_in_panel.add(register,log_in_constraint);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                log_in_frame.show(false);
                RegistrationView view = new RegistrationView();
            }
        });

        log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                log_in_frame.show(false);
                final JFrame logInframe = new JFrame("Lol-App LogIn");
                logInframe.setVisible(true);
                logInframe.setSize(800,300);
                JPanel logInpanel = new JPanel(new GridBagLayout());
                logInframe.getContentPane().add(logInpanel,BorderLayout.NORTH);
                GridBagConstraints logInConstraint = new GridBagConstraints();

                JLabel username = new JLabel("Username:");
                logInConstraint.gridx = 0;
                logInConstraint.gridy = 0;
                logInConstraint.insets = new Insets(10,10,10,10);
                username.setBounds(20,30,10,10);
                logInpanel.add(username,logInConstraint);

                JTextField txtuser = new JTextField(10);
                logInConstraint.gridx = 1;
                logInConstraint.gridy = 0;
                logInpanel.add(txtuser,logInConstraint);

                JLabel pass = new JLabel("Password:");
                logInConstraint.gridx = 0;
                logInConstraint.gridy = 1;
                logInpanel.add(pass,logInConstraint);

                JPasswordField password_field = new JPasswordField(10);
                logInConstraint.gridx = 1;
                logInConstraint.gridy = 1;
                logInpanel.add(password_field,logInConstraint);

                final JButton next = new JButton("Continue");
                logInConstraint.gridx = 1;
                logInConstraint.gridy = 3;
                logInpanel.add(next,logInConstraint);

            }
        });
    }
}
