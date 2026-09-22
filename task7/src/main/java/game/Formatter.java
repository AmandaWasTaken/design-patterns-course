package game;

public class Formatter {

	public static void _print_fmt(String s, int val){

		System.out.print(String.format("[%-5s%s\t]%-3s:%2s%d%n", 
		    "", s, "", "", val));

	}
	
	public static void _print_stats(Character c){

		if(c.is_alive){
			System.out.printf("%s has ended this quest%n", c.name);
		} else {
			System.out.printf("%s has died on their quest%n", c.name);
		}

		System.out.println("\n-------Final Stats-------");
		_print_fmt("Total Kills", c.kill_count);
		_print_fmt("Hitpoints Left", c.hp);
		_print_fmt("XP Collected", c.xp);
		System.out.println("-------------------------\n");
	}
} 
