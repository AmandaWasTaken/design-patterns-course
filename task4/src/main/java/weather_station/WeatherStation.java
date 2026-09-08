package weather_station;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class WeatherStation implements Runnable {
	
	private List<Observer> observers = new ArrayList<>(); 
	private double temp;
	private final double MIN_TEMP;
	private final double MAX_TEMP;

	private Random rand;

	public WeatherStation(double temp, double min, double max){
		rand = new Random();
		this.MIN_TEMP = min;
		this.MAX_TEMP = max;
		this.temp = rand.nextDouble(MAX_TEMP - MIN_TEMP) + MIN_TEMP;
	}

	public synchronized void register_observer(Observer o){
		observers.add(o);
	}

	public synchronized void remove_observer(Observer o){
		observers.remove(o);
	}

	private synchronized void notify_observers(){
		for(Observer o : observers){
			o.update(temp);
		}
	}
	
	private void update_temp(){
		
		double change = rand.nextDouble(2.5);
		int sign = rand.nextInt(16) % 2 == 0 ? 1 : -1;

		temp += sign * change;
		temp = Math.max(MIN_TEMP, Math.min(temp, MAX_TEMP));
	}

	@Override
	public void run(){

		while(true){
			try {
				update_temp();
				notify_observers();
				int delay = rand.nextInt(5000) + 1;
				Thread.sleep(delay);
				
			} catch(InterruptedException e){
				System.out.println("Interruption detected: " + e.toString());
			}
		}
	}
}




