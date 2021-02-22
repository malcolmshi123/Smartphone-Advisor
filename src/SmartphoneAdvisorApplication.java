
/*
 * Nicholas, Malcolm, Sarah
 * May 6 2019
 * ICS 3U1
 * Smartphone Advisor Application enables users to easily find a phone based on their specified requirements. The user is first asked eight questions 
 * regarding their personal preference of smartphone characteristics and next asked of the importance of each characteristic previously stated. Then are
 * they given three smartphones to choose from and a direct link to purchase it. The main class "SmartphoneAdvisorApplication" creates the smartphone array
 * and user and calls on the other classes "SmartphoneAdvisorFileInput" and "SmartphoneAdvisorRatings" to ultimately run the whole program. The
 * "SmartphoneAdvisorFileInput" class enters each smartphone and it's characteristics. The characteristics are as listed; brand, model, price, size,
 * resolution, operating system, chipset, CPU, CPU benchmark, GPU, RAM, memory benchmark, internal storage, storage benchmark card slot, front, rear, and
 * video camera quality, audio, headphone jack, network, battery technology, battery capacity, dimensions, weight, and purchase link. Within 
 * "SmartphoneAdvisorRatings" is the code that runs the part that the user sees. The screen setup as well as the information taken in and it's results are 
 * all played out through the class and other classes "SmartphoneAdivsorGUIUserRatings calls, such as "SmartphoneAdvisorWeightings" which holds the panel 
 * that asks the user for how much they care about a certain characteristic. 
 * 
 * Extra features:
 * - help menus and images
 * - Arrays
 * - Combo box
 * - Action listener
 * - Font
 * Color, Scanner, Toolkit, Comparator, 
 */

import java.io.File;
import javax.sound.sampled.*;

//
//
public class SmartphoneAdvisorApplication {
	
	//Runs program
	public static void main(String [] args) throws Exception {
		
		new SplashScreen();
		
		//Plays background music throughout program
		backgroundMusic();
		
	}
	
	// Author: Malcolm
	// Reads, clips, and plays music file
	private static void backgroundMusic() throws Exception {
		
		File soundFile = new File("backgroundMusic.wav");
				
		Line.Info linfo = new Line.Info(Clip.class);
		Line line = AudioSystem.getLine(linfo);
		Clip clip = (Clip) line;		
		
		AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);	
		clip.open(ais);
		clip.start();
		
	}

}