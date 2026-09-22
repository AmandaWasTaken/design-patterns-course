package game;

public class DeadState extends State {

	public DeadState(Machine machine){
		super(machine);
	}

	public void action(Character c){
		stats._print_stats(c);
		c.running = false;
	}
}
