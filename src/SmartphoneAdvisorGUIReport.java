
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.*;

// report screen - displays buttons with images for top 3 smartphones with hyperlinks to web browser
// includes text areas to display information on each smartphone
public class SmartphoneAdvisorGUIReport extends JFrame implements ActionListener {
	
	// build panel, labels, buttons, text area and scroll pane
	JPanel reportPanel = new JPanel();
	JLabel reportPanelLabel = new JLabel("YOUR TOP 3 SMARTPHONES!!!", SwingConstants.CENTER);
	JButton[] smartphoneImageButton = new JButton[3];
	JTextArea[] smartphoneTextAreaArray = new JTextArea[3];
	JScrollPane[] smartphoneScrollPane = new JScrollPane[3];
	JButton helpButton = new JButton("Help");
	JButton newUserButton = new JButton("New User");
	JButton exitButton = new JButton("Exit");
	
	// create font and font colour
	Font font = new Font("Calibri", Font.BOLD, 24);
	Color white = new Color(255, 255, 255);
	
	// call smartphoneArray and user constructor
	Smartphone[] smartphoneArray;
	User user;
	
	// constructor - update smartphoneArray and user and build the frame
	public SmartphoneAdvisorGUIReport(Smartphone[] smartphoneArray, User user) {
		
		this.smartphoneArray = smartphoneArray;
		this.user = user;
		
		reportPanelSetup();
		createReport();
		frameSetup();
		
	}
	
	// set dimensions and layout of frame
	private void frameSetup() {

		setSize(1325, 725);
		setTitle("Smartphone Advisor");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // disable exit button
		setLayout(null);
		setVisible(true);
		
		// centre frame on screen
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		
	}
	
	// add panel, labels and buttons to frame
	private void reportPanelSetup() {

		//
		reportPanel.setBounds(0, 0, 1325, 725);
		reportPanel.setBackground(Color.black);
		reportPanel.setLayout(null);
		
		reportPanelLabel.setBounds(450, 50, 400, 25);
		reportPanelLabel.setFont(font);
		reportPanelLabel.setForeground(white);
		reportPanel.add(reportPanelLabel);
		
		helpButton.setBounds(1000, 25, 100, 50);
		helpButton.addActionListener(this);
		reportPanel.add(helpButton);
		
		newUserButton.setBounds(600, 575, 100, 50);
		newUserButton.addActionListener(this);
		reportPanel.add(newUserButton);
		
		exitButton.setBounds(1000, 575, 100, 50);
		exitButton.addActionListener(this);
		reportPanel.add(exitButton);
		
	}
	
	// button clicks
	public void actionPerformed(ActionEvent event) {
		
		// open respective web browser link for each button
		for(int i = 0; i < smartphoneImageButton.length; i++) {
			if(event.getSource() == smartphoneImageButton[i]) {
				openWebBrowser(i);
			}
		}
		
		// open help screen when help button is clicked
		if(event.getSource() == helpButton) {
			new ReportHelp();
		}
		
		// return to previous screen when user button is clicked
		if(event.getSource() == newUserButton) {
			
			// option box - ask user where to go
			int confirm = JOptionPane.showConfirmDialog(null, "Go back to the very beginning?", "New User", 
					JOptionPane.YES_NO_CANCEL_OPTION);
			if(confirm == JOptionPane.YES_OPTION) {
				setVisible(false);
				new SplashScreen();
			}
			else if(confirm == JOptionPane.NO_OPTION) {
				setVisible(false);
				new SmartphoneAdvisorGUIUserRatings(smartphoneArray, user);
			}
		}
		
		// quit program when exit button is clicked
		if(event.getSource() == exitButton) {
			System.exit(0);
		}
		
	}

