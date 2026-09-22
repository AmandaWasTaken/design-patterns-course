package game;

public class stats {

	public static void _format_stat(String s, int val){
			System.out.printf("[%-5s%s", "", s);
			System.out.printf("\t]%-4s:%3s%d%n", "", "", val);	
	}
	
	public static void _print_stats(Character c){

		if(c.is_alive){
			System.out.printf("%s has ended this quest%n", c.name);
		} else {
			System.out.printf("%s has died on their quest%n", c.name);
		}

		System.out.println("-------Final Stats-------");
		_format_stat("Total Kills", c.kill_count);
		_format_stat("Hitpoints Left", c.hp);
		_format_stat("XP Collected", c.xp);
	}
} 
