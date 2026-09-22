package game;

public abstract class State {	
	
	private Machine machine;

	public State(Machine machine){
		this.machine = machine;
	}

	public Machine get_machine() { return machine; }

	abstract void action(Character c);
}
