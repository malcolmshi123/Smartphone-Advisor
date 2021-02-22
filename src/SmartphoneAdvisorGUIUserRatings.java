import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Font; //imports the ability to use Fonts
import java.awt.Toolkit;

// Done by Nicholas Kwan
//User Inputs Preferences, Program outputs options
public class SmartphoneAdvisorGUIUserRatings extends JFrame implements ActionListener {
	

	//"Global Variables"
	
	//
	Font font = new Font("Calibri", Font.BOLD,16); //Adds a usable Font, any time you call font it calls this one
	Font font2 = new Font("Courier", NORMAL,24);
	Font font3 = new Font("Courier", Font.BOLD,12);	
	
	//
	JPanel userRatingsPanel = new JPanel();
	JLabel userRatingLabel = new JLabel ("USER RATING PANEL");
	JLabel questionLabel[] = new JLabel [5];
	JRadioButton [][] radioButton = new JRadioButton[5][3];
	JButton weightingsButton = new JButton ("Enter Your Weightings");
	ButtonGroup buttonGroup[] = new ButtonGroup [5];

	//
	Smartphone[]smartphoneArray;
	User user;
	
	JButton helpButton = new JButton ("Help");

	int smartphoneNumber;


	//This method initializes the GUI 
	public SmartphoneAdvisorGUIUserRatings (Smartphone[]smartphoneArray, User user){
		this.smartphoneArray = smartphoneArray;
		this.user = user;
		setupQuestionLabels(); //Initializes the Question labels
		setupRadioButton(); //Initializes the Radio buttons
		//userRatingsPhoneSetup();
		frameSetup(); //Runs the method frameSetup



	}

	//This method creates the Question labels and puts them in the correct places
	private void setupQuestionLabels() {

		
		userRatingsPanel.setLayout(null);

		questionLabel [0] = new JLabel ("Brand Preference");
		questionLabel [1] = new JLabel ("Optimal Price");
		questionLabel [2] = new JLabel ("Optimal Size");
		questionLabel [3] = new JLabel ("Camera Quality");
		questionLabel [4] = new JLabel ("Storage Space");
		
		
		
		for (int index = 0; index < questionLabel.length; index++){
			questionLabel [index].setBounds(25+250*index,25,150,50);
			//questionLabel[index].setOpaque(true);
			//questionLabel[index].setBackground(Color.white);
			questionLabel[index].setFont(font); 
			userRatingsPanel.add(questionLabel[index]);
		}
	}

	//This method creates the Radio buttons and puts them in the correct places
	private void setupRadioButton() { 

		//Adds the options to the radio buttons (Group 1, brand)
		radioButton [0] [0] = new JRadioButton("Samsung");
		radioButton [0] [1] = new JRadioButton("Apple");
		radioButton [0] [2] = new JRadioButton("Other");

		//Adds the options to the radio buttons (Group 2, Price)
		radioButton [1] [0] = new JRadioButton("Under 200");
		radioButton [1] [1] = new JRadioButton("Between 200 and 500");
		radioButton [1] [2] = new JRadioButton("Above 500");

		//Adds the options to the radio buttons (Group 3, Phone Size)
		radioButton [2] [0] = new JRadioButton("5\" or less");
		radioButton [2] [1] = new JRadioButton("Between 5\" and 5.5\" ");
		radioButton [2] [2] = new JRadioButton("More than 5.5\"");

		//Adds the options to the radio buttons (Group 4, Camera quality)
		radioButton [3] [0] = new JRadioButton("1 - 5 MP");
		radioButton [3] [1] = new JRadioButton("5 - 10 MP");
		radioButton [3] [2] = new JRadioButton("10+ MP");

		//Adds the options to the radio buttons (Group 5, Internal Storage)
		radioButton [4] [0] = new JRadioButton("512MB - 1GB");
		radioButton [4] [1] = new JRadioButton("1GB - 16GB");
		radioButton [4] [2] = new JRadioButton("+16GB");

		//These for loops will place the radio buttons by groups of 3 in 
		for (int groupIndex = 0; groupIndex < buttonGroup.length; groupIndex++){
			buttonGroup[groupIndex] = new ButtonGroup();
			for (int index = 0; index<radioButton[groupIndex].length;index++){
				buttonGroup [groupIndex].add (radioButton[groupIndex][index]);
				radioButton [groupIndex] [index].setBounds(25+250*groupIndex-12, 100+index*50, 225-50,50);
				userRatingsPanel.add (radioButton[groupIndex][index]);
				radioButton[groupIndex][index].addActionListener(this);
				radioButton[groupIndex][index].setFont(font3); 

			}
		}

	}

