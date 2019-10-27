package AndroidDeveloperTest;

public class Test2aCar implements Vehicle{
	private int wheels;
	private int passengers;
	private int gasLevel;
	
	@Override
	public int set_num_of_wheels() {
		return 4;
	}
	
	@Override
	public int set_num_of_passengers() {
		return 3;
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
	
	public static void main(String[] args) {
		Test2aCar toyota = new Test2aCar();
		toyota.wheels = toyota.set_num_of_wheels();
		toyota.passengers = toyota.set_num_of_passengers();
		toyota.gasLevel =20;
		
		System.out.println("No of wheels, passengers & gas availability: "+toyota.wheels+", "+toyota.passengers+" & "+toyota.has_gas());
	}
}
