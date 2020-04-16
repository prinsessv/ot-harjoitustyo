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
        
        // Sign in view:
        primaryStage.setTitle("Accounting");
      
        GridPane firstPage = new GridPane();
        firstPage.setAlignment(Pos.CENTER);
        firstPage.setHgap(10);
        firstPage.setVgap(10);
        firstPage.setPadding(new Insets(25, 25, 25, 25));
      
        Text signInText = new Text("Sign In");
        signInText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        firstPage.add(signInText, 0, 0, 2, 1);
      
        Label usernameLabel = new Label("Username:");
        firstPage.add(usernameLabel, 0, 1);
        TextField usernameTextfield = new TextField();
        firstPage.add(usernameTextfield, 1, 1);
        
        Label passwordLabel = new Label("Password: ");
        firstPage.add(passwordLabel, 0, 2);
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
        GridPane createNewUserForm = new GridPane();
        createNewUserForm.setAlignment(Pos.CENTER);
        createNewUserForm.setHgap(10);
        createNewUserForm.setVgap(10);
        createNewUserForm.setPadding(new Insets(25, 25, 25, 25));
      
        Text createNewUserTitle = new Text("You wanted to create new user");
        createNewUserTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        createNewUserForm.add(createNewUserTitle, 0, 0, 2, 1);
        
        Label createUsernameLabel = new Label("Username:");
        createNewUserForm.add(createUsernameLabel, 0, 1);
        TextField createUsernameField = new TextField();
        createNewUserForm.add(createUsernameField, 1, 1);
        
        Label createPasswordLabel = new Label("Password:");
        createNewUserForm.add(createPasswordLabel, 0, 2);
        PasswordField createPasswordField = new PasswordField();
        createNewUserForm.add(createPasswordField, 1, 2);
        
        Label repeatPasswordLabel = new Label("Repeat password:");
        createNewUserForm.add(repeatPasswordLabel, 0, 3);
        PasswordField repeatPasswordField = new PasswordField();
        createNewUserForm.add(repeatPasswordField, 1, 3);
        
        Button finalCreateButton = new Button("CREATE");
        createNewUserForm.add(finalCreateButton, 1, 4);
        
        Scene createNewUserScene = new Scene(createNewUserForm);
        
        // CREATE-NEW-USER button action
        createNewUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createNewUserScene);
            }
        });
        
        // View after filling the CREATE NEW USER form and pressing CREATE button
        GridPane accountMadeSuccessfully = new GridPane();
        accountMadeSuccessfully.setAlignment(Pos.CENTER);
        accountMadeSuccessfully.setHgap(10);
        accountMadeSuccessfully.setVgap(10);
        accountMadeSuccessfully.setPadding(new Insets(25, 25, 25, 25));
        
        Text successText = new Text("New account has been made successfully");
        successText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        accountMadeSuccessfully.add(successText, 0, 0, 2, 1);
        
        Button backToLoginButton = new Button("Back to login page");
        accountMadeSuccessfully.add(backToLoginButton, 1, 1);
        
        Scene accountMadeSuccessfullyScene = new Scene(accountMadeSuccessfully);
        
        // CREATE button action:
        finalCreateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String username = createUsernameField.getText();
                String passw = createPasswordField.getText();
                try {
                    successText.setText(Users.createNewUser(username, passw));
                    primaryStage.setScene(accountMadeSuccessfullyScene);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // View after successfull LOGIN:
        GridPane bankApplicationView = new GridPane();
        bankApplicationView.setAlignment(Pos.CENTER);
        bankApplicationView.setHgap(10);
        bankApplicationView.setVgap(10);
        bankApplicationView.setPadding(new Insets(25, 25, 25, 25));
        
        Label welcomeLabel = new Label("Welcome!");
        welcomeLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        bankApplicationView.add(welcomeLabel, 0, 0, 2, 1);
        
        Button incomeButton = new Button("Book income");
        incomeButton.setStyle("-fx-background-color: white; ");
        bankApplicationView.add(incomeButton, 0, 4);
        
        Button expenseButton = new Button("Book expense");
        expenseButton.setStyle("-fx-background-color: white; ");
        bankApplicationView.add(expenseButton, 0, 5);
        
        Button reportButton = new Button("Print report");
        reportButton.setStyle("-fx-background-color: white; ");
        bankApplicationView.add(reportButton, 0, 6);
        
        Button resetButton = new Button("Reset all");
        resetButton.setStyle("-fx-background-color: silver; ");
        bankApplicationView.add(resetButton, 0, 8);
        
        Button logoutButton = new Button("LOGOUT");
        logoutButton.setStyle("-fx-background-color: white; ");
        bankApplicationView.add(logoutButton, 0, 1, 1, 1); 
        
        Scene welcomeScene = new Scene(bankApplicationView);
        
        // LOGIN button action:
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    System.out.println(usernameTextfield.getText()+","+passwordField.getText());
                    if(Users.findUser(usernameTextfield.getText(), passwordField.getText()) == null) {
                        errorText.setFill(Color.FIREBRICK);
                        errorText.setText("Wrong username or password");
                        return;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                welcomeLabel.setText("Logged in as: " + Users.getCurrentUserUsername());
                primaryStage.setScene(welcomeScene);
            }
        });

        // Book income button opens a form
        GridPane bookIncomeForm = new GridPane();
        bookIncomeForm.setAlignment(Pos.CENTER);
        bookIncomeForm.setHgap(10);
        bookIncomeForm.setVgap(10);
        bookIncomeForm.setPadding(new Insets(25, 25, 25, 25));
        
        Label incomeToBookLabel = new Label("Income to book: ");
        TextField bookIncomeField = new TextField();
        
        bookIncomeForm.add(incomeToBookLabel, 0, 0);
        bookIncomeForm.add(bookIncomeField, 1, 0);
        
        Button bookItButton = new Button("Book this income");
        bookIncomeForm.add(bookItButton, 1, 1);
        
        Scene bookingIncomeScene = new Scene(bookIncomeForm);
        
        //After book income form
        GridPane incomeBookedSuccessfully = new GridPane();
        incomeBookedSuccessfully.setAlignment(Pos.CENTER);
        incomeBookedSuccessfully.setHgap(10);
        incomeBookedSuccessfully.setVgap(10);
        incomeBookedSuccessfully.setPadding(new Insets(25, 25, 25, 25));
        
        Label incomeBookedLabel = new Label("Income has been booked succesfully.");
        incomeBookedSuccessfully.add(incomeBookedLabel, 0, 0);
        
        Button backToFrontButton = new Button("Back to front page");
        backToFrontButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        incomeBookedSuccessfully.add(backToFrontButton, 0, 1);
        
        Scene incomeIsBookedScene = new Scene(incomeBookedSuccessfully);
        
        // If income was <= 0
        GridPane incomeNotBookedSuccessfully = new GridPane();
        incomeNotBookedSuccessfully.setAlignment(Pos.CENTER);
        incomeNotBookedSuccessfully.setHgap(10);
        incomeNotBookedSuccessfully.setVgap(10);
        incomeNotBookedSuccessfully.setPadding(new Insets(25, 25, 25, 25));
        
        Label incomeNotBookedLabel = new Label("Income has not been booked succesfully. Income can not be negative or zero.");
        incomeNotBookedSuccessfully.add(incomeNotBookedLabel, 0, 0);
        
        Button backToPreviousPage = new Button("Back to previous page");
        backToPreviousPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        incomeNotBookedSuccessfully.add(backToPreviousPage, 0, 1);
        
        Scene incomeNotBookedScene = new Scene(incomeNotBookedSuccessfully);
       
        // bookIncome button action
        incomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(bookingIncomeScene);
            }
        });
        
        // Book it button action
        bookItButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Integer.parseInt(bookIncomeField.getText()) > 0) {
                    BankApplication.bookIncome(Integer.parseInt(bookIncomeField.getText()));
                    primaryStage.setScene(incomeIsBookedScene);
                } else {
                    primaryStage.setScene(incomeNotBookedScene);
                }
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
        
        Scene expensesToBookScene = new Scene(bookExpenseForm);
        
        // Book expense button action
        expenseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(expensesToBookScene);
            }
        });
        
        // backToWelcomeScene button action
        backToWelcomeScene.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        // If expense was < 0
        GridPane expenseNotBookedSuccessfully = new GridPane();
        expenseNotBookedSuccessfully.setAlignment(Pos.CENTER);
        expenseNotBookedSuccessfully.setHgap(10);
        expenseNotBookedSuccessfully.setVgap(10);
        expenseNotBookedSuccessfully.setPadding(new Insets(25, 25, 25, 25));
        
        Label expenseNotBookedLabel = new Label("Expense has not been booked succesfully. Expense can not be negative.");
        expenseNotBookedSuccessfully.add(expenseNotBookedLabel, 0, 0);
        
        Button backToPreviousSite = new Button("Back to previous page");
        backToPreviousSite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        expenseNotBookedSuccessfully.add(backToPreviousSite, 0, 1);
        
        Scene expenseNotBookedScene = new Scene(expenseNotBookedSuccessfully);
        
        // Scene after booking expense
        GridPane expenseBooked = new GridPane();
        expenseBooked.setAlignment(Pos.CENTER);
        expenseBooked.setHgap(10);
        expenseBooked.setVgap(10);
        expenseBooked.setPadding(new Insets(25, 25, 25, 25));
        
        Label expenseBookedSuccessfully = new Label("Expense has been booked succesfully.");
        expenseBooked.add(expenseBookedSuccessfully, 0, 0);
        
        Button backToFrontPage = new Button("Back to front page");
        
        backToFrontPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        expenseBooked.add(backToFrontPage, 0, 1);
        
        Scene expenseIsBooked = new Scene(expenseBooked);
        
        // bookPurchaseButton action
        bookPurchaseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Integer.parseInt(bookingExpense.getText()) >= 0) {
                    BankApplication.bookExpense(bookingPurchase.getText(), categoryOfExpense.getText(), Integer.parseInt(bookingExpense.getText()));
                    primaryStage.setScene(expenseIsBooked);
                } else {
                    primaryStage.setScene(expenseNotBookedScene);
                }
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
        
        Button iDontWantToReadReportsAnymore = new Button("Back to front page");
        
        iDontWantToReadReportsAnymore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        report.add(iDontWantToReadReportsAnymore, 0, 5);
        
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
        Stage incomeWindow = new Stage();
        incomeWindow.setTitle("Income");
        incomeWindow.setScene(secondScene);
        incomeWindow.setX(primaryStage.getX() + 200);
        incomeWindow.setY(primaryStage.getY() + 100);
        
        // Income button action
        income.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    incomeLabel.setText("Your income this month is " + BankApplication.getIncome() + "$");
                } catch(FileNotFoundException ex) {
                     Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                incomeWindow.show();
                primaryStage.setScene(reportScene);
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
                    expenseLabel.setText("You have used " + BankApplication.getExpenses() +  "$ this month");
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                expenseWindow.show();
                primaryStage.setScene(reportScene);
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
                    percentLabel.setText("You have used " + BankApplication.percentUsedOfIncome() + "% of your income this month");
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                percentWindow.show();
                primaryStage.setScene(reportScene);
            }
        });
        
        // Form opening after pressing percents used of each category
        GridPane percentUsedForEachCategory = new GridPane();
        percentUsedForEachCategory.setAlignment(Pos.CENTER);
        percentUsedForEachCategory.setHgap(10);
        percentUsedForEachCategory.setVgap(10);
        percentUsedForEachCategory.setPadding(new Insets(25, 25, 25, 25));
        
        Label whichCategoryLabel = new Label("Category: ");
        welcomeLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        percentUsedForEachCategory.add(whichCategoryLabel, 0, 1);
        
        TextField categoryField = new TextField();
        percentUsedForEachCategory.add(categoryField, 1, 1);
        
        Button getReportForThisCategory = new Button("Get report");
        percentUsedForEachCategory.add(getReportForThisCategory, 2, 2);
        
        Scene percentUsedForEachCategoryScene = new Scene(percentUsedForEachCategory);
        
        // Category button action
        category.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               primaryStage.setScene(percentUsedForEachCategoryScene);
            }
        });
        
        // Percent used to this category report POPUP window
        Label percentForThisCategoryLabel = new Label("");
        StackPane percentForThisCategoryLayout = new StackPane();
        percentForThisCategoryLayout.getChildren().add(percentForThisCategoryLabel);
        Scene percentForThisCategoryScene = new Scene(percentForThisCategoryLayout, 230, 100);
        Stage percentForThisCategoryWindow = new Stage();
        percentForThisCategoryWindow.setTitle("Percentage used");
        percentForThisCategoryWindow.setScene(percentForThisCategoryScene);
        percentForThisCategoryWindow.setX(primaryStage.getX() + 200);
        percentForThisCategoryWindow.setY(primaryStage.getY() + 100);
        
        // getReportForThisCategory button action
        getReportForThisCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    percentForThisCategoryLabel.setText(BankApplication.percentsUsedOfIncomeForEachCategory(categoryField.getText()));
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                percentForThisCategoryWindow.show();
                primaryStage.setScene(reportScene);
            }
        });
   
        // Main scene
        Scene firstPageScene = new Scene(firstPage, 400, 375);
        
        // Logout button action
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(firstPageScene);
            }
        });
        
        // Back to login page button action:
        backToLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(firstPageScene);
            }
        });
        //
        
        primaryStage.setScene(firstPageScene);
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
