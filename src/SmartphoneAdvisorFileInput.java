
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// File input - sets variables based on information from csv file
//
public class SmartphoneAdvisorFileInput {
	
	// Constructor
	public SmartphoneAdvisorFileInput(Smartphone[] smartphoneArray) {
		
		//
		try {
			
			Scanner input = new Scanner(new File("smartphone.csv")); // file input
			input.useDelimiter(","); // use comma to separate different pieces of info
			
			input.nextLine(); // skip first line
			
			int i = 0;
			
			// set variables for each phone
			while(input.hasNextLine()) {
				
				// new smartphone for each index in smartphoneArray
				smartphoneArray[i] = new Smartphone();
				
				// smartphoneArray information fields
				smartphoneArray[i].setBrand(input.next());
				smartphoneArray[i].setModel(input.next());
				smartphoneArray[i].setPrice(input.nextDouble());
				smartphoneArray[i].setSize(input.nextDouble());
				smartphoneArray[i].setResolution(input.next());
				smartphoneArray[i].setOperatingSystem(input.next());
				smartphoneArray[i].setChipset(input.next());
				smartphoneArray[i].setCPU(input.next());
				smartphoneArray[i].getBenchmarkRating()[0] = input.nextInt();
				smartphoneArray[i].getRating()[5] = input.nextInt();
				smartphoneArray[i].setGPU(input.next());
				smartphoneArray[i].setRAM(input.nextDouble());
				smartphoneArray[i].getBenchmarkRating()[1] = input.nextInt();
				smartphoneArray[i].getRating()[6] = input.nextInt();
				smartphoneArray[i].setInternalStorage(input.nextDouble());
				smartphoneArray[i].getBenchmarkRating()[2] = input.nextInt();
				smartphoneArray[i].getRating()[7] = input.nextInt();
				smartphoneArray[i].setCardSlot(input.next());
				smartphoneArray[i].setRearCamera(input.next());
				smartphoneArray[i].setFrontCamera(input.nextInt());
				smartphoneArray[i].setVideoCamera(input.next());
				smartphoneArray[i].setAudio(input.next());
				smartphoneArray[i].setHeadphoneJack(input.next());
				smartphoneArray[i].setLoudspeaker(input.next());
				smartphoneArray[i].setNetwork(input.next());
				smartphoneArray[i].setBattery(input.next());
				smartphoneArray[i].setBatteryCapacity(input.nextInt());
				smartphoneArray[i].setDimensions(input.next());
				smartphoneArray[i].setWeight(input.nextInt());
				smartphoneArray[i].setHyperlink(input.next());
				smartphoneArray[i].setImageFile(input.next());
				
				//System.out.println(smartphoneArray[i]);
						
				i++; // increment
				
			}
			
			input.close(); // close file
			
		} catch(FileNotFoundException error) {
			System.out.println("Invalid file!"); // file error
		}

	}

}
