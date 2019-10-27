package AndroidDeveloperTest;

public class Test2bVehiclesImplement {

	public static void main(String[] args) {
		Cars premio = new Cars();
		
		premio.gasLevel = 0;
		premio.wheels = premio.set_num_of_wheels();
		premio.passengers = premio.set_num_of_passengers();
		
		System.out.println("Car's No of wheels, passengers & gas availability: "+premio.wheels+", "+premio.passengers+" & "+premio.has_gas());
		
		Planes jet = new Planes();
		
		jet.gasLevel = 20;
		jet.wheels = jet.set_num_of_wheels();
		jet.passengers = jet.set_num_of_passengers();
		
		System.out.println("Plane's No of wheels, passengers & gas availability: "+jet.wheels+", "+jet.passengers+" & "+jet.has_gas());
	}

}
