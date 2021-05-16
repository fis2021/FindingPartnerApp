package FPA.Services;

import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModeratorServicesTest {

    @Test
    public void testCopyDefaultModeratorNotExists() throws Exception{
        ModeratorSevices.initDatabase();
        assertTrue(Files.exists(FyleSystemService.getPathToFile()));
    }

    @Test
    public void addOneModerator() throws Exception{
        int i = ModeratorSevices.getUsers().size();
        ModeratorSevices.addUser("Legion","asdff","doesntmatter");
        assertEquals(i+1,ModeratorSevices.getUsers().size());
        ModeratorSevices.delete("Legion");
    }

}
