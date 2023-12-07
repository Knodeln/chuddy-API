package dev.knodeln.chuddy.model;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LoginGUI implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
    JButton signupButton = new JButton("Sign Up");
	JTextField userMailField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userMailLabel = new JLabel("E-mail:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginGUI(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userMailLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userMailField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);

        signupButton.setBounds(25,200,100,25);
		signupButton.setFocusable(false);
		signupButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(userMailLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userMailField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
        frame.add(signupButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==resetButton) {
			userMailField.setText("");
			userPasswordField.setText("");
		}

        if(e.getSource() == signupButton) {
            SignUp signUpPage = new SignUp(); 
            signUpPage.displaySignUpGUI();
            frame.dispose(); 
        }
		
		if(e.getSource()==loginButton) {
			
			String userID = userMailField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID); // sätt in första sidan här
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}

			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("username not found");
			}
		}
	}

    public void displayLoginGUI() {
    }	
}