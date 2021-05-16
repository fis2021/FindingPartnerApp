package FPA.Services;

import org.junit.Test;

import java.nio.file.Files;

import static org.junit.Assert.*;

public class CustomerServicesTest {

    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception{
        CustomerServices.initDatabase();
        assertTrue(Files.exists(FyleSystemService.getPathToFile()));
    }

    @Test
    public void addOneCustomer() throws Exception{
        int i = CustomerServices.getCustomer().size();
        CustomerServices.addCustomer("Legion","Top","Diamond","Jungle");
        assertEquals(i+1,CustomerServices.getCustomer().size());
        CustomerServices.delete_customer("Legion");
    }

    @Test
    public void deleteCustomer() throws Exception{
        int i = CustomerServices.getCustomer().size();
        CustomerServices.addCustomer("Legion","Top","Platinum","Jungle");
        CustomerServices.delete_customer("Legion");
        assertEquals(i,CustomerServices.getCustomer().size());
    }




}
