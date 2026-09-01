package ascii;

class TextFieldB extends TextField {
	
	public TextFieldB(String text){
		super(text);
	}

	@Override
	public void display(){
		System.out.println("╔════════════════╗\n    " + text + "\n╚════════════════╝");
	}
}
