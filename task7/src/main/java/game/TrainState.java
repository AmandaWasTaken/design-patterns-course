package game;

import java.util.List;
import java.util.ArrayList;

public class TrainState extends State {

	public TrainState(Machine machine){
		super(machine);
	}

	public void action(Character c){
		System.out.printf("%s is training. . .%n", c.name);
		System.out.println("Character gained 5 xp points");
		c.xp += 5;
		System.out.printf("XP: %d%n", c.xp);

		System.out.println();
		List<String> options = new ArrayList<String>();
		options.add("Quit");
		options.add("Train");
		if(c.xp >= 5) options.add("Meditate");
		if(c.xp >= 10) options.add("Fight");
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
