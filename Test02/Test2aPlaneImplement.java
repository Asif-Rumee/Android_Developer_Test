package AndroidDeveloperTest;

public class Test2aPlaneImplement {

	public static void main(String[] args) {
		Plane boeing = new Plane();
		
		boeing.wheels = boeing.set_num_of_wheels();
		boeing.passengers = boeing.set_num_of_passengers();
		boeing.gasLevel = 0;
		
		System.out.println("No of wheels, passengers & gas availability: "+boeing.wheels+", "+boeing.passengers+" & "+boeing.has_gas());
	}

}
