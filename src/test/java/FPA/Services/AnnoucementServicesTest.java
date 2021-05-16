package FPA.Services;

import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnnoucementServicesTest {
    @Test
    public void testCopyDefaultAnnouceNotExists() throws Exception{
        AnnoucementServices.initDatabase();
        assertTrue(Files.exists(FyleSystemService.getPathToFile()));
    }

    @Test
    public void addAnAnnouce() throws Exception{
        int i = AnnoucementServices.getAllAnnoucements().size();
        assertEquals(i+1,AnnoucementServices.getAllAnnoucements().size());
    }

    @Test
    public void deleteAnnouce() throws Exception{
        int i = AnnoucementServices.getAllAnnoucements().size();
        AnnoucementServices.addAnnouce("test_annouce");
        AnnoucementServices.delete("test_annouce");
        assertEquals(i,AnnoucementServices.getAllAnnoucements().size());
    }


}
