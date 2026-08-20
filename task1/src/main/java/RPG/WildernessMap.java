package RPG;

import java.util.Random;

public class WildernessMap extends Map {
	

	public WildernessMap(int w, int h){
		super(w, h);
	}

	@Override
	Tile createTile() {

		Tile t = null;

		Random r = new Random();
		int idx = r.nextInt(3);
		switch(idx) {
			case 0:
				t = new SwampTile();
				break;
			case 1:
				t = new WaterTile();
				break;
			case 2:
				t = new ForestTile();
				break;
			default: break;
		}	
		return t;
	}
}
