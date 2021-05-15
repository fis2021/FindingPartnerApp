package FPA.Services;

import java.nio.file.Path;
import java.nio.file.Paths;


public class FyleSystemService {
    private static final String APPLICATION_FOLDER = ".FPA";
    private static final String USER_FOLDER = System.getProperty("moderator.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

    private static final String Annouce_FOLDER = System.getProperty("annoucements.home");
    public static final Path Annouce_HOME_PATH = Paths.get(Annouce_FOLDER, APPLICATION_FOLDER);
    public static Path getPathToFileAnnouce(String... path) {
        return Annouce_HOME_PATH.resolve(Paths.get(".", path));
    }

    private static final String Tourny_FOLDER = System.getProperty("Tournament.home");
    public static final Path Tourny_HOME_PATH = Paths.get(Tourny_FOLDER, APPLICATION_FOLDER);
    public static Path getPathToFileTourny(String... path)
    {
        return Tourny_HOME_PATH.resolve(Paths.get(".",path));
    }






}
