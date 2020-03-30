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
public class Users {
    public static String filepath = "users.txt";
    public static User currentUser = null;
    
    public static User getCurrentUser() {
        return currentUser;
    }
    public static String getCurrentUserUsername() {
        if(currentUser == null) return "";
        return currentUser.username;
    }
    public static String createNewUser(String username, String pw) throws FileNotFoundException {
        User user = null;
        try {
            user = findUser(username, pw);
        } catch(IOException e) {
            return "Unable to connect to the file where users are stored.";
        }
        if(!(user == null)) {
            return "The user " + username + " with the same password already exists.";
        } try {
            FileWriter writer = new FileWriter(filepath, true);
            writer.append(username+";"+pw);
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch(Exception e) {
            return "Saving the new user failed";
        }
        return "The new account for " + username + " created successfully.";
    }
    
    public static User findUser(String username, String password) throws FileNotFoundException {
        File file = new File(filepath);
        try {
            file.createNewFile();
        } catch(IOException e) {
            return null;
        }
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()) {
            String next = reader.nextLine();
            if(next.equals(username+";"+password)) {
                reader.close();
                currentUser = new User(username, password);
                return currentUser;
            }
        }
        reader.close();
        return null;
    }
    
}