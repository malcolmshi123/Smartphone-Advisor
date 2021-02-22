
import java.util.Arrays;

public class User {
	
	private String name;
	private int [] weighting = new int [8];
	private int [] user =  new int [8];
	
	public User() {};
	
	public User(String name, int[] weighting, int[] user) {
		super();
		this.name = name;
		this.weighting = weighting;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getWeighting() {
		return weighting;
	}

	public void setWeighting(int[] weighting) {
		this.weighting = weighting;
	}

	public int[] getUser() {
		return user;
	}

	public void setUser(int[] user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", weighting=" + Arrays.toString(weighting) + ", user=" + Arrays.toString(user)
				+ "]";
	}
	
}
