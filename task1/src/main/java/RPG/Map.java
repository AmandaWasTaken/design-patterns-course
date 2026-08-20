package RPG;

public abstract class Map {

	private int w;
	private int h;
	private Tile[][] tile_map;


	public Map(int w, int h) {
		this.w = w;
		this.h = h;
		this.tile_map = new Tile[w][h];

		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				this.tile_map[i][j] = createTile();
			}
		}
	}

	abstract Tile createTile();
	public void display() {

		for(int i = 0; i < tile_map.length; i++){
			for(int j = 0; j < tile_map[i].length; j++){
				System.out.printf("%c ", tile_map[i][j].getCharacter());
			}
			System.out.println();
		}
	}
}
