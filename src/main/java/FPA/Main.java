package FPA;

import FPA.Exceptions.WrongRoleException;
import FPA.Services.*;
import FPA.View.LogInView;

import java.nio.file.Files;
import java.nio.file.Path;


public class Main {

    private static FyleSystemService FileSystemService;

    private static void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;

        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void main(String[] args) throws  WrongRoleException {
        initDirectory();
        ModeratorSevices.initDatabase();
        AnnoucementServices.initDatabase();
        TournamentServices.initDatabase();
        Tournament_detailsServices.initDatabase();
        LogInView view = new LogInView();
    }
}
