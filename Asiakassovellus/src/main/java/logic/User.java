/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author anni
 */
public class User {
    String username;
    String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
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
