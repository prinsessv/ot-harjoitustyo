/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;
import static logic.Users.currentUser;
import static logic.Users.filepath;

/**
 *
 * @author anni
 */
public class BankApplication {
    static User user;
    
    public BankApplication(User user) {
        this.user = user;
    }
    
    public static User getUser() {
        return user;
    }
    
    public static String bookIncome(int income) {
        try {
            FileWriter writer = new FileWriter(user.getIncomeFilePath(), true);
            writer.append(String.valueOf(income));
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch(Exception e) {
            return "Booking income failed";
        }
        return "Income is booked succesfully";
    }
    
    public static String bookExpense(String purchase, String purchaseCategory, int cost) {
        String money = String.valueOf(cost);
        try {
            FileWriter writer = new FileWriter(user.getExpenseFilePath(), true);
            writer.append(purchase+";"+purchaseCategory+";"+money);
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch(Exception e) {
            return "Booking expense failed";
        }
        return "Expense is booked succesfully";
    }
    public static String getIncome() {
        Scanner reader = new Scanner(user.getIncomeFilePath());
        String income = "";
        while(reader.hasNextLine()); {
        income = reader.nextLine();
        }
        return income;
    }
    public static int getExpenses() {
        return 0;
    }
    public static double percentUsedOfIncome() {
       return 0.0;
    }
}
