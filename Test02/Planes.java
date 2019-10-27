package AndroidDeveloperTest;

public class Planes extends Vehicles {

	@Override
	public int set_num_of_wheels() {
		
		return 10;
	}

	@Override
	public int set_num_of_passengers() {
		
		return 150;
	}

	@Override
	public boolean has_gas() {
		
		if(this.gasLevel > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
}
