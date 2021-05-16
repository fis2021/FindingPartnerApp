package FPA.Services;

import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TournamentServicesTest {
    @Test
    public void testCopyDefaultTournamentsExists() throws Exception{
        TournamentServices.initDatabase();
        assertTrue(Files.exists(FyleSystemService.getPathToFile()));
    }

    @Test
    public void addTourny() throws Exception{
        int i = TournamentServices.getAllTournys().size();
        assertEquals(i+1,TournamentServices.getAllTournys().size());
    }

    @Test
    public void deleteTourny() throws Exception{
        int i = TournamentServices.getAllTournys().size();
        TournamentServices.add("test_annouce","test date");
        TournamentServices.delete("test_annouce");
        assertEquals(i,TournamentServices.getAllTournys().size());
    }
}
