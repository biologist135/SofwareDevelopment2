package BankUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

public class BankFrame extends JFrame implements ActionListener{
	BankAccount bank = new BankAccount();
	DecimalFormat df = new DecimalFormat("$#,##0.00");
	private JTextField userInput;
	private JButton withdraw;
	private JButton deposit;
	private JButton checkBalance;
	private JLabel currBalance;
	private double amount;
	private JTextField initAmount;
	
	
	public BankFrame() {

		setTitle("Bank Account");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel inPanel = new JPanel();
		JPanel actPanel = new JPanel();
		JPanel outPanel = new JPanel();
		
		JLabel money = new JLabel("Enter Amount:");
		userInput = new JTextField(15);
		withdraw = new JButton("Withdraw");
		deposit = new JButton("Deposit");
		checkBalance = new JButton("Check Balance");
		currBalance = new JLabel("Current Balance: " + (df.format(bank.getBalance())));
		balancePop();
		
		inPanel.add(money);
		inPanel.add(userInput);
		userInput.setEditable(true);
		
		actPanel.add(withdraw);
		actPanel.add(deposit);
		actPanel.add(checkBalance);
		
		outPanel.add(currBalance);
		
		add((inPanel), BorderLayout.NORTH);
		add((actPanel), BorderLayout.CENTER);
		add((outPanel), BorderLayout.SOUTH);

		
		withdraw.addActionListener(this);
		deposit.addActionListener(this);
		checkBalance.addActionListener(this);
		
		
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
		
		pack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
	}
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
				
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == initAmount) {
			String input = initAmount.getText();
			
			
			
			if (input.isEmpty()) {

				 JOptionPane.showMessageDialog(this, "Please enter an amount.");
			        return;
			}
			double amount = Double.parseDouble(input);
			
			if(amount < 0) {
				JOptionPane.showMessageDialog(this, "Amount must be a positive value.");
		        return;
			}
			bank.deposit(amount);
			
		}
		else if(source == withdraw) {
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
				 if(!bank.withdrawalCheck(amount)) {
					 JOptionPane.showMessageDialog(this, "Invalid amount or insufficient funds.");
				 }
				 
				 currBalance.setText("Current Balance: " + df.format(bank.getBalance()));
				 
			 }catch(NumberFormatException ex) {
				 JOptionPane.showMessageDialog(this, "Please enter a valid number.");
			 }
		}
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
		else if(source == checkBalance) {
			JOptionPane.showMessageDialog(this, "Balance: " + df.format(bank.getBalance()));
			currBalance.setText("Current Balance: " + df.format(bank.getBalance()));
	        return;
	        
		}
	
	}
	

}
