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
 * Users class keeps track of all application users on a file
 * It takes care that no user has same username
 * @author anni
 */
public class Users {
    public static String filepath = "users.txt";
    public static User currentUser = null;
    public static User user = null;
    public static boolean userFounded;
    
    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static String getCurrentUserUsername() {
        if (currentUser == null) {
            return "";
        }
        return currentUser.username;
    }
    
    /** 
     * This method checks that the username is not taken
     * It adds the created user to users.txt file
     * @return Method returns a String which tells if new account was created
     */
    public static String createNewUser(String username, String pw) throws FileNotFoundException {
        try {
            userFounded = findUsername(username);
            currentUser = findUser(username, pw);
        } catch (IOException e) {
            return "Unable to connect to the file where users are stored.";
        }
        if (userFounded) {
            return "The username " + username + " is taken.";
        } else {
            try {
                FileWriter writer = new FileWriter(filepath, true);
                writer.append(username + ";" + pw);
                writer.append("\n");
                writer.flush();
                writer.close();
            } catch (Exception e) {
                return "Saving new user failed";
            }
            return "New account for " + username + " created successfully.";
        } 
    }
    
    /** 
     * This method checks that the same username does not exist
     * @return Method returns true if the username is taken and false if its free
     */
    public static Boolean findUsername(String username) throws FileNotFoundException {
        File file = new File(filepath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            return null;
        }
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String next = reader.nextLine();
            String[] split = next.split(";");
            if (split[0].equals(username)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }
    
    /** 
     * This method sets the current user
     * @return Method returns the current user
     */
    public static User findUser(String username, String password) throws FileNotFoundException {
        File file = new File(filepath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            return null;
        }
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String next = reader.nextLine();
            if (next.equals(username + ";" + password)) {
                reader.close();
                currentUser = new User(username, password);
                return currentUser;
            }
        }
        reader.close();
        return null;
    }
}