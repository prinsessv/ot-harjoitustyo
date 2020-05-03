/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import logic.BankApplication;
import logic.Users;
import org.junit.AfterClass;
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
        BankApplication.bookIncome(2000);
        BankApplication.bookExpense("purchase", "purchaseCategory", 200);
        BankApplication.bookExpense("purchase", "category", 560);
    }
    
    //@AfterClass
    //public static void tearDownClass() {
    //}
    
    //@Before
    //public void setUp() throws FileNotFoundException{
    //}
    
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
        assertEquals("2000", BankApplication.getIncome());
    }
    
    @Test 
    public void expenseIsBooked() throws FileNotFoundException {
        assertEquals("760", BankApplication.getExpenses());
    }
    
    @Test
    public void percentIsRight() throws FileNotFoundException {
        assertEquals("You have used 38.0% of your income this month.", BankApplication.percentUsedOfIncome());
    }
    
    @Test
    public void expenseIsNotBookedIfUnderZero() {
        BankApplication.bookExpense("purchase", "purchaseCategory", -200);
        assertEquals("760", BankApplication.getExpenses());
    }
    
    @Test
    public void incomeIsNotBookedIfUnderOrEqualToZero() throws FileNotFoundException {
        BankApplication.bookIncome(-200);
        BankApplication.bookIncome(0);
        assertEquals("2000", BankApplication.getIncome());
    }
    
    @Test 
    public void percentIsRightForCategory() throws FileNotFoundException {
        assertEquals("10.0% of your income.", BankApplication.percentsUsedOfIncomeForEachCategory("purchaseCategory"));
    }
    
    @Test
    public void comparingIncomeWorks() throws FileNotFoundException {
        assertEquals("It is 1714$ less than the average monthly income in US.", BankApplication.compareIncomeToAverage());
    }
    
    @Test
    public void howMuchIncomeLeftReturnsRightValue() throws FileNotFoundException {
        assertEquals("You have still 1240$ left to use.", BankApplication.howMuchIncomeLeft());
    }
    
    @Test
    public void getAllCategoriesReturnsRightSizeList() {
        assertEquals(2, BankApplication.getAllCategories().size());
    }
    
    @Test
    public void moneyUsedToCertainCategoryIsRight() {
        assertEquals("You have spent 200$ to category purchaseCategory which equals ", BankApplication.moneyUsedToCertainCategory("purchaseCategory"));
        assertEquals("You have spent 0$ to category purchaseC which equals ", BankApplication.moneyUsedToCertainCategory("purchaseC"));
    }
}
