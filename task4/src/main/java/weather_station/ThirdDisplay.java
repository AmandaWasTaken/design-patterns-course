package weather_station;

public class ThirdDisplay implements Observer {
	
	@Override
	public void update(double temp){
		System.out.printf("Current temperature (display 3): [%.2f°C]%n", temp);
	}
}
