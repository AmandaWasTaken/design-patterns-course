package game;

public class QuitState extends State {

	public QuitState(Machine machine){
		super(machine);
	}

	public void action(Character c){	
		c.running = false;
		Formatter._print_stats(c);
	}
}
