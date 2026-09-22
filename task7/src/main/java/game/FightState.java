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
		if(success % 2 == 0){
			c.xp += 7;
			System.out.printf("%s has succesfully slain the enemy%n", c.name);
			System.out.println("(Gained 7 XP points)");
			c.kill_count++;
		} else {
			System.out.println("But the enemy was too strong");
			System.out.printf("%s has lost 5 hitpoints ", c.name);
			c.hp -= 5;
			if(c.hp <= 0){
					c.is_alive = false;
					m.set_state(new DeadState(m));
					return;
			}
		}


		System.out.println();
		Formatter.print_character_status(c);

		List<String> options = new ArrayList<String>();

		options.add("Quit");
		options.add("Train");
		options.add("Meditate");
		options.add("Fight");

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