	//Does as the name says, sets up the ratings frame and places the panel, title label, and the button to the next screen.
	private void frameSetup() {

		setSize(1275,750);
		setTitle("User Rating");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setLayout(null); //This line of code gives you manual placement of the frame and objects on such frame.
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		
		userRatingsPanel.setBackground(Color.cyan);

		userRatingsPanel.setBounds(25, 100, 1250-50, 500);
		add (userRatingsPanel);

		//Sets the boundary, adds the label, sets the font
		userRatingLabel.setBounds(1250/2-100,25,300,100);
		add (userRatingLabel);
		userRatingLabel.setFont(font2); 

		//Sets the boundary, adds the button, sets the font
		weightingsButton.setBounds(1250/2-175/2+25, 600+12, 200, 75);
		add (weightingsButton);
		weightingsButton.addActionListener(this);
		weightingsButton.setFont(font3); 
		
		helpButton.setBounds(1000, 25, 100, 50);
		add (helpButton);
		helpButton.addActionListener(this);


	}

	//This makes sure that when the buttons are pressed they actually mean/do something
	public void actionPerformed(ActionEvent event){
		
		// Allows for the storage of which buttons were pressed and what they do, in this case allows for storage of radio button data
		for (int categoryIndex=0; categoryIndex < 5; categoryIndex++){
			for (int index = 0; index < 3; index++){
				if (event.getSource() == radioButton [categoryIndex][index]) 
					setRating(categoryIndex, index);
			}
		}
		
		//If the go to weightings button is pressed it will open the Weightings GUI
		if (event.getSource() == weightingsButton){ 
			setVisible(false);
			new SmartphoneAdvisorGUIUserWeightings(smartphoneArray,user);
		}

		if (event.getSource() == helpButton)
			new UserRatingsHelp();

	}

	//Figures out which category was clicked then sends the information to the methods below to set ratings
	private void setRating (int categoryIndex, int index){

		if (categoryIndex == 0)
			setBrandRating(index);
		else if (categoryIndex == 1)
			setPriceRating(index);
		else if (categoryIndex == 2)
			setSizeRating(index);
		else if (categoryIndex == 3)
			setCameraRating(index);
		else if (categoryIndex == 4)
			setStorageRating(index);

	}

	//this code will actually set the rating in this case for the Brand
	private void setBrandRating(int index) {

		String preferredBrand = radioButton[0][index].getText();

		for (int smartphoneNumber = 0; smartphoneNumber < smartphoneArray.length; smartphoneNumber++) {
			if (smartphoneArray[smartphoneNumber].getBrand().equalsIgnoreCase(preferredBrand))
				smartphoneArray[smartphoneNumber].getRating()[0] = 10;
			else
				smartphoneArray[smartphoneNumber].getRating()[0] = 0;
		}
	}

