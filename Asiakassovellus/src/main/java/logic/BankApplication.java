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
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * BankApplication class implements the main logic behind the application
 * User interface calls the methods of this class to execute its features
 * @author anni
 */
public class BankApplication {
    static User user;
    static double percent = 0.0;
    static File incomeFilePath = Users.getCurrentUser().incomeFile;
    static File expenseFilePath = Users.getCurrentUser().expenseFile;
    
    public BankApplication(User user) {
        this.user = user;
    }
    
    /** 
     * This method seeks the user running this BankApplication at the moment
     * @return Method returns the user using BankApplication if found
     */
    public static User getUser() {
        return user;
    }
    
    /** 
     * This method books the customers income to a file
     * @param income Integer value of income that the customer wanted to book
     * @return String which tells if the income was booked successfully
     */
    public static String bookIncome(double income) throws FileNotFoundException {
        double incomeToBook = Double.valueOf(BankApplication.getIncome()) + income;
        
        if (income > 0) {
            try {
                FileWriter writer = new FileWriter(incomeFilePath, true);
                writer.append(String.valueOf(incomeToBook));
                writer.append("\n");
                writer.flush();
                writer.close();
            } catch (Exception e) {
                return "Booking income failed.";
            }
            return "Income is booked succesfully.";
        } else {
            return "Income can not be negative or zero.";
        }
    }
    
    /**
     * This method books the customers expense to a file
     * @param purchase String which tells what the customer has bought
     * @param purchaseCategory String which tells the category of the purchase, used for one report
     * @param cost Integer value of cost of the purchase
     * @return String which tells if the expense was booked successfully
     */
    public static String bookExpense(String purchase, String purchaseCategory, double cost) {
        if (cost >= 0) {
            try {
                FileWriter writer = new FileWriter(expenseFilePath, true);
                writer.append(purchase + ";" + purchaseCategory + ";" + String.valueOf(cost));
                writer.append("\n");
                writer.flush();
                writer.close();
            } catch (Exception e) {
                return "Booking expense failed.";
            }
            return "Expense is booked succesfully.";
        } else {
            return "Cost can not be negative.";
        }
    }
    
    /** 
     * This method seeks the income from the right file 
     * Seeked income can be used in other methods and to report income if needed
     * @return Integer value of the income found or zero if the file was empty
     */
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
    
    /** 
     * This method seeks the total of expenses from the right file 
     * This sum can be used in other methods and to report expenses if needed
     * @return Integer value of the expenses in total if found or zero if the file was empty
     */
    public static String getExpenses() {
        double expenseSum = 0;
       
        try (Scanner reader = new Scanner(new File(Users.getCurrentUser().getExpenseFilePath()))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                if (row.trim().length() == 0) {
                    continue;
                }
                String[] expenses = row.split(";");
                double cost = Double.valueOf(expenses[2]);
                expenseSum += cost;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return String.valueOf(expenseSum);
    }
    
    /** 
     * This method compares the customers income to average US monthly income
     * It is used in the report which tells the customers income
     * @return String which tells how much more or less the compared income is
     */
    public static String compareIncomeToAverage() throws FileNotFoundException {
        double income = Double.parseDouble(BankApplication.getIncome());
        int average = 3714;
        double marginal = 0;
        
        if (income < average) {
            marginal = average - income;
            return "It is " + String.valueOf(marginal) + "$ less than the average monthly income in US.";
        } else if (income > average) {
            marginal = income - average;
            return "It is " + String.valueOf(marginal) + "$ more than the average monthly income in US.";
        } else {
            return "Your income is the average monthly income in US.";
        }
    }
    
    /** 
     * This method tells how much income is left after all the expenses
     * It is used in the report which tells the expenses
     * @return String which tells how much money there is still to use
     */
    public static String howMuchIncomeLeft() throws FileNotFoundException {
        double expenses = Double.parseDouble(BankApplication.getExpenses());
        double income = Double.parseDouble(BankApplication.getIncome());
        double marginal = 0;
        
        if (income > expenses) {
            marginal = income - expenses;
            return "You have still " + String.valueOf(marginal) + "$ left to use.";
        } else if (expenses > income) {
            return "Please notice that you have used more money than you got this month. " +
                   "\n" + "Contact the customer service to get your economy balanced if needed.";
        } else {
            return "You have 0$ to use.";
        }
    }
    
    /** 
     * This method seeks all the categories where money has been used
     * If customer forgets the categories where money has been used, it can be checked
     * @return List which includess all the categories where money has been used
     */
    public static ArrayList<String> getAllCategories() {
        ArrayList<String> categories = new ArrayList<>();
        
        try (Scanner reader = new Scanner(new File(Users.getCurrentUser().getExpenseFilePath()))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                if (row.trim().length() == 0) {
                    continue;
                }
                String[] splitRow = row.split(";");
                if (!(categories.contains(splitRow[1]))) {
                    categories.add(splitRow[1]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return categories;
    }
    
    /**
     * This method calculates the percent that the customer has used from income
     * @return String value of the percent used
     */
    public static String percentUsedOfIncome() throws FileNotFoundException {
        double income = Double.parseDouble(BankApplication.getIncome());
        double expenses = Double.parseDouble(BankApplication.getExpenses());
        
        if (income > 0) {
            double percent = (double) (expenses * 100) / income;
            if (Math.round(percent) == 0) {
                return "You have used under 1% of your income this month.";
            } else {
                return "You have used approximately " + String.valueOf(Math.round(percent)) + "% of your income this month.";
            }
        } else { 
            return "You have used 0% of your income this month.";
        }
    }
    
    /**
     * This method tells how much money has been used to a certain category
     * It is used in the method which tells the percent used to a certain category
     *
     * @return String which tells how much more or less the compared income is
     */
    public static String moneyUsedToCertainCategory(String category) {
        double sum = 0;
        
        try (Scanner reader = new Scanner(new File(Users.getCurrentUser().getExpenseFilePath()))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                if (row.trim().length() == 0) {
                    continue;
                }
                String[] splitRow = row.split(";");
                if (splitRow[1].equals(category)) {
                    sum += Double.valueOf(splitRow[2]);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (sum > 0) {
            return "You have spent " + String.valueOf(sum) + "$ to category " + category + " which equals approximately ";
        }
        return "You have spent 0$ to category " + category + " which equals approximately ";
    }
    
    /**
     * This method calculates the percent that the customer has used from income to a certain category
     * @return String value of the percent used to a certain category or zero if used money is zero
     */
    public static String percentsUsedOfIncomeForEachCategory(String category) throws FileNotFoundException {
        double totalOfUsedMoney = 0;
        
        if (Double.parseDouble(BankApplication.getIncome()) > 0) {
            try (Scanner reader = new Scanner(new File(Users.getCurrentUser().getExpenseFilePath()))) {
                while (reader.hasNextLine()) {
                    String row = reader.nextLine();
                    if (row.trim().length() == 0) {
                        continue;
                    }
                    String[] splitRow = row.split(";");
                    if (splitRow[1].equalsIgnoreCase(category)) {
                        totalOfUsedMoney += Double.valueOf(splitRow[2]);
                    } 
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            percent = (double) (totalOfUsedMoney * 100) / Double.parseDouble(BankApplication.getIncome());
        }
        
        if (percent != 0 && Math.round(percent) == 0) {
            return "under 1% of your income this month.";
        } else {
            return String.valueOf(Math.round(percent)) + "% of your income."; 
        }
    }
    
    /**
     * This method resets the files that include income and expenses
     * @return String which tells that reset is done
     */
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