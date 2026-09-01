package ascii;

class ButtonB extends Button {

	public ButtonB(String text){
		super(text);
	}

	@Override
	public void display(){
		// taitaa olla unicode merkkejä mutta näyttää kivalta :))
		System.out.println("╔══════╗\n║" + text + "║\n╚══════╝\n");
	}
}
