package FPA;

import FPA.Exceptions.WrongRoleException;
import FPA.Services.AnnoucementServices;
import FPA.Services.FyleSystemService;
import FPA.Services.ModeratorSevices;
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
        LogInView view = new LogInView();
    }
}
