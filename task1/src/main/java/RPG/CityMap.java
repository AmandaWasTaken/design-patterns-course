package RPG;
import java.util.Random;

public class CityMap extends Map {

	public CityMap(int w, int h){
		super(w, h);
	}

	@Override
	Tile createTile() {

		Tile t = null; // this is probably stupid
		Random r = new Random();
		
		int idx = r.nextInt(3);
		switch(idx){
			case 0:
				t = new RoadTile();
				break;
			case 1:
				t = new ForestTile();
				break;
			case 2:
				t = new BuildingTile();
				break;
			default: break;
		}	
		return t;
	}
}
