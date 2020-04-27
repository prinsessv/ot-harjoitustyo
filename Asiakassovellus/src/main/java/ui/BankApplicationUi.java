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
import javafx.scene.effect.Bloom;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
        firstPage.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.1);
      
        Text signInText = new Text("Sign In");
        signInText.setFont(Font.font("Cambria", FontWeight.NORMAL, 30));
        signInText.setFill(Color.LIGHTCYAN);
        signInText.setEffect(bloom);
        firstPage.add(signInText, 0, 0, 2, 1);
      
        Label usernameLabel = new Label("Username:");
        usernameLabel.setFont(Font.font("Cambria", FontWeight.NORMAL, 15));
        usernameLabel.setTextFill(Color.LIGHTCYAN);
        usernameLabel.setEffect(bloom);
        firstPage.add(usernameLabel, 0, 1);
        TextField usernameTextfield = new TextField();
        firstPage.add(usernameTextfield, 1, 1);
        
        Label passwordLabel = new Label("Password: ");
        passwordLabel.setFont(Font.font("Cambria", FontWeight.NORMAL, 15));
        passwordLabel.setTextFill(Color.LIGHTCYAN);
        passwordLabel.setEffect(bloom);
        firstPage.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        firstPage.add(passwordField, 1, 2);
        
        Button loginButton = new Button("LOGIN");
        loginButton.setTextFill(Color.LIGHTCYAN);
        loginButton.setEffect(bloom);
        loginButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        firstPage.add(loginButton, 1, 4);
        
        Button createNewUserButton = new Button("CREATE NEW USER");
        createNewUserButton.setTextFill(Color.LIGHTCYAN);
        createNewUserButton.setEffect(bloom);
        createNewUserButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        firstPage.add(createNewUserButton, 1, 5);
        
        // Error text appearing on the front page if username/pw is wrong
        final Text errorText = new Text();
        firstPage.add(errorText, 1, 7);
        
        // Form that appears after pressing button CREATE NEW USER:
        GridPane createNewUserForm = new GridPane();
        createNewUserForm.setAlignment(Pos.CENTER);
        createNewUserForm.setHgap(10);
        createNewUserForm.setVgap(10);
        createNewUserForm.setMinSize(450, 320);
        createNewUserForm.setMaxSize(450, 320);
        createNewUserForm.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
      
        Label createNewUserTitle = new Label("You wanted to create new user");
        createNewUserTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        createNewUserTitle.setTextFill(Color.LIGHTCYAN);
        createNewUserTitle.setEffect(bloom);
        createNewUserForm.add(createNewUserTitle, 1 , 0);
        
        Label createUsernameLabel = new Label("Username:");
        createUsernameLabel.setTextFill(Color.LIGHTCYAN);
        createNewUserForm.add(createUsernameLabel, 0, 1);
        TextField createUsernameField = new TextField();
        createNewUserForm.add(createUsernameField, 1, 1);
        
        Label createPasswordLabel = new Label("Password:");
        createPasswordLabel.setTextFill(Color.LIGHTCYAN);
        createNewUserForm.add(createPasswordLabel, 0, 2);
        PasswordField createPasswordField = new PasswordField();
        createNewUserForm.add(createPasswordField, 1, 2);
        
        Label repeatPasswordLabel = new Label("Repeat password:");
        repeatPasswordLabel.setTextFill(Color.LIGHTCYAN);
        createNewUserForm.add(repeatPasswordLabel, 0, 3);
        PasswordField repeatPasswordField = new PasswordField();
        createNewUserForm.add(repeatPasswordField, 1, 3);
        
        Button finalCreateButton = new Button("CREATE");
        finalCreateButton.setTextFill(Color.LIGHTCYAN);
        finalCreateButton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        createNewUserForm.add(finalCreateButton, 1, 5);
        
        Scene createNewUserScene = new Scene(createNewUserForm);
        
        // CREATE-NEW-USER button action
        createNewUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(createNewUserScene);
            }
        });
        
        // Label that tells if username is taken or not:
        Label usernameOkOrNot = new Label("");
        usernameOkOrNot.setTextFill(Color.LIGHTCYAN);
        createNewUserForm.add(usernameOkOrNot, 1, 7);
        
        Button backToFrontP = new Button("←");
        backToFrontP.setTextFill(Color.LIGHTCYAN);
        backToFrontP.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        createNewUserForm.add(backToFrontP, 0, 0);
        
        // CREATE button action:
        finalCreateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String username = createUsernameField.getText();
                String passw = createPasswordField.getText();
                try {
                    usernameOkOrNot.setText(Users.createNewUser(username, passw));
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
        bankApplicationView.setMinSize(300, 300);
        bankApplicationView.setMaxSize(300, 300);
        bankApplicationView.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Label welcomeLabel = new Label("Welcome!");
        welcomeLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        welcomeLabel.setTextFill(Color.LIGHTCYAN);
        bankApplicationView.add(welcomeLabel, 0, 0);
        
        Button incomeButton = new Button("Book income");
        incomeButton.setStyle("-fx-background-color: silver; ");
        incomeButton.setTextFill(Color.LIGHTCYAN);
        bankApplicationView.add(incomeButton, 0, 2);
        
        Button expenseButton = new Button("Book expense");
        expenseButton.setStyle("-fx-background-color: silver; ");
        expenseButton.setTextFill(Color.LIGHTCYAN);
        bankApplicationView.add(expenseButton, 0, 3);
        
        Button reportButton = new Button("Print report");
        reportButton.setStyle("-fx-background-color: silver; ");
        reportButton.setTextFill(Color.LIGHTCYAN);
        bankApplicationView.add(reportButton, 0, 4);
        
        Button resetButton = new Button("Reset all");
        resetButton.setStyle("-fx-background-color: silver; ");
        resetButton.setTextFill(Color.LIGHTCYAN);
        bankApplicationView.add(resetButton, 1, 4);
        
        Button logoutButton = new Button("LOGOUT");
        logoutButton.setStyle("-fx-background-color: silver; ");
        logoutButton.setTextFill(Color.LIGHTCYAN);
        bankApplicationView.add(logoutButton, 1, 0); 
        
        Scene welcomeScene = new Scene(bankApplicationView);
        
        // LOGIN button action:
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
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
        bookIncomeForm.setMinSize(450, 350);
        bookIncomeForm.setMaxSize(450, 350);
        bookIncomeForm.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        Label incomeToBookLabel = new Label("Income to book: ");
        incomeToBookLabel.setTextFill(Color.LIGHTCYAN);
        TextField bookIncomeField = new TextField();
        bookIncomeForm.add(incomeToBookLabel, 0, 1);
        bookIncomeForm.add(bookIncomeField, 1, 1);
        
        Button bookItButton = new Button("Book this income");
        bookItButton.setTextFill(Color.LIGHTCYAN);
        bookIncomeForm.add(bookItButton, 1, 2);
        
        Scene bookingIncomeScene = new Scene(bookIncomeForm);
        
        //After book income form
        Label incomeBookedOrNot = new Label("");
        incomeBookedOrNot.setTextFill(Color.LIGHTCYAN);
        bookIncomeForm.add(incomeBookedOrNot, 1, 3);
        
        Button backToFrontButton = new Button("←");
        backToFrontButton.setTextFill(Color.LIGHTCYAN);
        backToFrontButton.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
        bookIncomeForm.add(backToFrontButton, 0, 0);
        
        backToFrontButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
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
                    incomeBookedOrNot.setText("Income has been booked successfully.");
                } else {
                    incomeBookedOrNot.setText("Income can not be negative or zero.");
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
        
        // ResetButton popup and action
        Label resetLabel = new Label("");
        StackPane resetPane = new StackPane();
        resetPane.getChildren().add(resetLabel);
        Scene resetScene = new Scene(resetPane, 230, 100);
        Stage resetWindow = new Stage();
        resetWindow.setTitle("Reset");
        resetWindow.setScene(resetScene);
        resetWindow.setX(primaryStage.getX() + 200);
        resetWindow.setY(primaryStage.getY() + 100);
        
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                resetLabel.setText(BankApplication.resetAll());
                resetWindow.show();
                primaryStage.setScene(welcomeScene);
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
        
        backToFrontP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(firstPageScene);
            }
        });
        
        // Logout button action
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
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