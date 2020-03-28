/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;

/**
 *
 * @author anni
 */
public class BankApplication {
    int income = 0;
    int expenses = 0;
    HashMap<String, Integer> purchases = new HashMap<>();
    HashMap<String, Integer> categories = new HashMap<>();
    int userId;
    User user;
    
    public BankApplication(int id, User user) {
        this.userId = id;
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public int getUserId() {
        return userId;
    }
    
    public void bookIncome(int money) {
        income+=money;
    }
    public void bookExpense(String purchase, String purchaseCategory, int cost) {
        expenses+=cost;
        
        purchases.put(purchase, cost);
        
        if(categories.containsKey(purchaseCategory)) {
            categories.put(purchaseCategory, categories.get(purchaseCategory)+cost);
        } else {
            categories.put(purchaseCategory, cost);
        }
    }
    public int getIncome() {
        return income;
    }
    public int getExpenses() {
        return expenses;
    }
    public double percentUsedOfIncome() {
       double percent = (double) (expenses/income)*100;
       return percent;
    }
}
