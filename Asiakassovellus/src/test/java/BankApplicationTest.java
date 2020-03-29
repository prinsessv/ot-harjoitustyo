/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import logic.User;
import logic.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anni
 */
public class BankApplicationTest {
    
    public BankApplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    //@AfterClass
    //public static void tearDownClass() {
    //}
    
    @Before
    public void setUp() {
        
    }
    
    //@After
    //public void tearDown() {
    //}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void isAddedUserFound() throws FileNotFoundException {
        Users user = new Users();
        user.createNewUser("user", "password");
        
        assertEquals("user", user.findUser("user", "password").toString());
        
    }
}
