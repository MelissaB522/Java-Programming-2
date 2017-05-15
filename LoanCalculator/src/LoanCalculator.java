import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class LoanCalculator extends JFrame {
	private JTextField jtfAmount = new JTextField(10);						//make loan input amount text field
	private JTextField jtfYears = new JTextField(10);						//make loan input length text field
	private JButton jbShowTable = new JButton("Show Table");				//make button to display loan table
	JTextArea jtaPaymentDisplay = new JTextArea(26, 30);					//make text area to display loan table
	
	//run it
	public static void main(String[] args){
		LoanCalculator frame = new LoanCalculator();							//make the frame
		frame.pack();													//pack the frame
		frame.setTitle("The Loan Machine");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}
	
	//no arg constructor
	LoanCalculator(){
		JPanel jpAmountandTimeField = new JPanel ();							//make panel for input area
		jpAmountandTimeField.setLayout(new GridLayout(1 ,5));					//set layout
		jpAmountandTimeField.add(new JLabel("Load amount: "));					//make loan amount label
		jpAmountandTimeField.add(jtfAmount);									//add loan amount text field
		jpAmountandTimeField.add(new JLabel("Number Of Years: "));				//make length label
		jpAmountandTimeField.add(jtfYears);										//add loan length text field							
		jpAmountandTimeField.add(jbShowTable);									//add calculator button
		add(jpAmountandTimeField, BorderLayout.NORTH);							//add input panel to frame
		
		JScrollPane scrollPane = new JScrollPane(jtaPaymentDisplay);
		add(scrollPane, BorderLayout.CENTER);							//add text area to frame
		jtaPaymentDisplay.setEditable(false);									//make text editable
		
		//register listeners show table button
		jbShowTable.addActionListener(new ActionListener(){				//listener for bold
			@Override
			public void actionPerformed(ActionEvent e) {
				calculatePayments();
			}
		});
	}
	
		void calculatePayments(){
			double payment;
			double principle;
			int length;
			double paymenttotal;
			
			//jtaPaymentDisplay.setText(null);
			jtaPaymentDisplay.append(String.format("%-30s%-30s%-30s" , "InterestRate", "Monthly Payment",  "Total Payment"));  //write the top row
			
			for(double rate = (0.05/12) ; rate <= (0.08/12); rate = rate + (0.00125/12)){
			principle = Integer.parseInt(jtfAmount.getText());
			length = (Integer.parseInt(jtfYears.getText())*12);
			payment = (principle * rate)/(1 - (1 / Math.pow((1 + rate), length)));
			paymenttotal = payment*length;
			
			jtaPaymentDisplay.append("\n");
			jtaPaymentDisplay.append(String.format("%-35.3f%-39.2f%-39.2f", (rate*12*100), payment, paymenttotal));
			}
			
		}
		
}


