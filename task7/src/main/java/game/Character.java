package game;

public class Character {

	public String name;
	public State level;
	public int xp = -5;
	public int hp = 15;
	public int kill_count = 0;
	public final int max_hp = 15;
	public boolean running = true;
	public boolean is_alive = true;

	public Character(String name){	
		this.name = name;
	}
}
