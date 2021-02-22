
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Help for report
public class ReportHelp extends JFrame implements ActionListener {

	//Setup panel, labels and button for report screen
	JPanel helpPanel = new JPanel();
	JLabel helpLabel = new JLabel ("Report Help");
	JLabel help2Label = new JLabel ("Presented are your top 3 smartphones based on your ");
	JLabel help3Label = new JLabel ("preferences. The images are buttons that will direct you to ");
	JLabel help4Label = new JLabel ("an online store so you can buy your perfect smartphone!");
	JButton exitButton = new JButton ("Exit");
	
	//Constructor - run frame setup method
	public ReportHelp(){
		frameSetup();
	}
	
	//Setup dimensions of frame, place labels and buttons on frame
	private void frameSetup() {
		
		setSize(450,425);
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		//Centre frame on screen
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
		
	    //Add labels
		helpLabel.setBounds(50, 25, 400, 100);
		add(helpLabel);
		
		help2Label.setBounds(50, 50, 400, 100);
		add(help2Label);
		
		help3Label.setBounds(50, 75, 400, 100);
		add(help3Label);
		
		help4Label.setBounds(50, 100, 400, 100);
		add(help4Label);
		
		//Add button
		exitButton.setBounds(150, 200, 100, 50);
		add(exitButton);
		exitButton.addActionListener(this);
	
		add(helpPanel); //Add panel to frame
		
	}
	
	//Button click
	public void actionPerformed(ActionEvent event) {
		
		//Close screen when exit button is pressed
		if (event.getSource() == exitButton){ 
			setVisible(false);
		}
	}
}