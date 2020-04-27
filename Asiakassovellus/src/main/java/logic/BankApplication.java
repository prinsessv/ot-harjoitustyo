/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author anni
 */
public class BankApplication {
    static User user;
    static double percent = 0.0;
    static File incomeFilePath;
    static File expenseFilePath;
    
    public BankApplication(User user) {
        this.user = user;
        this.incomeFilePath = user.incomeFile;
        this.expenseFilePath = user.expenseFile;
    }
    
    public static User getUser() {
        return user;
    }
    
    public static String bookIncome(int income) {
        if (income > 0) {
            try {
                FileWriter writer = new FileWriter(incomeFilePath, true);
                writer.append(String.valueOf(income));
                writer.append("\n");
                writer.flush();
                writer.close();
            } catch (Exception e) {
                return "Booking income failed";
            }
            return "Income is booked succesfully";
        } else {
            return "Income can not be negative or zero";
        }
    }
    
    public static String bookExpense(String purchase, String purchaseCategory, int cost) {
        if (cost >= 0) {
            try {
                FileWriter writer = new FileWriter(expenseFilePath, true);
                writer.append(purchase + ";" + purchaseCategory + ";" + String.valueOf(cost));
                writer.append("\n");
                writer.flush();
                writer.close();
                } catch (Exception e) {
                return "Booking expense failed";
            }
            return "Expense is booked succesfully";
        } else {
            return "Cost can not be negative";
        }
    }
    
    public static String getIncome() throws FileNotFoundException {
        String income = "0";
    
        try (Scanner reader = new Scanner(new File(Users.getCurrentUser().getIncomeFilePath()))) {
            while (reader.hasNextLine()) {
                income = reader.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return income;
    }
    
    public static String getExpenses() {
        int expenseSum = 0;
       
        try (Scanner reader = new Scanner(new File(Users.getCurrentUser().getExpenseFilePath()))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                if (row.trim().length() == 0) {
                    continue;
                }
                String[] expenses = row.split(";");
                int cost = Integer.valueOf(expenses[2]);
                expenseSum += cost;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return String.valueOf(expenseSum);
    }
    
    public static String percentUsedOfIncome() throws FileNotFoundException {
        int income = Integer.parseInt(BankApplication.getIncome());
        int expenses = Integer.parseInt(BankApplication.getExpenses());
        
        if(income > 0) {
            double percent = (double) (expenses * 100) / income;
            return String.valueOf(percent);
        } else {
            return "0";
        }
    }
    
    public static String percentsUsedOfIncomeForEachCategory(String category) throws FileNotFoundException {
        int totalOfUsedMoney = 0;
        
        if (Integer.parseInt(BankApplication.getIncome()) > 0) {
            try (Scanner reader = new Scanner(new File(Users.getCurrentUser().getExpenseFilePath()))) {
                while (reader.hasNextLine()) {
                    String row = reader.nextLine();
                    if (row.trim().length() == 0) {
                        continue;
                    }
                    String[] splitRow = row.split(";");
                    if (splitRow[1].equalsIgnoreCase(category)) {
                        totalOfUsedMoney += Integer.valueOf(splitRow[2]);
                    } 
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            percent = (double) (totalOfUsedMoney * 100) / Integer.parseInt(BankApplication.getIncome());
        } 
        return "You have used " + String.valueOf(percent) + "% of your income to category " + category + " this month"; 
    }
    
    public static String resetAll() {
        if (incomeFilePath.exists()) {
            incomeFilePath.delete();
            try {
                incomeFilePath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if (expenseFilePath.exists()) {
            expenseFilePath.delete();
            try {
                expenseFilePath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }          
        return "Files were successfully reset";
    }
}
