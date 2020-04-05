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
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import logic.BankApplication;
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
        //
        
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
        //
        
        // CREATE-NEW-USER button action
        createNewUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene);
            }
        });
        //
        
        // View after filling the CREATE NEW USER form and pressing CREATE button
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
        //
        
        // View after successfull LOGIN:
        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setHgap(10);
        grid4.setVgap(10);
        grid4.setPadding(new Insets(25, 25, 25, 25));
        
        Label welcomeText = new Label("Welcome!");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        grid4.add(welcomeText, 0, 0, 2, 1);
        
        Button incomeButton = new Button("Book income");
        grid4.add(incomeButton, 0, 4);
        Button expenseButton = new Button("Book expense");
        grid4.add(expenseButton, 0, 5);
        Button reportButton = new Button("Print report");
        grid4.add(reportButton, 0, 10);
        Button resetButton = new Button("Reset all");
        grid4.add(resetButton, 0, 11);
        Button logoutButton = new Button("LOGOUT");
        logoutButton.setStyle("-fx-background-color: white; ");
        grid4.add(logoutButton, 0, 1, 1, 1); 
        
        Scene welcomeScene = new Scene(grid4);
        //
        
        //Book income button opens a form
        GridPane bookIncome = new GridPane();
        bookIncome.setAlignment(Pos.CENTER);
        bookIncome.setHgap(10);
        bookIncome.setVgap(10);
        bookIncome.setPadding(new Insets(25, 25, 25, 25));
        
        Label howMuch = new Label("Income to book: ");
        TextField bookingIncome = new TextField();
        
        bookIncome.add(howMuch, 0, 0);
        bookIncome.add(bookingIncome, 1, 0);
        
        Button bookIt = new Button("Book this income");
        bookIncome.add(bookIt, 1, 1);
        
        Scene bookingIncomeScene = new Scene(bookIncome);
        //
        
        //After book income form
        GridPane incomeBooked = new GridPane();
        incomeBooked.setAlignment(Pos.CENTER);
        incomeBooked.setHgap(10);
        incomeBooked.setVgap(10);
        incomeBooked.setPadding(new Insets(25, 25, 25, 25));
        
        Label incomeBookedSuccessfully = new Label("Income has been booked succesfully.");
        Button backToFrontPage = new Button("Back to front page");
        
        incomeBooked.add(incomeBookedSuccessfully, 0, 0);
        incomeBooked.add(backToFrontPage, 0, 1);
        
        Scene incomeIsBooked = new Scene(incomeBooked);
        //
       
        //Back to front page button action
        backToFrontPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        //
        
        // bookIncome button action
        incomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(bookingIncomeScene);
            }
        });
        //
        
        // Book it button action
        bookIt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                BankApplication.bookIncome(Integer.parseInt(bookingIncome.getText()));
                primaryStage.setScene(incomeIsBooked);
            }
           
        });
        //
        
        // Book expense button action
        
        //
        
        // View after pressing print report button
        GridPane report = new GridPane();
        report.setAlignment(Pos.CENTER);
        report.setHgap(10);
        report.setVgap(10);
        report.setPadding(new Insets(25, 25, 25, 25));
        
        Button income = new Button("Income");
        Button expenses = new Button("Expenses");
        Button percent = new Button("Percents used of income");
        Button category = new Button("Percents used of income for each category");
        
        report.add(income, 0, 0);
        report.add(expenses, 0, 1);
        report.add(percent, 0, 2);
        report.add(category, 0, 3);
        
        Scene reportScene = new Scene(report);
        //
        
        // Print report button action
        reportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(reportScene);
            }
        });
        //
        
        // Income popup
        Label incomeLabel = new Label("");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(incomeLabel);
        Scene secondScene = new Scene(secondaryLayout, 230, 100);
        Stage newWindow = new Stage();
        newWindow.setTitle("Income");
        newWindow.setScene(secondScene);
        newWindow.setX(primaryStage.getX() + 200);
        newWindow.setY(primaryStage.getY() + 100);
        
        
        // Income button action
        income.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    incomeLabel.setText(BankApplication.getIncome());
                } catch(FileNotFoundException ex) {
                     Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                newWindow.show();
            }
        });
        // Logout button action
         
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
                welcomeText.setText("Logged in as: " + Users.getCurrentUserUsername());
                primaryStage.setScene(welcomeScene);
            }
        });
        //
      
        // Initialization:
        Scene scene = new Scene(grid, 400, 375);
        
        // Back to login page button action:
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(scene);
            }
        });
        //
        
        primaryStage.setScene(scene);
        primaryStage.show();
        //
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
