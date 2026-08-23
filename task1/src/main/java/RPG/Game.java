package RPG;

import java.util.Random;

public class Game {

	public static Map createMap() {

		final int w = 5;
		final int h = 5;
		Random r = new Random();
		int choice = r.nextInt(10);

		return choice % 2 == 0 ? new CityMap(w, h) : new WildernessMap(w, h);

	}

	public static void main (String[] args) {		
		Map map = createMap();	
		map.display();	
	}
}
