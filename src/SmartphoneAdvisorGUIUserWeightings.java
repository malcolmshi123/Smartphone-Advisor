
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/* Creates the screen that prompts user for the importance of smartphone characteristics
 * Sarah
 */

public class SmartphoneAdvisorGUIUserWeightings extends JFrame implements ActionListener {
	
	//UserweightingsPanel elements
	JPanel userweightingsPanel = new JPanel();
	JLabel userweightingsLabel = new JLabel ("USER WEIGHTINGS PANEL");
	
	//Array for questions
	JLabel[] weightingLabelArray = new JLabel[8];
	
	//Array for Images
	JLabel[] imagesArray = new JLabel[8];
	
	JComboBox < Integer > [] weightingComboBoxArray = new JComboBox[8];
	
	JButton reportButton = new JButton("Enter Weightings");
	
	Smartphone[] smartphoneArray;
	
	User user;
	
	/* 
	 * Report panel and JFrame
	 */
	
	public SmartphoneAdvisorGUIUserWeightings(Smartphone[] smartphoneArray, User user){
	
		//
		this.user = user;
		this.smartphoneArray = smartphoneArray;
		
		//
		setupweightings();
		userweightingsPanelSetup();
		frameSetup();
	
	}

	//Sets the layout of the screen
	private void userweightingsPanelSetup(){
		
		//Creates outline
		userweightingsPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
		userweightingsPanel.setBounds(50, 50, 1250, 500);
		userweightingsPanel.setLayout(null);
		//Sets background colour of the panel
		userweightingsPanel.setBackground(Color.white);
		
		//Title
		//Sets font
		userweightingsLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		userweightingsLabel.setBounds(1366/2-100+50,35,200,100);
		add(userweightingsLabel);
		
		//Adds report button
		reportButton.setBounds(575,575,200,50);
		add(reportButton);
		reportButton.addActionListener(this);
		
		//Adds userweightingspanel to the screen, makes it visible
		add(userweightingsPanel);
		
	}
		
	//Places each question within the screen
	private void setupweightings(){
			
		//Questions
		weightingLabelArray[0] = new JLabel("1. How important is the brand?");
		weightingLabelArray[1] = new JLabel("2. How important is the price?");
		weightingLabelArray[2] = new JLabel("3. How important is the screen size?");
		weightingLabelArray[3] = new JLabel("4. How important is the camera quality?");
		weightingLabelArray[4] = new JLabel("5. How important is the storage?");
		weightingLabelArray[5] = new JLabel("6. How important is the CPU?");
		weightingLabelArray[6] = new JLabel("7. How important is the memory?");
		weightingLabelArray[7] = new JLabel("8. How important is the disk?");
			
		//Adds each question to screen
		for(int index = 0; index < weightingLabelArray.length; index++){
			
			//First row of questions
			if(index < 4)
				weightingLabelArray[index].setBounds(50+index*300,75,250,25);
			//Second row of questions
			else
				weightingLabelArray[index].setBounds(50+(index - 4)*300, 275, 250, 25);
			
			//Text colour
			weightingLabelArray[index].setForeground(Color.DARK_GRAY);
			//Font
			weightingLabelArray[index].setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
			
			//Allows question to be visible
			userweightingsPanel.add(weightingLabelArray[index]);
			
			//Drop downs
			weightingComboBoxArray[index] = new JComboBox < Integer > ();
			weightingComboBoxArray[index].addActionListener(this);

			weightingComboBoxArray[index].setBounds(50+index*300, 100, 100, 25);

			//First row
			if(index < 4)
				//Adds numbers 1-10 to combo box
				for(int num = 1; num <= 10; num++) {
					weightingComboBoxArray[index].addItem(num);
					weightingComboBoxArray[index].setBounds(50 + index * 300, 100, 100, 25);
				}
					
			//Second Row
			else
				//Adds numbers 1-10 to combo box
				for(int num = 1; num <= 10; num++) {
					weightingComboBoxArray[index].addItem(num);
					weightingComboBoxArray[index].setBounds(50 + (index - 4) * 300, 300, 100,25);
				}

			//Allows combo boxes to be visible
			userweightingsPanel.add(weightingComboBoxArray[index]);
			
		}
		
		//Add images
		addimages();
		
	}	
		
	private void addimages() {
		
		//List of Images
		imagesArray[0] = new JLabel(new ImageIcon("images/brands.jpg"));
		imagesArray[1] = new JLabel(
				new ImageIcon("images/price.jpg"));
		imagesArray[2] = new JLabel(
				new ImageIcon("images/size.jpg"));
		imagesArray[3] = new JLabel(
				new ImageIcon("images/camera.jpg"));
		imagesArray[4] = new JLabel(
				new ImageIcon("images/storage.jpg"));
		imagesArray[5] = new JLabel(
				new ImageIcon("images/cpu.jpg"));
		imagesArray[6] = new JLabel(
				new ImageIcon("images/memory.jpg"));
		imagesArray[7] = new JLabel(
				new ImageIcon("images/disk.jpg"));
		
		//Goes through list to place image onto the screen
		for(int index = 0; index < imagesArray.length; index++){
		
			//Each image is placed on a certain x level depending on it's size
			if(index == 0)
				imagesArray[index].setBounds(50 + index * 300, 195, 300, 116);
			else if(index < 3)
				imagesArray[index].setBounds(50 + index * 300, 195, 215, 116);
			else if(index == 3)
				imagesArray[index].setBounds(50 + index * 300, 195, 205, 116);
			else
				imagesArray[index].setBounds(50+(index - 4)*300, 390, 200, 116);
		
			//Allows images to be visible
			add(imagesArray[index]);
			
		}
		
	}

	//Sets up frame
	private void frameSetup() {
		
		//Size
		setSize(1366, 725);
		
		//Program name
		setTitle("Smartphone Advisor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		//Sets background colour
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		
	}

	//Makes use of user input, allows user to continue
	public void actionPerformed(ActionEvent event){
		
		//
		for(int index = 0; index < weightingComboBoxArray.length; index++){
			if (event.getSource() == weightingComboBoxArray[index]){
				user.getWeighting()[index] = weightingComboBoxArray[index].getSelectedIndex();
				break;
			}
		}
			
		//
		if (event.getSource() == reportButton){
			setVisible(false);
			new SmartphoneAdvisorGUIReport(smartphoneArray, user);
				
		}
	}
}