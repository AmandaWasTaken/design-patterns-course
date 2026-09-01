package ascii;

public class Main {
	
	public static void main (String[] args) {
		
		UIFactory uf;

		uf = new BFactory();

		Button button = uf.create_button("Button");
		TextField tf = uf.create_textfield("Text field");
		Checkbox checkbox = uf.create_checkbox("Checkbox");

		button.display();
		System.out.println();
		checkbox.display();
		System.out.println();
		tf.display();
		
	}
}
