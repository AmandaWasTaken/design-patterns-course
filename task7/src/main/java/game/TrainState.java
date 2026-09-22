package game;

import java.util.List;
import java.util.ArrayList;

public class TrainState extends State {

	public TrainState(Machine machine){
		super(machine);
	}

	public void action(Character c){

		c.xp += 3;
		System.out.printf("%s is training. . .%n", c.name);
		System.out.println("(Gained 3 XP points)");
		Formatter.print_character_status(c);

		System.out.println();
		List<String> options = new ArrayList<String>();
		options.add("Quit");
		options.add("Train");
		if(c.xp>= 12) options.add("Meditate");
		if(c.xp >= 15) options.add("Fight");
		Machine m = this.get_machine();

		switch(m.print_actions(options)){
			case 0:
				m.set_state(new QuitState(m));
				break;
			case 1:
				m.set_state(new TrainState(m));
				break;
			case 2:
				m.set_state(new MeditateState(m));
				break;
			case 3:
				m.set_state(new FightState(m));
				break;
		}
	}
} 
