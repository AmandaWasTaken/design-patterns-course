package RPG;

import java.util.Random;

public class Game {

	public static Map createMap() {

		Random r = new Random();
		int choice = r.nextInt(10);
		return choice % 2 == 0 ? new CityMap(5, 5) : new WildernessMap(5, 5);

	}

	public static void main (String[] args) {		
		Map map = createMap();	
		map.display();	
	}
}
