package AndroidDeveloperTest;

public class Plane implements Vehicle{
	public int wheels;
	public int passengers;
	public int gasLevel;
	
	@Override
	public int set_num_of_wheels() {
		return 10;
	}
	
	@Override
	public int set_num_of_passengers() {
		return 150;
	}
	
	@Override
	public boolean has_gas(){
		if(gasLevel > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
