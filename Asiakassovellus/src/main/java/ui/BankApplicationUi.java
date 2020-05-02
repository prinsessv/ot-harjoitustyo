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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
    Background greyBackground = new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background transparentBackground = new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY));
    Border border = new Border(new BorderStroke(Color.DEEPSKYBLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    Bloom bloom = new Bloom();
    
    
    public void setPane(GridPane gridpane, int size) {
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setMinSize(size, size);
        gridpane.setMaxSize(size, size);
        gridpane.setBackground(greyBackground);
        gridpane.setBorder(border);
    }
    
    public void setTransparentButton(Button button, Color color, int fontSize) {
        button.setTextFill(color);
        button.setFont(Font.font("Cambria", FontWeight.NORMAL, fontSize));
        button.setEffect(bloom);
        button.setBackground(transparentBackground);
    }
    public void setNormalButton(Button button) {
        button.setBorder(border);
    }
   
    public void setLabel(Label label, Color color, int fontSize, boolean effect) {
        label.setFont(Font.font("Cambria", FontWeight.NORMAL, 15));
        label.setTextFill(color);
        
        if(effect) {
            label.setEffect(bloom);
        }
    }
    
    public void setText(Text text, Color color, int fontSize) {
        text.setFont(Font.font("Cambria", FontWeight.NORMAL, 30));
        text.setFill(Color.LIGHTCYAN);
        text.setEffect(bloom);
    }

    @Override
    public void start(Stage primaryStage) {
        
        // Effect used
        bloom.setThreshold(0.1);
        
        // Sign in view:
        primaryStage.setTitle("Accounting");
        
        GridPane firstPage = new GridPane();
        setPane(firstPage, 400);
      
        Text signInText = new Text("Sign In");
        setText(signInText, Color.LIGHTCYAN, 15);
        firstPage.add(signInText, 0, 0, 2, 1);
      
        Label usernameLabel = new Label("Username:");
        setLabel(usernameLabel, Color.LIGHTCYAN, 10, false);
        firstPage.add(usernameLabel, 0, 1);
        
        TextField usernameTextfield = new TextField();
        firstPage.add(usernameTextfield, 1, 1);
        
        Label passwordLabel = new Label("Password:");
        setLabel(passwordLabel, Color.LIGHTCYAN, 10, false);
        firstPage.add(passwordLabel, 0, 2);
        
        PasswordField passwordField = new PasswordField();
        firstPage.add(passwordField, 1, 2);
        
        Button loginButton = new Button("LOGIN");
        setNormalButton(loginButton);
        firstPage.add(loginButton, 1, 4);
        
        Button createNewUserButton = new Button("CREATE NEW USER");
        setNormalButton(createNewUserButton);
        firstPage.add(createNewUserButton, 1, 5);
        
        // Error text appearing on the front page if username/pw is wrong
        final Text errorText = new Text();
        firstPage.add(errorText, 1, 7);
        
        // Form that appears after pressing button CREATE NEW USER:
        GridPane createNewUserForm = new GridPane();
        setPane(createNewUserForm, 500);
      
        Label createNewUserTitle = new Label("You wanted to create new user");
        setLabel(createNewUserTitle, Color.LIGHTCYAN, 15, true);
        createNewUserForm.add(createNewUserTitle, 1 , 0);
        
        Label createUsernameLabel = new Label("Username:");
        setLabel(createUsernameLabel, Color.LIGHTCYAN, 10, false);
        createNewUserForm.add(createUsernameLabel, 0, 1);
        
        TextField createUsernameField = new TextField();
        createNewUserForm.add(createUsernameField, 1, 1);
        
        Label createPasswordLabel = new Label("Password:");
        setLabel(createPasswordLabel, Color.LIGHTCYAN, 10, false);
        createNewUserForm.add(createPasswordLabel, 0, 2);
        
        PasswordField createPasswordField = new PasswordField();
        createNewUserForm.add(createPasswordField, 1, 2);
        
        Label repeatPasswordLabel = new Label("Repeat password:");
        setLabel(repeatPasswordLabel, Color.LIGHTCYAN, 10, false);
        createNewUserForm.add(repeatPasswordLabel, 0, 3);
        
        PasswordField repeatPasswordField = new PasswordField();
        createNewUserForm.add(repeatPasswordField, 1, 3);
        
        Button finalCreateButton = new Button("CREATE");
        setNormalButton(finalCreateButton);
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
        setLabel(usernameOkOrNot, Color.LIGHTCYAN, 12, true);
        createNewUserForm.add(usernameOkOrNot, 1, 7);
        
        Button backToFrontP = new Button("←");
        setTransparentButton(backToFrontP, Color.LIGHTCYAN, 20);
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
        setPane(bankApplicationView, 450);
        
        Label welcomeLabel = new Label("Welcome!");
        setLabel(welcomeLabel, Color.LIGHTCYAN, 22, true);
        bankApplicationView.add(welcomeLabel, 0, 0);
        
        Button incomeButton = new Button("Book income");
        setTransparentButton(incomeButton, Color.LIGHTCYAN, 15);
        bankApplicationView.add(incomeButton, 0, 2);
        
        Button expenseButton = new Button("Book expense");
        setTransparentButton(expenseButton, Color.LIGHTCYAN, 15);
        bankApplicationView.add(expenseButton, 0, 3);
        
        Button reportButton = new Button("Print report");
        setTransparentButton(reportButton, Color.LIGHTCYAN, 15);
        bankApplicationView.add(reportButton, 0, 4);
        
        Button resetButton = new Button("Reset all");
        setNormalButton(resetButton);
        bankApplicationView.add(resetButton, 1, 4);
        
        Button logoutButton = new Button("LOGOUT");
        setNormalButton(logoutButton);
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
        setPane(bookIncomeForm, 450);
        
        Button backToFrontButton = new Button("←");
        setTransparentButton(backToFrontButton, Color.LIGHTCYAN, 20);
        bookIncomeForm.add(backToFrontButton, 0, 0);
        
        Label incomeToBookLabel = new Label("Income to book:");
        setLabel(incomeToBookLabel, Color.LIGHTCYAN, 12, false);
        bookIncomeForm.add(incomeToBookLabel, 0, 1);
        
        TextField bookIncomeField = new TextField();
        bookIncomeForm.add(bookIncomeField, 1, 1);
        
        Button bookItButton = new Button("Book this income");
        setNormalButton(bookItButton);
        bookIncomeForm.add(bookItButton, 1, 2);
        
        Scene bookingIncomeScene = new Scene(bookIncomeForm);
        
        //After book income form
        Label incomeBookedOrNot = new Label("");
        setLabel(incomeBookedOrNot, Color.LIGHTCYAN, 12, true);
        bookIncomeForm.add(incomeBookedOrNot, 1, 3);
        
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
        setPane(bookExpenseForm, 550);
        
        Button backToWelcomeScene = new Button("←");
        setTransparentButton(backToWelcomeScene, Color.LIGHTCYAN, 20);
        bookExpenseForm.add(backToWelcomeScene, 0, 0);

        Label purchaseToBook = new Label("Purchase:");
        setLabel(purchaseToBook, Color.LIGHTCYAN, 12, false);
        bookExpenseForm.add(purchaseToBook, 0, 1);
        
        TextField bookingPurchase = new TextField();
        bookExpenseForm.add(bookingPurchase, 1, 1);
        
        Label purchaseCategoryToBook = new Label("Category:");
        setLabel(purchaseCategoryToBook, Color.LIGHTCYAN, 12, false);
        bookExpenseForm.add(purchaseCategoryToBook, 0, 2);
        
        TextField categoryOfExpense = new TextField();
        bookExpenseForm.add(categoryOfExpense, 1, 2);
        
        Label costToBook = new Label("Cost:");
        setLabel(costToBook, Color.LIGHTCYAN, 12, false);
        bookExpenseForm.add(costToBook, 0, 3);
        
        TextField bookingExpense = new TextField();
        bookExpenseForm.add(bookingExpense, 1, 3);
        
        Button bookPurchaseButton = new Button("Book your purchase");
        setNormalButton(bookPurchaseButton);
        bookExpenseForm.add(bookPurchaseButton, 1, 5);
        
        // If expense was < 0
        Label expenseBookedOrNot = new Label("");
        setLabel(expenseBookedOrNot, Color.LIGHTCYAN, 12, true);
        bookExpenseForm.add(expenseBookedOrNot, 1, 6);
        
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
      
        // bookPurchaseButton action
        bookPurchaseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (Integer.parseInt(bookingExpense.getText()) >= 0) {
                    BankApplication.bookExpense(bookingPurchase.getText(), categoryOfExpense.getText(), Integer.parseInt(bookingExpense.getText()));
                    expenseBookedOrNot.setText("Expense has been booked succesfully.");
                } else {
                    expenseBookedOrNot.setText("Expense can not be negative.");
                }
            }
        }); 
        
        // View after pressing print report button
        GridPane report = new GridPane();
        setPane(report, 450);
        
        Button iDontWantToReadReportsAnymore = new Button("←");
        setTransparentButton(iDontWantToReadReportsAnymore, Color.LIGHTCYAN, 25);
        report.add(iDontWantToReadReportsAnymore, 0, 0);
        
        Button income = new Button("Income");
        setNormalButton(income);
        report.add(income, 1, 1);
        
        Button expenses = new Button("Expenses");
        setNormalButton(expenses);
        report.add(expenses, 1, 2);
        
        Button percent = new Button("Percents used of income");
        setNormalButton(percent);
        report.add(percent, 1, 3);
        
        Button category = new Button("Percents used of income for each category");
        setNormalButton(category);
        report.add(category, 1, 4);
        
        
        iDontWantToReadReportsAnymore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(welcomeScene);
            }
        });
        
        Scene reportScene = new Scene(report);
        
        // Print report button action
        reportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(reportScene);
            }
        });
        
        // ResetButton popup and action
        GridPane resetPane = new GridPane();
        setPane(resetPane, 200);
        
        Button areYouSureButton = new Button("Are you sure you want to reset?");
        resetPane.add(areYouSureButton, 0, 0);
        
        Label resetLabel = new Label("");
        setLabel(resetLabel, Color.LIGHTCYAN, 12, false);
        resetPane.add(resetLabel, 0, 1);
        
        Scene resetScene = new Scene(resetPane, 350, 200);
        Stage resetWindow = new Stage();
        resetWindow.setTitle("Reset");
        resetWindow.setScene(resetScene);
        resetWindow.setX(primaryStage.getX() + 200);
        resetWindow.setY(primaryStage.getY() + 100);
        
        
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                resetWindow.show();
            }
        }); 
        
        areYouSureButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                resetLabel.setText(BankApplication.resetAll());
            }
        });
        
        // Income popup
        GridPane incomePopUp = new GridPane();
        setPane(incomePopUp, 100);
        
        Label incomeLabel = new Label("");
        setLabel(incomeLabel, Color.LIGHTCYAN, 12, false);
        incomePopUp.add(incomeLabel, 1, 0);
        
        Label compareLabel = new Label("");
        setLabel(compareLabel, Color.LIGHTCYAN, 12, false);
        incomePopUp.add(compareLabel, 1, 1);
        
        Scene incomeScene = new Scene(incomePopUp, 470, 420);
        Stage incomeStage = new Stage();
        incomeStage.setScene(incomeScene);
        incomeStage.setTitle("Income");
        
        // Income button action
        income.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    incomeLabel.setText("Your income this month is " + BankApplication.getIncome() + "$.");
                    compareLabel.setText(BankApplication.compareIncomeToAverage());
                } catch(FileNotFoundException ex) {
                     Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                incomeStage.show();
                primaryStage.setScene(reportScene);
            }
        }); 
        
        // Expenses popup
        GridPane expensePopUp = new GridPane();
        setPane(expensePopUp, 100);
        
        Label expensesLabel = new Label("");
        setLabel(expensesLabel, Color.LIGHTCYAN, 12, false);
        expensePopUp.add(expensesLabel, 1, 0);
        
        Label howMuchLeftLabel = new Label("");
        setLabel(howMuchLeftLabel, Color.LIGHTCYAN, 10, false);
        expensePopUp.add(howMuchLeftLabel, 1, 1);
        
        Scene expenseScene = new Scene(expensePopUp, 450, 400);
        Stage expensesStage = new Stage();
        expensesStage.setScene(expenseScene);
        expensesStage.setTitle("Expenses");
        
        // Expenses button action
        expenses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    expensesLabel.setText("You have used " + BankApplication.getExpenses() +  "$ this month.");
                    howMuchLeftLabel.setText(BankApplication.howMuchIncomeLeft());
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                expensesStage.show();
                primaryStage.setScene(reportScene);
            }
        });
        
        // Percent popup
        Label percentLabel = new Label("");
        setLabel(percentLabel, Color.LIGHTCYAN, 12, false);
        GridPane percentPopUp = new GridPane();
        setPane(percentPopUp, 200);
        percentPopUp.getChildren().add(percentLabel);
        Scene percentScene = new Scene(percentPopUp, 450, 400);
        Stage percentStage = new Stage();
        percentStage.setScene(percentScene);
        percentStage.setTitle("Percent of income used");
        
        // Percent button action
        percent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    percentLabel.setText("You have used " + BankApplication.percentUsedOfIncome() + "% of your income this month");
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                percentStage.show();
                primaryStage.setScene(reportScene);
            }
        });
        
        // Form opening after pressing percents used of each category
        GridPane percentUsedForEachCategory = new GridPane();
        setPane(percentUsedForEachCategory, 300);
        
        Label whichCategoryLabel = new Label("Category: ");
        setLabel(whichCategoryLabel, Color.LIGHTCYAN, 12, false);
        percentUsedForEachCategory.add(whichCategoryLabel, 0, 1);
        
        TextField categoryField = new TextField();
        percentUsedForEachCategory.add(categoryField, 1, 1);
        
        Button getReportForThisCategory = new Button("Get report");
        setNormalButton(getReportForThisCategory);
        percentUsedForEachCategory.add(getReportForThisCategory, 1, 2);
        
        Scene percentUsedForEachCategoryScene = new Scene(percentUsedForEachCategory);
        
        // Category button action
        category.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               primaryStage.setScene(percentUsedForEachCategoryScene);
            }
        });
        
        // Percent per category popup
        Label categoryPercentLabel = new Label("");
        setLabel(categoryPercentLabel, Color.LIGHTCYAN, 12, false);
        GridPane categoryPercentPopUp = new GridPane();
        setPane(categoryPercentPopUp, 200);
        categoryPercentPopUp.getChildren().add(categoryPercentLabel);
        Scene categoryPercentScene = new Scene(categoryPercentPopUp, 650, 600);
        Stage categoryPercentStage = new Stage();
        categoryPercentStage.setScene(categoryPercentScene);
        categoryPercentStage.setTitle("Percent of income used to each category");
        
        // getReportForThisCategory button action
        getReportForThisCategory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    primaryStage.setScene(reportScene);
                    categoryPercentLabel.setText(BankApplication.percentsUsedOfIncomeForEachCategory(categoryField.getText()));
                } catch(Exception ex) {
                    Logger.getLogger(BankApplicationUi.class.getName()).log(Level.SEVERE, null, ex);
                }
                categoryPercentStage.show();
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