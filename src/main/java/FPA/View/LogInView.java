package FPA.View;

import FPA.Controlers.AnnoucementController;
import FPA.Controlers.LogInController;
import FPA.Controlers.ParticipantController;
import FPA.Controlers.TournamentController;
import FPA.Customer.customer;
import FPA.Services.*;
import FPA.Tournament.Tournament;
import FPA.Tournament.TournamentDetails;
import FPA.Annoucements.annoucements;
import org.dizitart.no2.objects.ObjectRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LogInView extends JFrame {
    private LogInController controller;
    private AnnoucementController annoucementController;
    private TournamentController tournyController;
    private ParticipantController participantController;

    private static ObjectRepository<Tournament> TournyRepository;
    private static ObjectRepository<TournamentDetails> TournyDetailsRepository;
    private static ObjectRepository<customer> CustomerRepository;
    private static ObjectRepository<annoucements> AnnouceRepository;



    public LogInView() {
        controller = new LogInController(this);
        annoucementController = new AnnoucementController(this);
        tournyController = new TournamentController(this);
        participantController = new ParticipantController(this);
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

                final JLabel username = new JLabel("Username:");
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
                                final JPanel panel_moderator = new JPanel(new GridBagLayout());
                                frame_moderator.getContentPane().add(panel_moderator, BorderLayout.WEST);
                                GridBagConstraints c_moderator = new GridBagConstraints();

                                c_moderator.gridx = 0;
                                c_moderator.gridy = 0;
                                JButton accounts_created = new JButton("Accounts created");
                                panel_moderator.add(accounts_created,c_moderator);

                                accounts_created.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame_moderator.show(false);

                                        final JFrame frame_players = new JFrame("Accounts created");
                                        frame_players.setVisible(true);
                                        frame_players.setSize(500,500);
                                        JButton back_to_moderator = new JButton("Back");
                                        JPanel panel_accounts = new JPanel(new GridBagLayout());
                                        frame_players.getContentPane().add(panel_accounts, BorderLayout.NORTH);
                                        GridBagConstraints acc_created_constraint = new GridBagConstraints();

                                        int numar = controller.getNumberOfPlayers();
                                        String acc_created = String.valueOf(numar);
                                        acc_created_constraint.gridx = 0;
                                        acc_created_constraint.gridy = 0;
                                        JButton accounts = new JButton(acc_created);
                                        panel_accounts.add(accounts,acc_created_constraint);

                                       acc_created_constraint.gridx = 0;
                                       acc_created_constraint.gridy = 1;
                                        panel_accounts.add(back_to_moderator,acc_created_constraint);
                                        back_to_moderator.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                frame_players.show(false);
                                                frame_moderator.show(true);
                                            }
                                        });


                                    }
                                });

                                JButton annouce = new JButton("Annouce");
                                c_moderator.gridx = 1;
                                panel_moderator.add(annouce,c_moderator);

                                annouce.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame_moderator.show(false);
                                        final JFrame annouce_frame = new JFrame();
                                        annouce_frame.setVisible(true);
                                        annouce_frame.setSize(500,500);
                                        JPanel annouce_panel = new JPanel(new GridBagLayout());
                                        annouce_frame.add(annouce_panel);
                                        GridBagConstraints annouce_constraint = new GridBagConstraints();
                                        annouce_constraint.gridx = 0;
                                        annouce_constraint.gridy = 0;
                                        JButton put_annouce = new JButton("Put annouce");
                                        annouce_panel.add(put_annouce,annouce_constraint);

                                        put_annouce.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                annouce_frame.show(false);
                                                final JFrame put_annouce_frame = new JFrame();
                                                put_annouce_frame.setVisible(true);
                                                put_annouce_frame.setSize(500,500);
                                                JPanel put_annouce_panel = new JPanel(new GridBagLayout());
                                                put_annouce_frame.add(put_annouce_panel);
                                                GridBagConstraints put_annouce_constraint = new GridBagConstraints();
                                                put_annouce_constraint.gridx = 0;
                                                put_annouce_constraint.gridy = 0;
                                                JLabel annouce = new JLabel("Annocement:");
                                                put_annouce_panel.add(annouce,put_annouce_constraint);

                                                final JTextField text_field_annouce = new JTextField(10);
                                                put_annouce_constraint.gridx = 1;
                                                put_annouce_panel.add(text_field_annouce,put_annouce_constraint);

                                                put_annouce_constraint.gridx = 1;
                                                put_annouce_constraint.gridy = 1;
                                                JButton add_annouce = new JButton("Add");
                                                put_annouce_panel.add(add_annouce,put_annouce_constraint);

                                                JButton back = new JButton("Back");
                                                put_annouce_constraint.gridx = 0;
                                                put_annouce_panel.add(back,put_annouce_constraint);

                                                add_annouce.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        String annouce_text = new String(text_field_annouce.getText());
                                                        annoucementController.addAnnouce(annouce_text);
                                                    }
                                                });
                                                back.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        annouce_frame.show(true);
                                                        put_annouce_frame.show(false);
                                                    }
                                                });





                                            }
                                        });

                                    }
                                });

                                JButton tournaments = new JButton("Tournaments");
                                c_moderator.gridx = 2;
                                panel_moderator.add(tournaments,c_moderator);

                                tournaments.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        frame_moderator.show(false);
                                        final JFrame add_delete_see_frame = new JFrame("Tournament");
                                        add_delete_see_frame.setVisible(true);
                                        add_delete_see_frame.setSize(500,500);
                                        JButton back = new JButton("Back");
                                        JButton adauga = new JButton("Add tournament");
                                        final JButton delete = new JButton("Delete tournament");
                                        final JButton see_tourny = new JButton("See tournaments");
                                        JPanel add_delete_see_panel = new JPanel(new GridBagLayout());
                                        add_delete_see_frame.getContentPane().add(add_delete_see_panel, BorderLayout.NORTH);
                                        GridBagConstraints add_delete_see_constraint = new GridBagConstraints();
                                        add_delete_see_constraint.gridx = 0;
                                        add_delete_see_constraint.gridy = 0;
                                        add_delete_see_constraint.insets = new Insets(10,10,10,10);
                                        add_delete_see_panel.add(adauga,add_delete_see_constraint);
                                        add_delete_see_constraint.gridx = 1;
                                        add_delete_see_panel.add(delete,add_delete_see_constraint);
                                        add_delete_see_constraint.gridx = 2;
                                        add_delete_see_panel.add(see_tourny,add_delete_see_constraint);
                                        add_delete_see_constraint.gridx = 1;
                                        add_delete_see_constraint.gridy = 1;
                                        add_delete_see_panel.add(back,add_delete_see_constraint);
                                        back.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                add_delete_see_frame.show(false);
                                                frame_moderator.show(true);
                                            }
                                        });
                                        adauga.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent actionEvent) {
                                                add_delete_see_frame.show(false);
                                                final JFrame frame_add = new JFrame();
                                                frame_add.setSize(300,300);
                                                frame_add.setVisible(true);
                                                JPanel panel_add = new JPanel(new GridBagLayout());
                                                frame_add.getContentPane().add(panel_add, BorderLayout.NORTH);
                                                GridBagConstraints c_add = new GridBagConstraints();
                                                c_add.gridx = 0;
                                                c_add.gridy = 0;
                                                c_add.insets = new Insets(10,10,10,10);
                                                final JLabel name_label = new JLabel("Name:");
                                                JLabel date_label = new JLabel("Date:");
                                                final JTextField name_field = new JTextField(10);
                                                final JTextField date_field = new JTextField(10);
                                                panel_add.add(name_label,c_add);
                                                c_add.gridx = 1;
                                                c_add.gridy = 0;
                                                panel_add.add(name_field,c_add);
                                                c_add.gridx = 0;
                                                c_add.gridy = 1;
                                                panel_add.add(date_label,c_add);
                                                c_add.gridx = 1;
                                                c_add.gridy = 1;
                                                panel_add.add(date_field,c_add);
                                                JButton adaugare_tournament = new JButton("Add");
                                                c_add.gridx = 1;
                                                c_add.gridy = 2;
                                                panel_add.add(adaugare_tournament,c_add);
                                                JButton back_tournament = new JButton("Back");
                                                c_add.gridx = 0;
                                                c_add.gridy = 2;
                                                panel_add.add(back_tournament,c_add);
                                                back_tournament.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                        frame_add.show(false);
                                                        add_delete_see_frame.show(true);
                                                    }
                                                });

                                                adaugare_tournament.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                        if(tournyController.AddTournament(name_field.getText(),date_field.getText()))
                                                        {
                                                            JOptionPane.showMessageDialog(null, "Tournament add with succes!", "Message", JOptionPane.INFORMATION_MESSAGE);
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Add tournament fail", "Message", JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                });

                                           }
                                        });

                                                delete.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                        add_delete_see_frame.show(false);
                                                        final JFrame frame_delete = new JFrame();
                                                        frame_delete.setVisible(true);
                                                        frame_delete.setSize(500,500);
                                                        JPanel panel_delete = new JPanel(new GridBagLayout());
                                                        frame_delete.getContentPane().add(panel_delete, BorderLayout.NORTH);
                                                        GridBagConstraints c_delete = new GridBagConstraints();
                                                        c_delete.gridx = 0;
                                                        c_delete.gridy = 0;
                                                        final JLabel name_tournament = new JLabel("Tournament name:");
                                                        panel_delete.add(name_tournament,c_delete);
                                                        c_delete.gridx = 1;
                                                        final JTextField txt_tournament = new JTextField(10);
                                                        panel_delete.add(txt_tournament,c_delete);
                                                        JButton back_delete = new JButton("Back");
                                                        c_delete.gridx = 0;
                                                        c_delete.gridy = 1;
                                                        panel_delete.add(back_delete,c_delete);
                                                        JButton delete = new JButton("Delete");
                                                        c_delete.gridx = 1;
                                                        panel_delete.add(delete,c_delete);
                                                        back_delete.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                frame_delete.show(false);
                                                                add_delete_see_frame.show(true);
                                                            }
                                                        });

                                                        delete.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                TournyRepository = TournamentServices.getTournyRepository();
                                                                for(Tournament t : TournyRepository.find())
                                                                {
                                                                    if(Objects.equals(t.getName(),txt_tournament.getText()))
                                                                    {
                                                                        if(TournamentServices.remove(t))
                                                                        {
                                                                                JOptionPane.showMessageDialog(null, "You delete the tournament with succes", "Delete", JOptionPane.INFORMATION_MESSAGE);
                                                                        }
                                                                    }
                                                                }

                                                            }
                                                        });
                                                    }
                                                });

                                                see_tourny.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                        add_delete_see_frame.show(false);


                                                        final JFrame see_tourny_frame= new JFrame("List");
                                                        see_tourny_frame.setVisible(true);
                                                        see_tourny_frame.setSize(500,500);
                                                        JPanel see_tourny_panel = new JPanel(new GridBagLayout());
                                                        see_tourny_frame.getContentPane().add(see_tourny_panel, BorderLayout.WEST);
                                                        GridBagConstraints see_tourny_constraint = new GridBagConstraints();
                                                        see_tourny_frame.add(see_tourny_panel);
                                                        see_tourny_constraint.gridx = 0;
                                                        see_tourny_constraint.gridy = 0;
                                                        see_tourny_constraint.insets = new Insets(10,10,10,10);

                                                        TournyRepository = TournamentServices.getTournyRepository();
                                                        for(Tournament t : TournyRepository.find())
                                                        {
                                                             see_tourny_constraint.gridx = 0;
                                                             JLabel name = new JLabel(t.getName());
                                                             see_tourny_panel.add(name,see_tourny_constraint);
                                                            see_tourny_constraint.gridx = 1;
                                                            JLabel date = new JLabel(t.getDate());
                                                            see_tourny_panel.add(date,see_tourny_constraint);
                                                            see_tourny_constraint.gridy++;
                                                        }
                                                        JButton back_show = new JButton("Back");
                                                        see_tourny_constraint.gridx = 0;
                                                        see_tourny_panel.add(back_show,see_tourny_constraint);
                                                        JButton see_players = new JButton("See participants");
                                                        see_tourny_constraint.gridx = 1;
                                                        see_tourny_panel.add(see_players,see_tourny_constraint);
                                                        JButton details = new JButton("Details");
                                                        see_tourny_constraint.gridx = 2;
                                                        see_tourny_panel.add(details,see_tourny_constraint);

                                                        back_show.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                add_delete_see_frame.show(true);
                                                                see_tourny_frame.show(false);
                                                            }
                                                        });

                                                        see_players.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                               see_tourny_frame.show(false);
                                                                final JFrame frame_see_players = new JFrame();
                                                                frame_see_players.setVisible(true);
                                                                frame_see_players.setSize(500,500);
                                                                JPanel pan_see_players = new JPanel(new GridBagLayout());
                                                                frame_see_players.getContentPane().add(pan_see_players, BorderLayout.NORTH);
                                                                GridBagConstraints c_show_players = new GridBagConstraints();
                                                                JLabel name_tour = new JLabel("Tournament name:");
                                                                c_show_players.gridx = 0;
                                                                c_show_players.gridy = 0;
                                                                pan_see_players.add(name_tour,c_show_players);
                                                                final JTextField txt_tournament = new JTextField(10);
                                                                c_show_players.gridx = 1;
                                                                pan_see_players.add(txt_tournament,c_show_players);
                                                                JButton list = new JButton("List");
                                                                JButton back_see_players = new JButton("Back");
                                                                c_show_players.gridx = 0;
                                                                c_show_players.gridy = 1;
                                                                pan_see_players.add(back_see_players,c_show_players);
                                                                c_show_players.gridx = 1;
                                                                pan_see_players.add(list,c_show_players);

                                                                back_see_players.addActionListener(new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                                        see_tourny_frame.show(true);
                                                                        frame_see_players.show(false);
                                                                    }
                                                                });
                                                            }
                                                        });

                                                        details.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                               see_tourny_frame.show(false);
                                                                final JFrame frame_details = new JFrame();
                                                                frame_details.setSize(500,500);
                                                                frame_details.setVisible(true);
                                                                JPanel panel_details = new JPanel(new GridBagLayout());
                                                                frame_details.add(panel_details);
                                                                final GridBagConstraints c_details = new GridBagConstraints();
                                                                c_details.gridx = 0;
                                                                c_details.gridy = 0;
                                                                c_details.insets = new Insets(10,10,10,10);
                                                                JButton back_details = new JButton("Back");
                                                                panel_details.add(back_details,c_details);
                                                                JButton add_details = new JButton("Add details");
                                                                c_details.gridx = 1;
                                                                panel_details.add(add_details,c_details);
                                                                JButton see_details = new JButton("See details");
                                                                c_details.gridx = 2;
                                                                panel_details.add(see_details,c_details);
                                                                back_details.addActionListener(new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                                        frame_details.show(false);
                                                                        see_tourny_frame.show(true);
                                                                    }
                                                                });

                                                                add_details.addActionListener(new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                                        frame_details.show(false);
                                                                        final JFrame frame_add_details = new JFrame();
                                                                        frame_add_details.setVisible(true);
                                                                        frame_add_details.setSize(500,500);
                                                                        JPanel panel_add_details = new JPanel(new GridBagLayout());
                                                                        GridBagConstraints c_add_details = new GridBagConstraints();
                                                                        frame_add_details.add(panel_add_details);
                                                                        c_add_details.gridx = 0;
                                                                        c_add_details.gridy = 0;
                                                                        c_add_details.insets = new Insets(10,10,10,10);
                                                                        JLabel name_tournament = new JLabel("Tournament name:");
                                                                        panel_add_details.add(name_tournament,c_add_details);
                                                                        c_add_details.gridx = 1;
                                                                        final JTextField name_tournament_txt = new JTextField(10);
                                                                        panel_add_details.add(name_tournament_txt,c_add_details);
                                                                        c_add_details.gridx = 0;
                                                                        c_add_details.gridy = 1;
                                                                        JLabel details_tourn = new JLabel("Details:");
                                                                        panel_add_details.add(details_tourn,c_add_details);
                                                                        final JTextField details_tour_txt = new JTextField(10);
                                                                        c_add_details.gridx = 1;
                                                                        panel_add_details.add(details_tour_txt,c_add_details);
                                                                        JButton back_add_details = new JButton("Back");
                                                                        c_add_details.gridx = 0;
                                                                        c_add_details.gridy = 2;
                                                                        panel_add_details.add(back_add_details,c_add_details);
                                                                        c_add_details.gridx = 1;
                                                                        JButton adauga = new JButton("Add");
                                                                        panel_add_details.add(adauga,c_add_details);
                                                                        back_add_details.addActionListener(new ActionListener() {
                                                                            @Override
                                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                                frame_details.show(true);
                                                                                frame_add_details.show(false);
                                                                            }
                                                                        });

                                                                        adauga.addActionListener(new ActionListener() {
                                                                            @Override
                                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                                TournyRepository = TournamentServices.getTournyRepository();
                                                                                for(Tournament t:TournyRepository.find())
                                                                                {
                                                                                    if(Objects.equals(t.getName(),name_tournament_txt.getText()))
                                                                                    {
                                                                                        if(tournyController.AddDetails(t.getName(),details_tour_txt.getText()))
                                                                                        {
                                                                                            JOptionPane.showMessageDialog(null, "Details added with succes", "Details", JOptionPane.INFORMATION_MESSAGE);

                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        });

                                                                    }
                                                                });


                                                                see_details.addActionListener(new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent actionEvent) {
                                                                        frame_details.show(false);
                                                                        final JFrame frame_button_see = new JFrame();
                                                                        frame_button_see.setVisible(true);
                                                                        frame_button_see.setSize(500,500);
                                                                        JPanel panel_button_see = new JPanel(new GridBagLayout());
                                                                        frame_button_see.add(panel_button_see);
                                                                        GridBagConstraints c_button_see = new GridBagConstraints();
                                                                        c_button_see.gridx = 0;
                                                                        c_button_see.gridy = 0;
                                                                        TournyDetailsRepository = Tournament_detailsServices.getTourny_DetailsRepository();
                                                                        for(TournamentDetails t:TournyDetailsRepository.find())
                                                                        {

                                                                            c_button_see.gridx = 0;
                                                                            JLabel name = new JLabel(t.getName());
                                                                            panel_button_see.add(name,c_button_see);
                                                                            c_button_see.gridx = 1;
                                                                            JLabel date = new JLabel(t.getDetails());
                                                                            panel_button_see.add(date,c_button_see);
                                                                            c_button_see.gridy++;
                                                                        }
                                                                        c_button_see.insets = new Insets(10,10,10,10);
                                                                        JButton back_see_button = new JButton("Back");
                                                                        panel_button_see.add(back_see_button,c_button_see);
                                                                        back_see_button.addActionListener(new ActionListener() {
                                                                            @Override
                                                                            public void actionPerformed(ActionEvent actionEvent) {
                                                                                frame_button_see.show(false);
                                                                                frame_details.show(true);
                                                                            }
                                                                        });
                                                                    }
                                                                });

                                                            }
                                                        });
                                                    }
                                                });










                                    }
                                });
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
                                GridBagConstraints customer_constraint = new GridBagConstraints();

                                String[] items = {"Top", "Jungle", "Mid", "Adc", "Support"};
                                JLabel choose_role = new JLabel("Choose your role!");
                                final JComboBox<String> c = new JComboBox<>(items);
                                String[] items_rank = {"Iron","Bronze","Silver","Gold","Platinum","Diamond","Master","Challenger"};
                                final JComboBox<String> c_rank = new JComboBox<>(items_rank);
                                customer_frame.add(customer_panel);
                                customer_constraint.gridx = 0;
                                customer_constraint.gridy = 0;
                                customer_panel.add(choose_role,customer_constraint);
                                customer_constraint.gridx = 0;
                                customer_constraint.gridy = 1;
                                customer_constraint.insets = new Insets(10, 10, 10, 10);
                                customer_panel.add(c, customer_constraint);

                                customer_constraint.gridx = 1;
                                customer_constraint.gridy = 1;
                                customer_panel.add(c_rank,customer_constraint);
                                JLabel choose_rank = new JLabel("Choose your rank!");
                                customer_constraint.gridx = 1;
                                customer_constraint.gridy = 0;
                                customer_panel.add(choose_rank,customer_constraint);

                                JLabel choose_partner = new JLabel("Choose parnter role!");
                                customer_constraint.gridx = 2;
                                customer_constraint.gridy = 0;
                                customer_panel.add(choose_partner,customer_constraint);

                                String[] items_partner = {"Top","Jungle","Mid","Adc","Support"};
                                final JComboBox<String> c_partner = new JComboBox<>(items_partner);
                                customer_constraint.gridx = 2;
                                customer_constraint.gridy = 1;
                                customer_panel.add(c_partner,customer_constraint);

                                JButton finish = new JButton("Finish");
                                customer_constraint.gridx = 3;
                                customer_constraint.gridy = 2;
                                customer_panel.add(finish,customer_constraint);

                                finish.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {

                                        customer_frame.show(false);
                                        final JFrame show_partner_frame = new JFrame("List");
                                        show_partner_frame.setVisible(true);
                                        show_partner_frame.setSize(500,500);
                                        JPanel pan_show = new JPanel(new GridBagLayout());
                                        show_partner_frame.getContentPane().add(pan_show, BorderLayout.WEST);
                                        GridBagConstraints c_show = new GridBagConstraints();
                                        show_partner_frame.add(pan_show);
                                        c_show.gridx = 0;
                                        c_show.gridy = 0;
                                        c_show.insets = new Insets(10,10,10,10);
                                        String name_customer = txtuser.getText();
                                        controller.add_customer(name_customer,String.valueOf(c.getSelectedItem()),String.valueOf(c_rank.getSelectedItem()),String.valueOf(c_partner.getSelectedItem()));

                                        CustomerRepository = CustomerServices.getCustomerRepository();
                                        for(customer c:CustomerRepository.find())
                                        {
                                            if(Objects.equals(String.valueOf(c_partner.getSelectedItem()),c.getCustomer_role()))
                                            {
                                                c_show.gridx = 0;
                                                JLabel name = new JLabel(c.getUsername());
                                                pan_show.add(name,c_show);
                                                JLabel rank = new JLabel(c.getRank());
                                                c_show.gridx=1;
                                                pan_show.add(rank,c_show);
                                                c_show.gridy++;
                                            }
                                        }

                                        c_show.gridx = 0;
                                        c_show.gridy++;
                                        JButton tourny = new JButton("Tournaments");
                                        pan_show.add(tourny,c_show);
                                        c_show.gridx = 1;
                                        JButton see_annoucements = new JButton("See annoucements");
                                        pan_show.add(see_annoucements,c_show);
                                        c_show.gridx = 2;
                                        JButton message = new JButton("Message");
                                        pan_show.add(message,c_show);
                                        
                                        see_annoucements.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                show_partner_frame.show(false);
                                                final JFrame show_annouce = new JFrame("List");
                                                show_annouce.setVisible(true);
                                                show_annouce.setSize(500,500);
                                                JPanel pan_show_annouce = new JPanel(new GridBagLayout());
                                                GridBagConstraints c_show_annouce = new GridBagConstraints();
                                                show_annouce.add(pan_show_annouce);
                                                c_show_annouce.gridx = 0;
                                                c_show_annouce.gridy = 0;
                                                AnnouceRepository = AnnoucementServices.getAnnouceRepository();
                                                for(annoucements ann:AnnouceRepository.find())
                                                {
                                                    c_show_annouce.gridx = 0;
                                                    JLabel annouce_name = new JLabel(ann.getAnnouce());
                                                    pan_show_annouce.add(annouce_name,c_show_annouce);
                                                    c_show_annouce.gridy++;
                                                }

                                                JButton back_to_show_partner = new JButton("Back");
                                                pan_show_annouce.add(back_to_show_partner,c_show_annouce);
                                                back_to_show_partner.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        show_partner_frame.show(true);
                                                        show_annouce.show(false);
                                                    }
                                                });

                                            }
                                        });

                                        tourny.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                show_partner_frame.show(false);
                                                final JFrame tourny_shows_customer = new JFrame("List");
                                                tourny_shows_customer.setVisible(true);
                                                tourny_shows_customer.setSize(500,500);
                                                JPanel pan_show_tourny = new JPanel(new GridBagLayout());
                                                GridBagConstraints c_show_tourny = new GridBagConstraints();
                                                tourny_shows_customer.add(pan_show_tourny);
                                                c_show_tourny.gridx = 0;
                                                c_show_tourny.gridy = 0;
                                                TournyDetailsRepository = Tournament_detailsServices.getTourny_DetailsRepository();
                                                for(TournamentDetails t:TournyDetailsRepository.find())
                                                {
                                                    c_show_tourny.gridx = 0;
                                                    JLabel name = new JLabel(t.getName());
                                                    pan_show_tourny.add(name,c_show_tourny);
                                                    c_show_tourny.gridx = 1;
                                                    JLabel date = new JLabel(t.getDetails());
                                                    pan_show_tourny.add(date,c_show_tourny);
                                                    c_show_tourny.gridy++;
                                                }
                                                JButton details_tournys = new JButton("Details");
                                                pan_show_tourny.add(details_tournys,c_show_tourny);
                                                c_show_tourny.gridx++;
                                                final JButton participate = new JButton("Participate");
                                                pan_show_tourny.add(participate,c_show_tourny);
                                                c_show_tourny.gridx = 0;
                                                c_show_tourny.gridy++;
                                                JButton back_see_button = new JButton("Back");
                                                pan_show_tourny.add(back_see_button,c_show_tourny);
                                                back_see_button.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        show_partner_frame.show(true);
                                                        tourny_shows_customer.show(false);
                                                    }
                                                });

                                                details_tournys.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        tourny_shows_customer.show(false);
                                                        final JFrame details_tournys_frame = new JFrame("List");
                                                        details_tournys_frame.setVisible(true);
                                                        details_tournys_frame.setSize(500,500);
                                                        JPanel pan_details_tournys = new JPanel(new GridBagLayout());
                                                        GridBagConstraints c_details_tournys = new GridBagConstraints();
                                                        details_tournys_frame.add(pan_details_tournys);
                                                        c_details_tournys.gridx = 0;
                                                        c_details_tournys.gridy = 0;
                                                        JLabel tourny_name = new JLabel("Tournament name:");
                                                        pan_details_tournys.add(tourny_name,c_details_tournys);
                                                        final JTextField field_name = new JTextField(10);
                                                        c_details_tournys.gridx++;
                                                        pan_details_tournys.add(field_name,c_details_tournys);

                                                        JButton back_tourny_frame = new JButton("Back");
                                                        c_details_tournys.gridy++;
                                                        pan_details_tournys.add(back_tourny_frame,c_details_tournys);

                                                        JButton see = new JButton("See");
                                                        c_details_tournys.gridx++;
                                                        pan_details_tournys.add(see,c_details_tournys);

                                                        back_tourny_frame.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                tourny_shows_customer.show(true);
                                                                details_tournys_frame.show(false);
                                                            }
                                                        });

                                                        see.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                details_tournys_frame.show(false);
                                                                final JFrame see_details = new JFrame("List");
                                                                see_details.setVisible(true);
                                                                see_details.setSize(500,500);
                                                                JPanel panel_see_details = new JPanel(new GridBagLayout());
                                                                GridBagConstraints c_details_see = new GridBagConstraints();
                                                                see_details.add(panel_see_details);
                                                                c_details_see.gridx = 0;
                                                                c_details_see.gridy = 0;
                                                                TournyDetailsRepository = Tournament_detailsServices.getTourny_DetailsRepository();
                                                                for(TournamentDetails t:TournyDetailsRepository.find())
                                                                {
                                                                    if(Objects.equals(t.getName(),field_name.getText()))
                                                                    {
                                                                        JLabel details = new JLabel(t.getDetails());
                                                                        panel_see_details.add(details,c_details_see);
                                                                        c_details_see.gridy++;
                                                                    }

                                                                }

                                                               JButton back = new JButton("Back");
                                                                c_details_see.gridy++;
                                                                panel_see_details.add(back);
                                                                back.addActionListener(new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        see_details.show(false);
                                                                        details_tournys_frame.show(true);
                                                                    }
                                                                });

                                                            }
                                                        });

                                                    }
                                                });
                                                participate.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        tourny_shows_customer.show(false);
                                                        final JFrame participate_frame = new JFrame();
                                                        participate_frame.setVisible(true);
                                                        participate_frame.setSize(500,500);
                                                        JPanel participate_panel = new JPanel(new GridBagLayout());
                                                        GridBagConstraints c_participate = new GridBagConstraints();
                                                        participate_frame.add(participate_panel);
                                                        c_participate.gridx = 0;
                                                        c_participate.gridy = 0;
                                                        JLabel username_participate = new JLabel("Userame:");
                                                        participate_panel.add(username_participate,c_participate);

                                                        c_participate.gridx = 1;
                                                        final JTextField textfield_participate = new JTextField(10);
                                                        participate_panel.add(textfield_participate,c_participate);

                                                        c_participate.gridx = 0;
                                                        c_participate.gridy = 1;
                                                        JLabel tournament_name = new JLabel("Tournament name:");
                                                        participate_panel.add(tournament_name,c_participate);

                                                        c_participate.gridx = 1;
                                                        final JTextField textField_tournament = new JTextField(10);
                                                        participate_panel.add(textField_tournament,c_participate);

                                                        JButton back = new JButton("Back");
                                                        c_participate.gridx = 0;
                                                        c_participate.gridy = 2;
                                                        participate_panel.add(back,c_participate);
                                                        JButton finish = new JButton("Finish");
                                                        c_participate.gridx = 1;
                                                        participate_panel.add(finish,c_participate);

                                                        back.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                tourny_shows_customer.show(true);
                                                                participate_frame.show(false);
                                                            }
                                                        });

                                                        finish.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                participantController.addParticipant(textField_tournament.getText(),textfield_participate.getText());
                                                            }
                                                        });

                                                    }
                                                });
                                            }
                                        });





                                    }
                                });

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
