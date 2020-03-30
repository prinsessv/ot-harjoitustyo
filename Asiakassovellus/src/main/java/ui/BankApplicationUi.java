/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Users;

/**
 *
 * @author anni
 */
public class BankApplicationUi extends Application {
   
    @Override
    public void start(Stage primaryStage) {

        // Sign in view:
        primaryStage.setTitle("Accounting");
      
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
      
        Text scenetitle = new Text("Sign In");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
      
        Label username = new Label("Username:");
        grid.add(username, 0, 1);
        TextField userTextfield = new TextField();
        grid.add(userTextfield, 1, 1);
        
        Label password = new Label("Password: ");
        grid.add(password, 0, 2);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);
        
        Button loginButton = new Button("LOGIN");
        HBox logInButton = new HBox(10);
        logInButton.setAlignment(Pos.BOTTOM_RIGHT);
        logInButton.getChildren().add(loginButton);
        grid.add(logInButton, 1, 4);
        
        Button createNewUserButton = new Button("CREATE NEW USER");
        HBox createNewUButton = new HBox(20);
        createNewUButton.setAlignment(Pos.BOTTOM_RIGHT);
        createNewUButton.getChildren().add(createNewUserButton);
        grid.add(createNewUButton, 1, 5);
        // Error text appearing on the front page if username/pw is wrong
        final Text errorText = new Text();
        grid.add(errorText, 1, 7);
        // Making of sign in view ends here
        
        // Form that appears after pressing button CREATE NEW USER:
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
      
        Text title = new Text("You wanted to create new user");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid2.add(title, 0, 0, 2, 1);
        
        Label createUsername = new Label("Username:");
        grid2.add(createUsername, 0, 1);
        TextField createUsernameField = new TextField();
        grid2.add(createUsernameField, 1, 1);
        
        Label createPassword = new Label("Password:");
        grid2.add(createPassword, 0, 2);
        PasswordField createPasswordField = new PasswordField();
        grid2.add(createPasswordField, 1, 2);
        
        Label repeatThatPassword = new Label("Repeat password:");
        grid2.add(repeatThatPassword, 0, 3);
        PasswordField repeatThatPasswordField = new PasswordField();
        grid2.add(repeatThatPasswordField, 1, 3);
        
        Button finalCreateButton = new Button("CREATE");
        HBox finalCButton = new HBox(10);
        finalCButton.setAlignment(Pos.BOTTOM_RIGHT);
        finalCButton.getChildren().add(finalCreateButton);
        grid2.add(finalCButton, 1, 4);
        
        Scene createScene = new Scene(grid2);
        //Making of "create new user" form ends here
        
         // CREATE-NEW-USER button action
        createNewUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene);
            }
        });
        
        // View after filling the form and pressing CREATE button
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));
        
        Text success = new Text("New account has been made successfully");
        success.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid3.add(success, 0, 0, 2, 1);
        
        Button back = new Button("Back to login page");
        HBox backButton = new HBox(10);
        backButton.setAlignment(Pos.BOTTOM_RIGHT);
        backButton.getChildren().add(back);
        grid3.add(back, 1, 1);
        
        Scene newScene = new Scene(grid3);
        
        // CREATE button action:
        finalCreateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String username = createUsernameField.getText();
                String passw = createPasswordField.getText();
                try {
                    success.setText(Users.createNewUser(username, passw));
                    primaryStage.setScene(newScene);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // View after successfull LOGIN:
        Label welcomeText = new Label("Welcome!");
        StackPane welcome = new StackPane();
        welcome.setPrefSize(300, 160);
        welcome.getChildren().add(welcomeText);
        welcome.setAlignment(Pos.CENTER);
        Scene welcomeScene = new Scene(welcome);
         
        // LOGIN button action:
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    System.out.println(userTextfield.getText()+","+passwordField.getText());
                    if(Users.findUser(userTextfield.getText(), passwordField.getText()) == null) {
                        errorText.setFill(Color.FIREBRICK);
                        errorText.setText("Wrong username or password");
                        return;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                welcomeText.setText("Welcome " + Users.getCurrentUserUsername() + "!");
                primaryStage.setScene(welcomeScene);
            }
        });
      
        // Initialization:
        Scene scene = new Scene(grid, 400, 375);
      
        // Back to login page button action:
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(scene);
            }
        });
 
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
