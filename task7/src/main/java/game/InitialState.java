package game;

import java.util.List;
import java.util.ArrayList;

public class InitialState extends State {

	public InitialState(Machine machine){
		super(machine);
	}

	public void action(Character c){

		System.out.printf("%s has begun a new adventure!%n", c.name);

		List<String> options = new ArrayList<String>();
		options.add("Quit");
		options.add("Train");

		Machine m = this.get_machine();

		switch(m.print_actions(options)){
			case 0:
				m.set_state(new QuitState(m));
				break;
			case 1:
				m.set_state(new TrainState(m));
				break;
			default:
				System.out.println("Invalid option!");
				break;
		}
	}
}
