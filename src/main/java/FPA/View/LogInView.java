package FPA.View;

import FPA.Controlers.LogInController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInView {

    public LogInView() {
        final LogInController log_in_controller = new LogInController(this);
        final JFrame log_in_frame = new JFrame("Lol-App");
        log_in_frame.setVisible(true);
        log_in_frame.setSize(500,500);
        JPanel log_in_panel = new JPanel(new GridBagLayout());
        log_in_frame.getContentPane().add(log_in_panel,BorderLayout.NORTH);
        final GridBagConstraints log_in_constraint = new GridBagConstraints();

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

                final JTextField txtuser = new JTextField(10);
                logInConstraint.gridx = 1;
                logInConstraint.gridy = 0;
                logInpanel.add(txtuser,logInConstraint);

                final JLabel pass = new JLabel("Password:");
                logInConstraint.gridx = 0;
                logInConstraint.gridy = 1;
                logInpanel.add(pass,logInConstraint);

                final JPasswordField password_field = new JPasswordField(10);
                logInConstraint.gridx = 1;
                logInConstraint.gridy = 1;
                logInpanel.add(password_field,logInConstraint);

                final JButton continue_with_log_in  = new JButton("Continue");
                logInConstraint.gridx = 1;
                logInConstraint.gridy = 3;
                logInpanel.add(continue_with_log_in ,logInConstraint);

                JButton back_to_log_in = new JButton("Back to log in");
                logInConstraint.gridx = 0;
                logInConstraint.gridy = 3;
                logInpanel.add(back_to_log_in,logInConstraint);

                back_to_log_in.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        logInframe.show(false);
                        log_in_frame.show(true);
                    }
                });

                continue_with_log_in.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if (log_in_controller.checkAcc(txtuser.getText(), new String(password_field.getPassword())))
                        {
                            if(log_in_controller.checkRole(txtuser.getText(),"Moderator"))
                            {
                                logInframe.show(false);
                                final JFrame frame_moderator = new JFrame();
                                frame_moderator.setVisible(true);
                                frame_moderator.setSize(500,500);
                                JPanel panel_moderator = new JPanel(new GridBagLayout());
                                frame_moderator.getContentPane().add(panel_moderator, BorderLayout.WEST);
                                GridBagConstraints c_moderator = new GridBagConstraints();

                            }
                            else
                            if(log_in_controller.checkRole(txtuser.getText(),"Customer"))
                            {
                                logInframe.show(false);
                                final JFrame customer_frame = new JFrame();
                                customer_frame.setVisible(true);
                                customer_frame.setSize(500,500);
                                JPanel customer_panel = new JPanel(new GridBagLayout());
                                customer_frame.getContentPane().add(customer_panel, BorderLayout.WEST);
                                GridBagConstraints customer_constratint = new GridBagConstraints();
                                JButton exemple = new JButton("Customer register");
                                customer_panel.add(exemple,customer_constratint);

                            }
                            else
                                JOptionPane.showMessageDialog(null, "Wrong Role", "Log In", JOptionPane.ERROR_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Account or password incorrect!", "Log In", JOptionPane.ERROR_MESSAGE);
                    }
                });

            }
        });
    }
}
