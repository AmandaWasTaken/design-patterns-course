package ascii;

abstract class UIElement {

	protected String text;

	public UIElement(String text) { this.text = text; }

	public void set_text(String text) { this.text = text; }

	public abstract void display();

}
