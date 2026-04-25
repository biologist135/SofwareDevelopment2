package BankUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

public class BankFrame extends JFrame implements ActionListener{
	BankAccount bank = new BankAccount();
	
	//Researched decimal formatting to get the numbers to format for money.
	DecimalFormat df = new DecimalFormat("$#,##0.00");
	private JTextField userInput;
	private JButton withdraw;
	private JButton deposit;
	private JButton checkBalance;
	private JLabel currBalance;
	private double amount;
	
	//Frame Constructor
	public BankFrame() {

		setTitle("Bank Account");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Creating panels
		JPanel inPanel = new JPanel();
		JPanel actPanel = new JPanel();
		JPanel outPanel = new JPanel();
		
		//Creating components such as buttons text fields and labels
		JLabel money = new JLabel("Enter Amount:");
		userInput = new JTextField(15);
		withdraw = new JButton("Withdraw");
		deposit = new JButton("Deposit");
		checkBalance = new JButton("Check Balance");
		currBalance = new JLabel("Current Balance: " + (df.format(bank.getBalance())));
		
		//implement a method to call a pop up to capture user initial balance.
		balancePop();
		
		//Adding components to the input panel.
		inPanel.add(money);
		inPanel.add(userInput);
		userInput.setEditable(true);
		
		//adding components to the action panel.
		actPanel.add(withdraw);
		actPanel.add(deposit);
		actPanel.add(checkBalance);
		
		//Adding the component to the output panel.
		outPanel.add(currBalance);
		
		//Adding panels to frame and assigning position to the panels in the frame.
		add((inPanel), BorderLayout.NORTH);
		add((actPanel), BorderLayout.CENTER);
		add((outPanel), BorderLayout.SOUTH);

		//Adding action listeners associated with specific buttons.
		withdraw.addActionListener(this);
		deposit.addActionListener(this);
		checkBalance.addActionListener(this);
		
		//Added a window listener for the display of the final balance and also confirming they want to exit.
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        int choice = JOptionPane.showConfirmDialog(
		            null, "Final Balance: " + df.format(bank.getBalance()) + "\nExit application?", "Exit", JOptionPane.YES_NO_OPTION);

		        if (choice == JOptionPane.YES_OPTION) {
		            dispose();
		            System.exit(0);
		        }
		        
		    }
		});
		
		//Setting frame size, close option, and visibility.
		pack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
	}
	//Method to capture initial balance. Checks for correct input and includes try catch statements 
	//Updates the current balance to the initial input.
	public void balancePop() {
		boolean valid = false;
		

	    while (!valid) {
	        String input = JOptionPane.showInputDialog(this, "Enter Current Balance:");
	        if (input == null) {
	            JOptionPane.showMessageDialog(this, "A starting balance is required.");
	            return;
	        }
	        if (input.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please enter an amount.");
	            continue;
	            
	        }
	        	
	        
	        try {
	            double amount = Double.parseDouble(input);
	            
	            if (amount < 0) {
		        	JOptionPane.showMessageDialog(this, "Amount must be a positive value.");
			        continue;
		        }
	            
	            bank.deposit(amount);
	            currBalance.setText("Current Balance: " + df.format(bank.getBalance()));
	            valid = true;
	        } catch (NumberFormatException ex) {

	            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
	            
	        }

	    }
		
		
	}
	
	//Action performed section. If statements that check for the source of the action to decide the action that should be taken.
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		//Action performed when the withdraw button is clicked. Checks for valid input and updates balance.
		//Try Catch statements implemented and formatting of balance for continuity.
		if(source == withdraw) {
			 String input = userInput.getText();
			 

			 if (input.isEmpty()) {

				 JOptionPane.showMessageDialog(this, "Please enter an amount.");
			        return;
			    }
			 
			 try {
				 double amount = Double.parseDouble(input);
				 if(amount < 0) {
						JOptionPane.showMessageDialog(this, "Amount must be a positive value.");
				        return;
				 }
				 if(!bank.withdrawal(amount)) {
					 JOptionPane.showMessageDialog(this, "Invalid amount or insufficient funds.");
				 }
				 
				 currBalance.setText("Current Balance: " + df.format(bank.getBalance()));
				 
			 }catch(NumberFormatException ex) {
				 JOptionPane.showMessageDialog(this, "Please enter a valid number.");
			 }
		}
		//Action performed when deposit button is clicked. Checks for valid input in text field and updates current balance.
		//try catch implemented.
		else if(source == deposit) {
			
			String input = userInput.getText();
			

			 if (input.isEmpty()) {

				 JOptionPane.showMessageDialog(this, "Please enter an amount.");
			        return;
			 }
			 try {
			 double amount = Double.parseDouble(input);
			 
			 if(amount < 0) {
					JOptionPane.showMessageDialog(this, "Amount must be a positive value.");
			        return;
			 }
			 
			 bank.deposit(amount);
			 currBalance.setText("Current Balance: " + df.format(bank.getBalance()));
			 }catch(NumberFormatException ex) {
				 JOptionPane.showMessageDialog(this, "Please enter a valid number.");
			 }
		}
		//Uses a show message option pane to provide balance (Formated) to the user
		else if(source == checkBalance) {
			JOptionPane.showMessageDialog(this, "Balance: " + df.format(bank.getBalance()));
			currBalance.setText("Current Balance: " + df.format(bank.getBalance()));
	        return;
	        
		}
	
	}
	

}