	//this code will actually set the rating in this case for the Price
	private void setPriceRating(int index) {

		String preferredBudget = radioButton[1][index].getText();

		for (smartphoneNumber = 0; smartphoneNumber < smartphoneArray.length; smartphoneNumber++) {
			if (index == 0){
				if (smartphoneArray[smartphoneNumber].getPrice() <= 200)
					smartphoneArray[smartphoneNumber].getRating()[1] = 10;

				else if (smartphoneArray[smartphoneNumber].getPrice() >= 200 && smartphoneArray[smartphoneNumber].getPrice() >=500)
					smartphoneArray[smartphoneNumber].getRating()[1] = 5;

				else if (smartphoneArray[smartphoneNumber].getPrice() >= 500)
					smartphoneArray[smartphoneNumber].getRating()[1] = 0;							
			}

			else if (index == 1){
				if (smartphoneArray[smartphoneNumber].getPrice() <= 200)
					smartphoneArray[smartphoneNumber].getRating()[1] = 5;

				else if (smartphoneArray[smartphoneNumber].getPrice() >= 200 && smartphoneArray[smartphoneNumber].getPrice() >=500)
					smartphoneArray[smartphoneNumber].getRating()[1] = 10;

				else if (smartphoneArray[smartphoneNumber].getPrice() >= 500)
					smartphoneArray[smartphoneNumber].getRating()[1] = 5;	
			}

			else if (index == 2){
				if (smartphoneArray[smartphoneNumber].getPrice() <= 200)
					smartphoneArray[smartphoneNumber].getRating()[1] = 0;

				else if (smartphoneArray[smartphoneNumber].getPrice() >= 200 && smartphoneArray[smartphoneNumber].getPrice() >=500)
					smartphoneArray[smartphoneNumber].getRating()[1] = 5;

				else if (smartphoneArray[smartphoneNumber].getPrice() >= 500)
					smartphoneArray[smartphoneNumber].getRating()[1] = 10;
			}

		}
	}

	//this code will actually set the rating in this case for the Size
	private void setSizeRating(int index) {

		String preferredSize = radioButton[1][index].getText();

		for (smartphoneNumber = 0; smartphoneNumber < smartphoneArray.length; smartphoneNumber++) {

			if (index == 0){
				if (smartphoneArray[smartphoneNumber].getSize() <= 5)
					smartphoneArray[smartphoneNumber].getRating()[2] = 10;

				else if (smartphoneArray[smartphoneNumber].getSize() >= 5 && smartphoneArray[smartphoneNumber].getSize() <= 10 )
					smartphoneArray[smartphoneNumber].getRating()[2] = 5;	

				else if (smartphoneArray[smartphoneNumber].getSize() >= 10)
					smartphoneArray[smartphoneNumber].getRating()[2] = 0;	
			}	
			else if (index == 1){
				if (smartphoneArray[smartphoneNumber].getSize() <= 5)
					smartphoneArray[smartphoneNumber].getRating()[2] = 5;

				else if (smartphoneArray[smartphoneNumber].getSize() >= 5 && smartphoneArray[smartphoneNumber].getSize() <= 10 )
					smartphoneArray[smartphoneNumber].getRating()[2] = 10;	

				else if (smartphoneArray[smartphoneNumber].getSize() >= 10)
					smartphoneArray[smartphoneNumber].getRating()[2] = 5;	
			}	
			else if (index == 2){
				if (smartphoneArray[smartphoneNumber].getSize() <= 5)
					smartphoneArray[smartphoneNumber].getRating()[2] = 0;

				else if (smartphoneArray[smartphoneNumber].getSize() >= 5 && smartphoneArray[smartphoneNumber].getSize() <= 10 )
					smartphoneArray[smartphoneNumber].getRating()[2] = 5;	

				else if (smartphoneArray[smartphoneNumber].getSize() >= 10)
					smartphoneArray[smartphoneNumber].getRating()[2] = 10;	
			}	
		}
	}	

