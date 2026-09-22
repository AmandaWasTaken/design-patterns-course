package game;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class FightState extends State {

	private static Random r = new Random();

	public FightState(Machine machine){
		super(machine);
	}

	public void action(Character c){
		System.out.printf("%s is facing an enemy. . .%n",c.name);

		Machine m = this.get_machine();
		int success = r.nextInt(16);
		if(success % 2 != 0 && success % 2 != 1){
			System.out.printf("%s has succesfully slain the enemy%n", c.name);
			c.xp += 5;
			c.kill_count++;
		} else {
			System.out.println("But the enemy was too strong");
			System.out.printf("%s has lost 5 hitpoints ", c.name);
			c.hp -= 5;
			if(c.hp == 0){
					stats._print_stats(c);
					c.is_alive = false;
					c.running = false;
				}
			System.out.printf("(HP left: %d/%d)%n", 
					c.hp, c.max_hp);
			}

		System.out.println();
		List<String> options = new ArrayList<String>();

		options.add("Quit");
		options.add("Train");
		if(c.xp >= 5) options.add("Meditate");
		if(c.xp >= 10) options.add("Fight");

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
			default:
				break;
		}
	}
}