	// open web browser link with respect to smartphone
	private void openWebBrowser(int i) {
		
		if(Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI(smartphoneArray[i].getHyperlink()));
			} catch (IOException e1) {
			e1.printStackTrace();
			} catch (URISyntaxException e1) {
			e1.printStackTrace();
			}
			
		}
		
	}
	
	// add components to report frame
	private void createReport() {

		rankSmartphones();
		
		add(reportPanel); // add report panel to the frame
		repaint();
		
	}
	
	// rank smartphones based on score
	private void rankSmartphones() {
		
		// create a score for each smartphone based on ratings and weightings
		for(Smartphone currentSmartphone: smartphoneArray) {
			currentSmartphone.setScore(wdm(currentSmartphone, user));

		}
		
		// sort from highest to lowest scores
		Arrays.sort(smartphoneArray, Comparator.comparing(Smartphone::getScore).reversed());
		
		// set button images and text areas for top 3 smartphones
		for(int i = 0; i < 3; i++) {
			
			System.out.println(smartphoneArray[i].getScore());
			
			// create buttons, set dimensions
			smartphoneImageButton[i] = new JButton();
			smartphoneImageButton[i].setBounds(100 + 400*i, 100, 300, 200);
			smartphoneImageButton[i].addActionListener(this);
			
			// scale true image dimensions on each button
			ImageIcon icon = new ImageIcon("images/" + smartphoneArray[i].getImageFile());
			int width = 200*icon.getIconWidth()/icon.getIconHeight();
			smartphoneImageButton[i].setIcon(new ImageIcon(icon.getImage().getScaledInstance(width, 200, 0)));
			reportPanel.add(smartphoneImageButton[i]);
			smartphoneImageButton[i].setBorder(BorderFactory.createLineBorder(Color.green));
			
			// create text areas, set dimensions
			smartphoneTextAreaArray[i] = new JTextArea();
			smartphoneTextAreaArray[i].setBounds(smartphoneImageButton[i].getX(), 350, 300, 200);
			
			// set the text based on smartphone
			smartphoneTextAreaArray[i].setText("Brand:\t" + smartphoneArray[i].getBrand() + 
					"\nModel:\t" + smartphoneArray[i].getModel() + "\nPrice:\t$" + smartphoneArray[i].getPrice() + 
					"\nOS:\t" + smartphoneArray[i].getOperatingSystem() + 
					"\nSize:\t" + smartphoneArray[i].getSize() + 
					"\"\nResolution:\t" + smartphoneArray[i].getResolution() + 
					"\nChipset:\t" + smartphoneArray[i].getChipset() + "\nGPU:\t" + smartphoneArray[i].getGPU() + 
					"\nRAM:\t" + smartphoneArray[i].getRAM() + 
					" GB\nStorage:\t" + smartphoneArray[i].getInternalStorage() + 
					" GB\nRear Camera:\t" + smartphoneArray[i].getRearCamera() + 
					"\nFront Camera:\t" + smartphoneArray[i].getFrontCamera() + 
					" MP\nVideo Camera:\t" + smartphoneArray[i].getVideoCamera() + 
					"\nBattery:\t" + smartphoneArray[i].getBattery() + 
					", " + smartphoneArray[i].getBatteryCapacity() + 
					" mAh\nDimensions:\t" + smartphoneArray[i].getDimensions() + 
					"\nWeight:\t" + smartphoneArray[i].getWeight() + " g");
			
			// uneditable, wrap style for each word
			smartphoneTextAreaArray[i].setEditable(false);
			smartphoneTextAreaArray[i].setWrapStyleWord(true);
			reportPanel.add(smartphoneTextAreaArray[i]);
			
			// add a scroll pane to each text area
			smartphoneScrollPane[i] = new JScrollPane(smartphoneTextAreaArray[i]);
			smartphoneScrollPane[i].setBounds(smartphoneImageButton[i].getX(), 350, 300, 200);
			reportPanel.add(smartphoneScrollPane[i]);
			smartphoneScrollPane[i].setBorder(BorderFactory.createLineBorder(Color.cyan));
			
		}

	}
	
	// weighted decision matrix
	private int wdm(Smartphone currentSmartphone, User user) {
		
		int totalScore = 0;
		
		// create a score for each smartphone based on ratings and weightings
		for(int i = 0; i < currentSmartphone.getRating().length; i++) {
			totalScore += currentSmartphone.getRating()[i] * user.getWeighting()[i];
		}
		
		return totalScore;
		
	}
	
}
