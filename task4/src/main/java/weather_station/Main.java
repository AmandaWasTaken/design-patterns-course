package weather_station;

import java.util.List;
import java.util.Random;

class Main {

	public static void main (String[] args) throws InterruptedException {

		Random rand = new Random();

		WeatherStation station = new WeatherStation(15.0, -30, 45);
		TempDisplay  display1  = new TempDisplay();
		UniqDisplay  display2  = new UniqDisplay();
		ThirdDisplay display3  = new ThirdDisplay();

		station.register_observer(display1);
		station.register_observer(display2);
		station.register_observer(display3);

		Thread station_thread = new Thread(station);
		station_thread.start();

		int delay = rand.nextInt(10000) + 1;
		Thread.sleep(delay);
		station.remove_observer(display2);
		System.out.println("Removed display 2");	
	}
}
