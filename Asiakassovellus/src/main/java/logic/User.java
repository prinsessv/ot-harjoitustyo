/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.IOException;
import static logic.BankApplication.user;

/**
 *
 * @author anni
 */
public class User {
    static String username;
    static String password;
    public static String filepathIncome;
    public static String filepathExpense;
    File incomeFile;
    File expenseFile;
    
    public User(String username, String password) {
        User.username = username;
        User.password = password;
        User.filepathIncome = username + "_" + "income.txt";
        User.filepathExpense = username + "_" + "expense.txt";
        this.incomeFile = new File(filepathIncome);
        this.expenseFile = new File(filepathExpense);
        
        try {
            incomeFile.createNewFile();
            expenseFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Something went wrong while creating new files");
        }
    }
    public static User setUser(String username, String password) {
        BankApplication.user = new User(username, password);
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public String getIncomeFilePath() {
        return filepathIncome;
    }
    public String getExpenseFilePath() {
        return filepathExpense;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
        return false;
        }
        User other = (User) obj;
        return username.equals(other.username);
    }
    @Override
    public String toString() {
        return username;
    }
}
