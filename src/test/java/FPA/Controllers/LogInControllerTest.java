package FPA.Controllers;
import FPA.Services.FyleSystemService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Files;
import FPA.Services.ModeratorSevices;

import static org.junit.Assert.*;
public class LogInControllerTest {
    private static final String test_username = "Test-username";
    private static final String test_password = "Test-password";

    @BeforeClass
    public static void setupClass() throws Exception {
        FyleSystemService.APPLICATION_FOLDER = ".test_database";
        ModeratorSevices.initDatabase();
    }

    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception{
        assertTrue(Files.exists(FyleSystemService.getPathToFile()));
        ModeratorSevices.close();
    }

}
