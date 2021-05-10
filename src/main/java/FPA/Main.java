package FPA;

import FPA.Services.FyleSystemService;
import FPA.Services.ModeratorSevices;
import FPA.View.RegistrationView;


import java.nio.file.Files;
import java.nio.file.Path;


public class Main {

    private static FyleSystemService FileSystemService;

    private static void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void main(String[] args) {
        initDirectory();
        ModeratorSevices.initDatabase();
        RegistrationView view = new RegistrationView();

    }
}
