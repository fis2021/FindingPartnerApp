package FPA.Services;

import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParticipantServicesTest {

    @Test
    public void testCopyDefaultParticipantNotExists() throws Exception{
        AnnoucementServices.initDatabase();
        assertTrue(Files.exists(FyleSystemService.getPathToFile()));
    }

    @Test
    public void addParticipant() throws Exception{
        int i = ParticipantServices.getAllParticipants().size();
        assertEquals(i+1,AnnoucementServices.getAllAnnoucements().size());
    }

    @Test
    public void deleteParticipant() throws Exception{
        int i = ParticipantServices.getAllParticipants().size();
        ParticipantServices.add("test_tourny","test_username");
        ParticipantServices.delete("test_annouce");
        assertEquals(i,AnnoucementServices.getAllAnnoucements().size());
    }
}
