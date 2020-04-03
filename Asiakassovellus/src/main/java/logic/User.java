/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;

/**
 *
 * @author anni
 */
public class User {
    static String username;
    static String password;
    public static String filepathIncome = username+"_"+"income.txt";
    public static String filepathExpense = username+"_"+"expense.txt";
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        File incomeFile = new File(filepathIncome);
        File expenseFile = new File(filepathExpense);
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
        if(!(obj instanceof User)) {
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
