package FPA.Controlers;

import FPA.Services.ParticipantServices;
import FPA.View.LogInView;

public class ParticipantController {
    private String tournament_name;
    private String username;
    private LogInView view;

    public ParticipantController(LogInView view) {
        this.view = view;
    }

    public void addParticipant(String tournament_name, String username)
    {
        ParticipantServices.add(tournament_name,username);
    }
}
