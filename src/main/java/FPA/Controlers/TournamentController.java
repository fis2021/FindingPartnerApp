package FPA.Controlers;

import FPA.Services.TournamentServices;
import FPA.View.LogInView;

import java.io.IOException;

public class TournamentController {
    private LogInView view;

    public TournamentController(){}
    public TournamentController(LogInView view) {
        this.view = view;
    }



    public boolean AddTournament(String name, String date) {
            TournamentServices.add(name, date);
       return true;
    }





}
