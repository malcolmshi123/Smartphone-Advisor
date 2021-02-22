
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Help for Ratings
public class UserRatingsHelp extends JFrame implements ActionListener {

	//Setup panel, labels and button for ratings screen
	JPanel helpPanel = new JPanel();
	JLabel helpLabel = new JLabel ("User Ratings Help");
	JLabel help2Label = new JLabel ("This Screen is to help you further choose your perfect phone");
	JLabel help3Label = new JLabel ("Check the radio buttons on which options you prefer and the ");
	JLabel help4Label = new JLabel ("program will do the rest!");
	JButton exitButton = new JButton ("Exit");
	
	//Constructor
	public UserRatingsHelp(){
		frameSetup();
	}
	
	//Setup frame - dimensions, place labels and button on panel
	private void frameSetup() {
		
		setSize(450,425);
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		
		helpLabel.setBounds(500/2-100,25,400,100);
		add (helpLabel);
		
		help2Label.setBounds(500/2-400/2,50,400,100);
		add (help2Label);
		
		help3Label.setBounds(500/2-400/2,75,400,100);
		add (help3Label);
		
		help4Label.setBounds(500/2-400/2,100,400,100);
		add (help4Label);

		exitButton.setBounds(500/2-100, 200, 100, 50);
		add (exitButton);
		exitButton.addActionListener(this);
		
		add (helpPanel);
		
	}

	//Button click
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == exitButton){ 
			setVisible(false);
		}
	}
}