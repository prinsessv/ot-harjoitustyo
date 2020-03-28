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
        
       //
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
      
        Button button = new Button("LOGIN");
        HBox hButton = new HBox(10);
        hButton.setAlignment(Pos.BOTTOM_RIGHT);
        hButton.getChildren().add(button);
        grid.add(hButton, 1, 4);
      
        Button button2 = new Button("CREATE NEW USER");
        HBox hButton2 = new HBox(20);
        hButton2.setAlignment(Pos.BOTTOM_RIGHT);
        hButton2.getChildren().add(button2);
        grid.add(hButton2, 1, 5);
      
        final Text errorText = new Text();
        grid.add(errorText, 1, 7);
      
      //
     // View after LOGIN:
     
        Label welcomeText = new Label("Welcome!");
        StackPane welcome = new StackPane();
        welcome.setPrefSize(300, 160);
        welcome.getChildren().add(welcomeText);
        welcome.setAlignment(Pos.CENTER);
        Scene welcomeScene = new Scene(welcome);
        
      //
     // View after pressing button CREATE NEW USER looks like this:
     
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
      
        Text title = new Text("You wanted to create new user");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid2.add(title, 0, 0, 2, 1);
       
        Label newUsername = new Label("Username:");
        grid2.add(newUsername, 0, 1);
        TextField name = new TextField();
        grid2.add(name, 1, 1);
        
        Label newPassword = new Label("Password:");
        grid2.add(newPassword, 0, 2);
        PasswordField newPasswordField = new PasswordField();
        grid2.add(newPasswordField, 1, 2);
        
        Label repeatPassword = new Label("Repeat password:");
        grid2.add(repeatPassword, 0, 3);
        PasswordField repeatPasswordField = new PasswordField();
        grid2.add(repeatPasswordField, 1, 3);
        
        Button createButton = new Button("CREATE");
        HBox createButton2 = new HBox(10);
        createButton2.setAlignment(Pos.BOTTOM_RIGHT);
        createButton2.getChildren().add(createButton);
        grid2.add(createButton, 1, 4);
        
        Scene createScene = new Scene(grid2);
        
      //
     // CREATE NEW USER button action:
     
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene);
            }
        });
        
        //View after pressing create button
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
        
      //
     // CREATE button action:
     
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String user = name.getText();
                String passw = newPasswordField.getText();
                Users users = new Users();
                try {
                    users.createNewUser(user, passw);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                primaryStage.setScene(newScene);
            }
        });
       
      //
     // LOGIN button action:
     
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Users users = new Users();
                try {
                    if(!users.findUser(userTextfield.getText(), passwordField.getText())) {
                        errorText.setFill(Color.FIREBRICK);
                        errorText.setText("Wrong username or password");
                        return;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                primaryStage.setScene(welcomeScene);
            }
        });
      
      //
     // Initialization:
     
      Scene scene = new Scene(grid, 400, 375);
      
      //
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
