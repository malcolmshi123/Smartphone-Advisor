
import java.util.Arrays;

//
public class Smartphone {
	
	//
	private String brand;
	private String model;
	private double price;
	private double size;
	private String resolution;
	private String OperatingSystem;
	private String chipset;
	private String CPU;
	private String GPU;
	private double RAM;
	private double internalStorage;
	private String cardSlot;
	private String rearCamera;
	private int frontCamera;
	private String videoCamera;
	private String audio;
	private String headphoneJack;
	private String loudspeaker;
	private String network;
	private String battery;
	private int batteryCapacity;
	private String dimensions;
	private int weight;
	private String hyperlink;
	private int [] benchmarkRating = new int [3];
	private String imageFile;	
	
	//
	private int [] rating = new int [8];

	//
	private int score;
	
	//
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getOperatingSystem() {
		return OperatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getCPU() {
		return CPU;
	}
	public void setCPU(String cPU) {
		CPU = cPU;
	}
	public String getGPU() {
		return GPU;
	}
	public void setGPU(String gPU) {
		GPU = gPU;
	}
	public double getRAM() {
		return RAM;
	}
	public void setRAM(double rAM) {
		RAM = rAM;
	}
	public double getInternalStorage() {
		return internalStorage;
	}
	public void setInternalStorage(double internalStorage) {
		this.internalStorage = internalStorage;
	}
	public String getCardSlot() {
		return cardSlot;
	}
	public void setCardSlot(String cardSlot) {
		this.cardSlot = cardSlot;
	}
	public String getRearCamera() {
		return rearCamera;
	}
	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}
	public int getFrontCamera() {
		return frontCamera;
	}
	public void setFrontCamera(int frontCamera) {
		this.frontCamera = frontCamera;
	}
	public String getVideoCamera() {
		return videoCamera;
	}
	public void setVideoCamera(String videoCamera) {
		this.videoCamera = videoCamera;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getHeadphoneJack() {
		return headphoneJack;
	}
	public void setHeadphoneJack(String headphoneJack) {
		this.headphoneJack = headphoneJack;
	}
	public String getLoudspeaker() {
		return loudspeaker;
	}
	public void setLoudspeaker(String loudspeaker) {
		this.loudspeaker = loudspeaker;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getHyperlink() {
		return hyperlink;
	}
	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}
	public int[] getBenchmarkRating() {
		return benchmarkRating;
	}
	public void setBenchmarkRating(int[] benchmarkRating) {
		this.benchmarkRating = benchmarkRating;
	}
	public int[] getRating() {
		return rating;
	}
	public void setRating(int[] rating) {
		this.rating = rating;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	//
	@Override
	public String toString() {
		return "Smartphone [brand=" + brand + ", model=" + model + ", price=" + price + ", size=" + size
				+ ", resolution=" + resolution + ", OperatingSystem=" + OperatingSystem + ", chipset=" + chipset
				+ ", CPU=" + CPU + ", GPU=" + GPU + ", RAM=" + RAM + ", internalStorage=" + internalStorage
				+ ", cardSlot=" + cardSlot + ", rearCamera=" + rearCamera + ", frontCamera=" + frontCamera
				+ ", videoCamera=" + videoCamera + ", audio=" + audio + ", headphoneJack=" + headphoneJack
				+ ", loudspeaker=" + loudspeaker + ", network=" + network + ", battery=" + battery
				+ ", batteryCapacity=" + batteryCapacity + ", dimensions=" + dimensions + ", weight=" + weight
				+ ", hyperlink=" + hyperlink + ", benchmarkRating=" + Arrays.toString(benchmarkRating) 
				+ ", rating=" + Arrays.toString(rating) + ", imageFile=" + imageFile + ", score=" + score + "]";
		
	}
	
}
	
