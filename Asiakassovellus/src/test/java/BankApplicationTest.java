import java.io.FileNotFoundException;
import logic.BankApplication;
import logic.Users;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * This class tests the whole application
 * @author anni
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankApplicationTest {
    
    @BeforeClass
    public static void setUpClass() throws FileNotFoundException {
        Users.createNewUser("user", "password");
        BankApplication app = new BankApplication(Users.getCurrentUser());
        BankApplication.bookIncome(2000.0);
        BankApplication.bookExpense("purchase", "purchaseCategory", 200.0);
        BankApplication.bookExpense("purchase", "category", 560.0);
    }
    
    @Test
    public void AusernameIsFound() throws FileNotFoundException {
        assertEquals(true, Users.findUsername("user"));
    }
    
    @Test
    public void BisAddedUserFound() throws FileNotFoundException {
        assertEquals("user", Users.findUser("user", "password").toString());
    }
   
    @Test
    public void CincomeIsBooked() throws FileNotFoundException {
        assertEquals("2000.0", BankApplication.getIncome());
    }
    
    @Test 
    public void DexpenseIsBooked() throws FileNotFoundException {
        assertEquals("760.0", BankApplication.getExpenses());
    }
    
    @Test
    public void EpercentIsRight() throws FileNotFoundException {
        assertEquals("You have used approximately 38% of your income this month.", BankApplication.percentUsedOfIncome());
    }
    
    @Test
    public void FexpenseIsNotBookedIfUnderZero() {
        BankApplication.bookExpense("purchase", "purchaseCategory", -200);
        assertEquals("760.0", BankApplication.getExpenses());
    }
    
    @Test
    public void GincomeIsNotBookedIfUnderOrEqualToZero() throws FileNotFoundException {
        BankApplication.bookIncome(-200);
        BankApplication.bookIncome(0);
        assertEquals("2000.0", BankApplication.getIncome());
    }
    
    @Test 
    public void HpercentIsRightForCategory() throws FileNotFoundException {
        assertEquals("10% of your income.", BankApplication.percentsUsedOfIncomeForEachCategory("purchaseCategory"));
    }
    
    @Test
    public void IcomparingIncomeWorks() throws FileNotFoundException {
        assertEquals("It is 1714.0$ less than the average monthly income in US.", BankApplication.compareIncomeToAverage());
    }
    
    @Test
    public void JhowMuchIncomeLeftReturnsRightValue() throws FileNotFoundException {
        assertEquals("You have still 1240.0$ left to use.", BankApplication.howMuchIncomeLeft());
    }
    
    @Test
    public void KgetAllCategoriesReturnsRightSizeList() {
        assertEquals(2, BankApplication.getAllCategories().size());
    }
    
    @Test
    public void LmoneyUsedToCertainCategoryIsRight() {
        assertEquals("You have spent 200.0$ to category purchaseCategory which equals approximately ", BankApplication.moneyUsedToCertainCategory("purchaseCategory"));
        assertEquals("You have spent 0$ to category purchaseC which equals approximately ", BankApplication.moneyUsedToCertainCategory("purchaseC"));
    }
    
    @Test
    public void MresetWorks() throws FileNotFoundException {
        BankApplication.resetAll();
        assertEquals("0", BankApplication.getIncome());
        assertEquals("0.0", BankApplication.getExpenses());
    }
}
