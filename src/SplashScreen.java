//Created by Nick and Malcolm
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// Splash screen - first screen to introduce user to application
public class SplashScreen extends JFrame implements ActionListener {
	
	//Creates an array for the smartphones
	public static Smartphone [] smartphoneArray = new Smartphone [30];
				
	public static User user = new User();
	
	//Global Variables 
	Font font = new Font("Calibri", Font.BOLD, 24); //Font
	
	//Create Labels
	JPanel info = new JPanel();
	JLabel infoLabel = new JLabel("<html><div style='text-align: center;'>Welcome to the The Smartphone Advisor!<br/>"
			+ "<br/>This program will help you choose the perfect phone.<br/><br/>Click the Start Button to Continue."
			+ "</div><html>", SwingConstants.CENTER);
	JPanel black1 = new JPanel();
	JPanel black2 = new JPanel();
	JLabel image = new JLabel(new ImageIcon("images/smartphones.jpg"));
    
	//Create Button
	JButton startButton = new JButton ("Start");
	
	//Runs/opens the screen
	public SplashScreen() {
		frameSetup();
	}
	
	//Sets up the frame and place buttons on frame
	private void frameSetup() {
		
		// add panels and labels
		info.setBounds(325, 0, 600, 750);
		info.setBackground(Color.white);
		info.setLayout(null);
		
		infoLabel.setBounds(325, 50, 600, 150);
		infoLabel.setFont(font);
		info.add(infoLabel);
		
		black1.setBounds(0, 0, 325, 750);
		black1.setBackground(Color.DARK_GRAY);
		black1.setLayout(null);
		add(black1);
		
		black2.setBounds(925, 0, 325, 750);
		black2.setBackground(Color.DARK_GRAY);
		black2.setLayout(null);
		add(black2);
		
		// add image
		image.setBounds(369, 250, 512, 288);
		info.add(image);

		startButton.setBounds(575, 588, 100, 50);
		startButton.addActionListener(this);
		info.add(startButton);
		
		add(info); // add panel to frame
		
		setSize(1250,750);
		setTitle("Smartphone Advisor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		// centre frame on screen
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		
	}

	//Create button to Exit
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == startButton){ 
			
			//Option box to show steps
			int steps = JOptionPane.showOptionDialog(null, "1. Enter ratings for phone components.\n2. How much do you "
					+ "care about each component?\n3. Top 3 phones based on your selections.", "Steps", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			
			//Open next screen when ok is selected
			if(steps == JOptionPane.OK_OPTION) {
				setVisible(false);
				
				//Fills in the smartphone array with smartphones
				new SmartphoneAdvisorFileInput(smartphoneArray);
				
				//Actual program that user can see and enter information
				new SmartphoneAdvisorGUIUserRatings(smartphoneArray, user);
			}
		}
	}
}
