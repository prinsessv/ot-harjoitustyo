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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        
        // View after successfull LOGIN:
        GridPane bankApplicationView = new GridPane();
        bankApplicationView.setAlignment(Pos.CENTER);
        bankApplicationView.setHgap(10);
        bankApplicationView.setVgap(10);
        bankApplicationView.setPadding(new Insets(25, 25, 25, 25));
        
        Label welcomeText = new Label("Welcome!");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        bankApplicationView.add(welcomeText, 0, 0, 2, 1);
        
        Button incomeButton = new Button("Book income");
        bankApplicationView.add(incomeButton, 0, 4);
        Button expenseButton = new Button("Book expense");
        bankApplicationView.add(expenseButton, 0, 5);
        Button reportButton = new Button("Print report");
        bankApplicationView.add(reportButton, 0, 10);
        Button resetButton = new Button("Reset all");
        bankApplicationView.add(resetButton, 0, 11);
        Button logoutButton = new Button("LOGOUT");
        logoutButton.setStyle("-fx-background-color: white; ");
        bankApplicationView.add(logoutButton, 0, 1, 1, 1); 
        
        Scene welcomeScene = new Scene(bankApplicationView);
        
        // Important button in almost every view
        Button backToFrontPage = new Button("Back to front page");
        
        //Back to front page button action
        backToFrontPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });

        // Sign in view:
        primaryStage.setTitle("Accounting");
      
        GridPane firstPage = new GridPane();
        firstPage.setAlignment(Pos.CENTER);
        firstPage.setHgap(10);
        firstPage.setVgap(10);
        firstPage.setPadding(new Insets(25, 25, 25, 25));
      
        Text scenetitle = new Text("Sign In");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        firstPage.add(scenetitle, 0, 0, 2, 1);
      
        Label username = new Label("Username:");
        firstPage.add(username, 0, 1);
        TextField userTextfield = new TextField();
        firstPage.add(userTextfield, 1, 1);
        
        Label password = new Label("Password: ");
        firstPage.add(password, 0, 2);
        PasswordField passwordField = new PasswordField();
        firstPage.add(passwordField, 1, 2);
        
        Button loginButton = new Button("LOGIN");
        firstPage.add(loginButton, 1, 4);
        
        Button createNewUserButton = new Button("CREATE NEW USER");
        firstPage.add(createNewUserButton, 1, 5);
        
        // Error text appearing on the front page if username/pw is wrong
        final Text errorText = new Text();
        firstPage.add(errorText, 1, 7);
        
        // Form that appears after pressing button CREATE NEW USER:
        GridPane createNewUser = new GridPane();
        createNewUser.setAlignment(Pos.CENTER);
        createNewUser.setHgap(10);
        createNewUser.setVgap(10);
        createNewUser.setPadding(new Insets(25, 25, 25, 25));
      
        Text createNewUserTitle = new Text("You wanted to create new user");
        createNewUserTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        createNewUser.add(createNewUserTitle, 0, 0, 2, 1);
        
        Label createUsername = new Label("Username:");
        createNewUser.add(createUsername, 0, 1);
        TextField createUsernameField = new TextField();
        createNewUser.add(createUsernameField, 1, 1);
        
        Label createPassword = new Label("Password:");
        createNewUser.add(createPassword, 0, 2);
        PasswordField createPasswordField = new PasswordField();
        createNewUser.add(createPasswordField, 1, 2);
        
        Label repeatThatPassword = new Label("Repeat password:");
        createNewUser.add(repeatThatPassword, 0, 3);
        PasswordField repeatThatPasswordField = new PasswordField();
        createNewUser.add(repeatThatPasswordField, 1, 3);
        
        Button finalCreateButton = new Button("CREATE");
        createNewUser.add(finalCreateButton, 1, 4);
        
        Scene createScene = new Scene(createNewUser);
        
        // CREATE-NEW-USER button action
        createNewUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createScene);
            }
        });
        
        // View after filling the CREATE NEW USER form and pressing CREATE button
        GridPane accountMadeSuccessfully = new GridPane();
        accountMadeSuccessfully.setAlignment(Pos.CENTER);
        accountMadeSuccessfully.setHgap(10);
        accountMadeSuccessfully.setVgap(10);
        accountMadeSuccessfully.setPadding(new Insets(25, 25, 25, 25));
        
        Text success = new Text("New account has been made successfully");
        success.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        accountMadeSuccessfully.add(success, 0, 0, 2, 1);
        
        Button back = new Button("Back to login page");
        accountMadeSuccessfully.add(back, 1, 1);
        
        Scene newScene = new Scene(accountMadeSuccessfully);
        
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
        
        //Book income button opens a form
        GridPane bookIncomeForm = new GridPane();
        bookIncomeForm.setAlignment(Pos.CENTER);
        bookIncomeForm.setHgap(10);
        bookIncomeForm.setVgap(10);
        bookIncomeForm.setPadding(new Insets(25, 25, 25, 25));
        
        Label incomeToBook = new Label("Income to book: ");
        TextField bookingIncome = new TextField();
        
        bookIncomeForm.add(incomeToBook, 0, 0);
        bookIncomeForm.add(bookingIncome, 1, 0);
        
        Button bookIt = new Button("Book this income");
        bookIncomeForm.add(bookIt, 1, 1);
        
        Scene bookingIncomeScene = new Scene(bookIncomeForm);
        
        //After book income form
        GridPane incomeBookedSuccessfully = new GridPane();
        incomeBookedSuccessfully.setAlignment(Pos.CENTER);
        incomeBookedSuccessfully.setHgap(10);
        incomeBookedSuccessfully.setVgap(10);
        incomeBookedSuccessfully.setPadding(new Insets(25, 25, 25, 25));
        
        Label incomeBookedLabel = new Label("Income has been booked succesfully.");
        incomeBookedSuccessfully.add(incomeBookedLabel, 0, 0, 1, 1);
        incomeBookedSuccessfully.add(backToFrontPage, 1, 0, 1, 1);
        
        Scene incomeIsBooked = new Scene(incomeBookedSuccessfully);
       
        // bookIncome button action
        incomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(bookingIncomeScene);
            }
        });
        
        // Book it button action
        bookIt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                BankApplication.bookIncome(Integer.parseInt(bookingIncome.getText()));
                primaryStage.setScene(incomeIsBooked);
            }
        });
        
        //Book expense form
        GridPane bookExpenseForm = new GridPane();
        bookExpenseForm.setAlignment(Pos.CENTER);
        bookExpenseForm.setHgap(10);
        bookExpenseForm.setVgap(10);
        bookExpenseForm.setPadding(new Insets(25, 25, 25, 25));
        
        Label purchaseToBook = new Label("Purchase:");
        TextField bookingPurchase = new TextField();
        
        Label purchaseCategoryToBook = new Label("Category:");
        TextField categoryOfExpense = new TextField();
        
        Label costToBook = new Label("Cost:");
        TextField bookingExpense = new TextField();
        
        bookExpenseForm.add(purchaseToBook, 0, 0);
        bookExpenseForm.add(bookingPurchase, 1, 0);
        bookExpenseForm.add(purchaseCategoryToBook, 0, 1);
        bookExpenseForm.add(categoryOfExpense, 1, 1);
        bookExpenseForm.add(costToBook, 0, 2);
        bookExpenseForm.add(bookingExpense, 1, 2);
        
        Button bookPurchaseButton = new Button("Book your purchase");
        bookExpenseForm.add(bookPurchaseButton, 0, 3);
        Button backToWelcomeScene = new Button("Back");
        bookExpenseForm.add(backToWelcomeScene, 0, 4);
        
        Scene expensesToBook = new Scene(bookExpenseForm);
        
        // Book expense button action
        expenseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(expensesToBook);
            }
        });
        
        // backToWelcomeScene button action
        backToWelcomeScene.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        // Scene after booking expense
        GridPane expenseBooked = new GridPane();
        expenseBooked.setAlignment(Pos.CENTER);
        expenseBooked.setHgap(10);
        expenseBooked.setVgap(10);
        expenseBooked.setPadding(new Insets(25, 25, 25, 25));
        
        Label expenseBookedSuccessfully = new Label("Expense has been booked succesfully.");
        
        expenseBooked.add(expenseBookedSuccessfully, 0, 0);
        expenseBooked.add(backToFrontPage, 0, 1);
        
        Scene expenseIsBooked = new Scene(expenseBooked);
        
        // bookPurchaseButton action
        bookPurchaseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                BankApplication.bookExpense(bookingPurchase.getText(), categoryOfExpense.getText(), Integer.parseInt(bookingExpense.getText()));
                primaryStage.setScene(expenseIsBooked);
            }
        }); 
        
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
        
        // Print report button action
        reportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(reportScene);
            }
        });
        
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
        
        // Expense popup
        Label expenseLabel = new Label("");
        StackPane expenseLayout = new StackPane();
        expenseLayout.getChildren().add(expenseLabel);
        Scene expenseScene = new Scene(expenseLayout, 230, 100);
        Stage expenseWindow = new Stage();
        expenseWindow.setTitle("Expenses");
        expenseWindow.setScene(expenseScene);
        expenseWindow.setX(primaryStage.getX() + 200);
        expenseWindow.setY(primaryStage.getY() + 100);
        
        // Expenses button action
        expenses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    expenseLabel.setText(BankApplication.getExpenses());
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                expenseWindow.show();
            }
        }); 
        
        // Percent used of income popup
        Label percentLabel = new Label("0%");
        StackPane percentLayout = new StackPane();
        percentLayout.getChildren().add(percentLabel);
        Scene percentScene = new Scene(percentLayout, 230, 100);
        Stage percentWindow = new Stage();
        percentWindow.setTitle(("Percent used of income"));
        percentWindow.setScene(percentScene);
        percentWindow.setX(primaryStage.getX() + 200);
        percentWindow.setY(primaryStage.getY() + 100);
        
        // Percent button action
        percent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    percentLabel.setText(BankApplication.percentUsedOfIncome() + "%");
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                percentWindow.show();
            }
        });
        
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
      
        // Main scene
        Scene scene = new Scene(firstPage, 400, 375);
        
        // Logout button action
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(scene);
            }
        });
        
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
