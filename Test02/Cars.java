package AndroidDeveloperTest;

public class Cars extends Vehicles {
	@Override
	public int set_num_of_wheels() {
		
		return 4;
	}

	@Override
	public int set_num_of_passengers() {
		
		return 3;
	}

	@Override
	public boolean has_gas() {
		if(gasLevel > 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
