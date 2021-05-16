package FPA.Services;

import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tournament_DetailsServicesTest {
    @Test
    public void testCopyDefaultTournamentsDetailsExists() throws Exception{
        Tournament_detailsServices.initDatabase();
        assertTrue(Files.exists(FyleSystemService.getPathToFile()));
    }

    @Test
    public void addTournyDetails() throws Exception{
        int i = Tournament_detailsServices.getAllDetails().size();
        assertEquals(i+1,Tournament_detailsServices.getAllDetails().size());
    }

    @Test
    public void deleteTournyDetails() throws Exception{
        int i = Tournament_detailsServices.getAllDetails().size();
        Tournament_detailsServices.addDetails("test_annouce","test_details");
        Tournament_detailsServices.delete("test_annouce");
        assertEquals(i,Tournament_detailsServices.getAllDetails().size());
    }
}
