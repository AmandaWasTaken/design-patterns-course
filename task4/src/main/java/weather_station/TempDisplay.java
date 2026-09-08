package weather_station;

public class TempDisplay implements Observer {
	
	@Override
	public void update(double temp){
		System.out.printf("Current temperature (Display 1): [%.2f°C]%n", temp);
	}
}
