package FPA.Controllers;

import FPA.Controlers.RegistrationController;
import FPA.Exceptions.AccAlreadyExistException;
import FPA.Services.FyleSystemService;
import FPA.Services.ModeratorSevices;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;


public class RegistrationControllerTest {

    private static final String test_username = "Test-username";
    private static final String test_password = "Test-password";
    private static final String test_role = "Test-role";
    private static int contor;

    @BeforeClass
    public static void setUp() throws Exception{
       ModeratorSevices.initDatabase();
       contor = ModeratorSevices.getAllUsers().size();
    }

    @Test
    public void testHandleAddUser(){
        try {
            ModeratorSevices.addUser(test_username,test_password,test_role);
        } catch (AccAlreadyExistException e) {
            e.printStackTrace();
        }
        assertEquals(contor+1,ModeratorSevices.getAllUsers().size());
        ModeratorSevices.delete(test_username);
    }
}
