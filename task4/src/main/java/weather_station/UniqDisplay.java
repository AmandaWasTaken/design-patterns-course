package weather_station;

public class UniqDisplay implements Observer {
	
	@Override
	public void update(double temp){
		System.out.printf("Current temperature (display 2): [%.2f°C]%n", temp);
	}
}
