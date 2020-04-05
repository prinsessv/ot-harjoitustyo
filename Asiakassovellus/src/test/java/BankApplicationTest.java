/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import logic.BankApplication;
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
    public static void setUpClass() throws FileNotFoundException {
        Users.createNewUser("user", "password");
        BankApplication app = new BankApplication(Users.getCurrentUser());
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
        assertEquals("user", Users.findUser("user", "password").toString());
        
    }
    @Test
    public void incomeIsBooked() throws FileNotFoundException {
        BankApplication.bookIncome(66);
        assertEquals("66", BankApplication.getIncome());
    }
}
