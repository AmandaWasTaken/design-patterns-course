package game;

import java.util.List;
import java.util.ArrayList;

public class MeditateState extends State {
	
	public MeditateState(Machine machine){
		super(machine);
	}

	public void action(Character c){
		System.out.printf("%s is meditating. . .%n", c.name);
		if(c.hp == c.max_hp){
			System.out.println(". . .but they were already " +
					"at maximum health");
		} else {
			System.out.println("They gained 5 health points");
			if(c.hp + 5 > c.max_hp){
				c.hp += 0;
			} else {
				c.hp += 5;
			}
			System.out.printf("HP Left: %d/%d%n",
					c.hp, c.max_hp);
		}

		Formatter.print_character_status(c);
		System.out.println();
		List<String> options = new ArrayList<String>();

		options.add("Quit");
		options.add("Train");
		options.add("Meditate");
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
