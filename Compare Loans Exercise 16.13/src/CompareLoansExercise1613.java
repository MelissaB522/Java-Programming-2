
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Class:       Compare Loans Exercise 16.13
 * Developer:   Melissa Bakke
 * Date:        02/19/2017
 * Purpose:     Program allows user to enter loan amount and loan period and displays 
 *              the monthly and total payments for each interest rate from 5-8 percent in eighths.
 */
public class CompareLoansExercise1613 extends Application{
    @Override
    public void start (Stage primaryStage){
        // Create components of the GUI application
        BorderPane pane = new BorderPane();
        TextField tfLoanAmount = new TextField();
        tfLoanAmount.setPrefColumnCount(8);
        TextField tfLoanPeriod = new TextField();
        tfLoanPeriod.setPrefColumnCount(2);
        Button btShow = new Button("Show Table");
        
        // Place label and loan amount textfield in hbox1
        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(5, 5, 5, 5));
        hBox1.getChildren().addAll(new Label("Loan Amount "), tfLoanAmount);
        
        // Place label and loan period textfield in hbox2
        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(5, 5, 5, 5));
        hBox2.getChildren().addAll(new Label("Number of Years "), tfLoanPeriod);
        
        // Place button in hbox3
        HBox hBox3 = new HBox();
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(5, 5, 5, 5));
        hBox3.getChildren().add(btShow);
        
        // Place hbox1, hbox2, hbox3 into hbox4
        HBox hBox4 = new HBox();
        hBox4.getChildren().addAll(hBox1, hBox2, hBox3);
        pane.setTop(hBox4);
        
        // Create textarea, place it in scroll pane, place scroll pane on bottom of main pane
        TextArea taPayments = new TextArea();
        taPayments.setWrapText(true);
        ScrollPane scrollPane = new ScrollPane(taPayments);
        pane.setBottom(scrollPane);        
        
        Scene scene = new Scene(pane, 425, 200);
        primaryStage.setTitle("Compare Loans");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Button action event calls calculatePayment method
        btShow.setOnAction(e -> {
            calculatePayment(tfLoanAmount, tfLoanPeriod, taPayments);
        });
    }
    
    /**calculatePayment gets the loan amount and loan period the user entered in the form 
     * and sends the interests rates to the text area.
     * @param amount
     * @param years
     * @param textArea
    */
    public void calculatePayment(TextField amount, TextField years, TextArea textArea){
        // Enter yearly interest rate start value
        double annualInterestRate = 5.0;
 
        // Printing table header
        textArea.setText("Interest Rate \t Monthly Payment \t Total Payment\n");
 
        while (annualInterestRate <= 8.0) {
            // Obtain monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;
            
            // Variables for the text entered into the GUI form
            double loanAmount = Double.parseDouble(amount.getText());
            int numberOfYears = Integer.parseInt(years.getText());
            
            // Calculate payment
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
            double totalPayment = monthlyPayment * numberOfYears * 12;
            
            // Make a string variable to hold other variables and format it
            String text = String.format("%-25.3f%-25.2f%-25.2f\n", annualInterestRate, monthlyPayment, totalPayment);

            // Display results
            textArea.appendText(text);

            annualInterestRate = annualInterestRate + 1.0 / 8;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
