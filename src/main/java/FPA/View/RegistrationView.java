package FPA.View;

import FPA.Controlers.RegistrationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationView {

    private RegistrationController controller;
    private static String password = "password";

    public RegistrationView() {
        controller = new RegistrationController(this);
        final JFrame registration_frame = new JFrame("Lol-App Registration");
        registration_frame.setResizable(false);
        registration_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registration_frame.setVisible(true);
        registration_frame.setSize(1000, 1000);

        JPanel registration_panel = new JPanel(new GridBagLayout());
        registration_frame.getContentPane().add(registration_panel,BorderLayout.NORTH);
        final GridBagConstraints register_constraint = new GridBagConstraints();
        registration_frame.add(registration_panel);

        JButton moderator_register_button = new JButton("Moderator Register");
        moderator_register_button.setBounds(170,100,300,50);
        register_constraint.gridx = 0;
        register_constraint.gridy = 1;
        registration_panel.add(moderator_register_button,register_constraint);

        JButton customer_register_button = new JButton("Customer Register");
        customer_register_button.setBounds(170,100,300,50);
        register_constraint.gridx = 1;
        register_constraint.gridy = 1;
        registration_panel.add(customer_register_button,register_constraint);

        customer_register_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                registration_frame.show(false);
                final JFrame customer_registration_frame = new JFrame();
                customer_registration_frame.setVisible(true);
                customer_registration_frame.setSize(600,400);
                JPanel customer_registration_panel = new JPanel(new GridBagLayout());
                customer_registration_frame.getContentPane().add(customer_registration_panel,BorderLayout.NORTH);
                GridBagConstraints customer_registration_constraint = new GridBagConstraints();
                customer_registration_frame.add(customer_registration_panel);

                JLabel lblUsername = new JLabel("Username:");
                lblUsername.setBounds(10, 10, 120, 25);
                customer_registration_constraint.gridx = 0;
                customer_registration_constraint.gridy = 0;
                customer_registration_constraint.insets = new Insets(10,10,1,10);
                customer_registration_panel.add(lblUsername,customer_registration_constraint);

                final JTextField txtUsername = new JTextField(10);
                customer_registration_constraint.gridx = 1;
                customer_registration_constraint.gridy = 0;
                customer_registration_panel.add(txtUsername,customer_registration_constraint);

                JLabel lblPassword = new JLabel("Password:");
                lblPassword.setBounds(10, 40, 120, 25);
                customer_registration_constraint.gridx = 0;
                customer_registration_constraint.gridy = 1;
                customer_registration_panel.add(lblPassword,customer_registration_constraint);

                final JPasswordField txtPassword = new JPasswordField(10);
                customer_registration_constraint.gridx = 1;
                customer_registration_constraint.gridy = 1;
                customer_registration_panel.add(txtPassword,customer_registration_constraint);

                JButton btnRegister = new JButton("Register");
                btnRegister.setBounds(175, 110, 100, 40);
                customer_registration_constraint.gridx = 3;
                customer_registration_constraint.gridy = 4;

                JButton back_to_choose_register = new JButton("Back");
                customer_registration_constraint.gridx = 1;
                customer_registration_constraint.gridy = 4;
                customer_registration_panel.add(back_to_choose_register,customer_registration_constraint);

                back_to_choose_register.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registration_frame.show(true);
                        customer_registration_frame.show(false);
                    }
                });

                btnRegister.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if (controller.checkAvailability(txtUsername.getText(), new String(txtPassword.getPassword()), "Customer")) {
                            JOptionPane.showMessageDialog(null, "Account create with succes", "Adding user", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Account already exist", "Adding user", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                customer_registration_constraint.gridx = 2;
                customer_registration_panel.add(btnRegister,customer_registration_constraint);

            }
        });

        JButton back_to_log_in = new JButton("Back to log in");
        back_to_log_in.setBounds(170,100,300,50);
        register_constraint.gridx = 0;
        register_constraint.gridy = 2;
        registration_panel.add(back_to_log_in,register_constraint);

        back_to_log_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                registration_frame.show(false);
                LogInView view = new LogInView();
            }
        });

        moderator_register_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                registration_frame.show(false);
                final JFrame introduce_password_frame = new JFrame();
                introduce_password_frame.setVisible(true);
                introduce_password_frame.setSize(600,400);
                JPanel introduce_pass_panel = new JPanel(new GridBagLayout());
                introduce_password_frame.getContentPane().add(introduce_pass_panel,BorderLayout.NORTH);
                GridBagConstraints introduce_pass_constraint = new GridBagConstraints();

                JLabel message = new JLabel("After you introduce the password please press enter and after that continue!");
                message.setBounds(170,100,300,50);
                introduce_pass_constraint.gridx = 0;
                introduce_pass_constraint.gridy = 2;
                introduce_pass_panel.add(message,introduce_pass_constraint);

                JLabel label = new JLabel("Password:");
                JPasswordField passtext = new JPasswordField( 10);
                
                introduce_pass_constraint.gridx = 0;
                introduce_pass_constraint.gridy = 0;
                introduce_pass_panel.add(label,introduce_pass_constraint);
                introduce_pass_constraint.gridx = 1;
                introduce_pass_constraint.gridy = 0;
                introduce_pass_panel.add(passtext);

                final JButton continue_with_registration = new JButton("Continue");
                introduce_pass_constraint.gridx = 1;
                introduce_pass_constraint.gridy = 1;
                introduce_pass_panel.add(continue_with_registration,introduce_pass_constraint);
                
                JButton back_to_first_registration_frame = new JButton("Back");
                introduce_pass_constraint.gridx = 1;
                introduce_pass_constraint.gridy = 2;
                back_to_first_registration_frame.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        introduce_password_frame.show(false);
                        registration_frame.show(true);
                    }
                });
                introduce_pass_panel.add(back_to_first_registration_frame,introduce_pass_constraint);

                passtext.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        JPasswordField input = (JPasswordField) actionEvent.getSource(); 
                        char[] input_password = input.getPassword();
                        String actual_password = new String(input_password);
                        if(actual_password.equals(password)) {
                            continue_with_registration.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    introduce_password_frame.show(false);
                                    final JFrame create_acc_frame = new JFrame();
                                    create_acc_frame.setVisible(true);
                                    create_acc_frame.setSize(400,300);
                                    JPanel moderator_acc_panel = new JPanel(new GridBagLayout());
                                    create_acc_frame.getContentPane().add(moderator_acc_panel,BorderLayout.NORTH);
                                    GridBagConstraints acc_creation_constraint = new GridBagConstraints();

                                    JLabel lblUsername = new JLabel("Username:");
                                    lblUsername.setBounds(10, 10, 120, 25);
                                    acc_creation_constraint.gridx = 0;
                                    acc_creation_constraint.gridy = 0;
                                    acc_creation_constraint.insets = new Insets(10,10,1,10);
                                    moderator_acc_panel.add(lblUsername,acc_creation_constraint);

                                    final JTextField txtUsername = new JTextField(10);
                                    acc_creation_constraint.gridx = 1;
                                    acc_creation_constraint.gridy = 0;
                                    moderator_acc_panel.add(txtUsername,acc_creation_constraint);

                                    JLabel lblPassword = new JLabel("Password:");
                                    lblPassword.setBounds(10, 40, 120, 25);
                                    acc_creation_constraint.gridx = 0;
                                    acc_creation_constraint.gridy = 1;
                                    moderator_acc_panel.add(lblPassword,acc_creation_constraint);

                                    final JPasswordField txtPassword = new JPasswordField(10);
                                    acc_creation_constraint.gridx = 1;
                                    acc_creation_constraint.gridy = 1;
                                    moderator_acc_panel.add(txtPassword,acc_creation_constraint);

                                    JButton btnRegister = new JButton("Register");
                                    btnRegister.setBounds(175, 110, 100, 40);
                                    acc_creation_constraint.gridx = 3;
                                    acc_creation_constraint.gridy = 4;
                                    btnRegister.addActionListener(new ActionListener(){
                                        @Override
                                        public void actionPerformed(ActionEvent actionEvent) {
                                            if (controller.checkAvailability(txtUsername.getText(), new String(txtPassword.getPassword()), "Moderator")) {
                                                JOptionPane.showMessageDialog(null, "Account create with succes", "Adding user", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Account already exist", "Adding user", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    });
                                    moderator_acc_panel.add(btnRegister,acc_creation_constraint);

                                    JButton back_to_create_menu = new JButton("Back to create menu");
                                    back_to_create_menu.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent actionEvent) {
                                            create_acc_frame.show(false);
                                            registration_frame.show(true);
                                        }
                                    });
                                    acc_creation_constraint.gridx = 2;

                                    moderator_acc_panel.add(back_to_create_menu,acc_creation_constraint);
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}
