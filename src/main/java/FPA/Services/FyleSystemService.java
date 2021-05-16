package FPA.Services;

import java.nio.file.Path;
import java.nio.file.Paths;


public class FyleSystemService {
    public static String APPLICATION_FOLDER = ".FPA";
    private static final String USER_FOLDER = System.getProperty("moderator.home");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

    public static Path getApplicationHomeFolder() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }
}
