/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author anni
 */
public class Users {
    String filepath = "users.txt";
  
    public void createNewUser(String username, String pw) throws FileNotFoundException {
        User user = new User(username, pw);
        PrintWriter file = new PrintWriter("filepath");
        file.println(username+";"+pw);
        file.close();
    }
    public boolean findUser(String username, String password) throws FileNotFoundException {
        Scanner file = new Scanner("filepath");
        while(file.hasNextLine()) {
            if(file.nextLine().equals(username+";"+password)) {
                return true;
            }
        }
        return false;
    }
    
}
