package game;

import java.util.Scanner;
import java.util.List;

public class Machine {

	private static Scanner sc = new Scanner(System.in);
	private State state;

	public Machine(){
		state = new InitialState(this);
	}

	public void start(Character c){
		while(c.running){
			Formatter.clear_screen();
			if(c.xp >= 25){
				System.out.println("You win!");
				state = new QuitState(this);
				return;
			}
			state.action(c);
		}
	}

	
	public void set_state(State s) { this.state = s; }

	public int print_actions(List<String> options){

		System.out.println("Choose an option:");
		for(int i = 0; i < options.size(); i++){
			System.out.print(i + ": ");
			System.out.println(options.get(i));
		}
		return sc.nextInt();
	}

	private void print_level(Character c){

		String level;
		if(c.xp >= 25){
			System.out.println("You win!");
			state = new QuitState(this);
			return;
		} else if(c.xp >= 15){
			level = "Expert";
		} else if(c.xp >= 12){
			level = "Intermediate";
		} else {
			level = "Novice";
		}
		System.out.printf("Current level: %s (%d XP)%n", level, c.xp);
	} 
}
