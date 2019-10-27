package AndroidDeveloperTest;

public abstract class Vehicles {
	public int wheels;
	public int passengers;
	public int gasLevel;
	
	public abstract int set_num_of_wheels();
	public abstract int set_num_of_passengers();
	public abstract boolean has_gas();
}