	//this code will actually set the rating in this case for the Camera
	private void setCameraRating(int index) {

		String preferredCamera = radioButton[1][index].getText();

		for (smartphoneNumber = 0; smartphoneNumber < smartphoneArray.length; smartphoneNumber++) {

			if (index == 0){
				if (smartphoneArray[smartphoneNumber].getFrontCamera() <= 5)
					smartphoneArray[smartphoneNumber].getRating()[3] = 10;

				else if (smartphoneArray[smartphoneNumber].getFrontCamera() >= 5 && smartphoneArray[smartphoneNumber].getSize() <= 10 )
					smartphoneArray[smartphoneNumber].getRating()[3] = 5;	

				else if (smartphoneArray[smartphoneNumber].getFrontCamera() >= 10)
					smartphoneArray[smartphoneNumber].getRating()[3] = 0;	
			}	
			else if (index == 1){
				if (smartphoneArray[smartphoneNumber].getFrontCamera() <= 5)
					smartphoneArray[smartphoneNumber].getRating()[3] = 5;

				else if (smartphoneArray[smartphoneNumber].getFrontCamera() >= 5 && smartphoneArray[smartphoneNumber].getSize() <= 10 )
					smartphoneArray[smartphoneNumber].getRating()[3] = 10;	

				else if (smartphoneArray[smartphoneNumber].getFrontCamera() >= 10)
					smartphoneArray[smartphoneNumber].getRating()[3] = 5;	
			}	
			else if (index == 2){
				if (smartphoneArray[smartphoneNumber].getFrontCamera() <= 5)
					smartphoneArray[smartphoneNumber].getRating()[3] = 0;

				else if (smartphoneArray[smartphoneNumber].getFrontCamera() >= 5 && smartphoneArray[smartphoneNumber].getFrontCamera() <= 10 )
					smartphoneArray[smartphoneNumber].getRating()[3] = 5;	

				else if (smartphoneArray[smartphoneNumber].getFrontCamera() >= 10)
					smartphoneArray[smartphoneNumber].getRating()[3] = 10;	
			}	
		}
	}	

	//this code will actually set the rating in this case for the Internal Storage
	private void setStorageRating(int index) {

		String preferredStorage = radioButton[1][index].getText();

		for (smartphoneNumber = 0; smartphoneNumber < smartphoneArray.length; smartphoneNumber++) {

			if (index == 0){
				if (smartphoneArray[smartphoneNumber].getInternalStorage() <= 1)
					smartphoneArray[smartphoneNumber].getRating()[4] = 10;

				else if (smartphoneArray[smartphoneNumber].getInternalStorage() >= 1 && smartphoneArray[smartphoneNumber].getSize() <= 16 )
					smartphoneArray[smartphoneNumber].getRating()[4] = 5;	

				else if (smartphoneArray[smartphoneNumber].getInternalStorage() >= 16)
					smartphoneArray[smartphoneNumber].getRating()[4] = 0;	
			}	
			else if (index == 1){
				if (smartphoneArray[smartphoneNumber].getInternalStorage() <= 1)
					smartphoneArray[smartphoneNumber].getRating()[4] = 5;

				else if (smartphoneArray[smartphoneNumber].getInternalStorage() >= 1 && smartphoneArray[smartphoneNumber].getSize() <= 16 )
					smartphoneArray[smartphoneNumber].getRating()[4] = 10;	

				else if (smartphoneArray[smartphoneNumber].getInternalStorage() >= 16)
					smartphoneArray[smartphoneNumber].getRating()[4] = 5;	
			}	
			else if (index == 2){
				if (smartphoneArray[smartphoneNumber].getInternalStorage() <= 1)
					smartphoneArray[smartphoneNumber].getRating()[4] = 0;

				else if (smartphoneArray[smartphoneNumber].getInternalStorage() >= 1 && smartphoneArray[smartphoneNumber].getFrontCamera() <= 16 )
					smartphoneArray[smartphoneNumber].getRating()[4] = 5;	

				else if (smartphoneArray[smartphoneNumber].getInternalStorage() >= 16)
					smartphoneArray[smartphoneNumber].getRating()[4] = 10;	
			}	
		}
	}	

	//This method creates the panel
	private void userRatingPanelSetup(){

		userRatingsPanel.setBounds(50, 50, 1250	,1000);
		userRatingsPanel.setLayout(null); //This code gives you manual control of the object placement bypassing auto placement

	}



}