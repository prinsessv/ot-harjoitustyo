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
 * User class creates new user objects 
 * and proper files connected to the user object that is created
 * @author anni
 */
public class User {
    static String username;
    static String password;
    public static User user = null;
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
    
    /** 
     * This method sets the user for BankApplication user
     * @return Method returns the user that is set
     */
    public static User setUser(String username, String password) {
        BankApplication.user = new User(username, password);
        return user;
    }
    
    /** 
     * This method seeks the users password
     * @return Method returns the password found
     */
    public String getPassword() {
        return password;
    }
    
    /** 
     * This method seeks the users username
     * @return Method returns the username found
     */
    public String getUsername() {
        return username;
    }
    
    /** 
     * This method seeks the filepath of income file
     * @return Method returns the filepath found
     */
    public String getIncomeFilePath() {
        return filepathIncome;
    }
    
    /** 
     * This method seeks the filepath of expense file
     * @return Method returns the filepath found
     */
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
