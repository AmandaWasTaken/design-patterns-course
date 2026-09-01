package ascii;

abstract class UIFactory {
	
	public abstract Button create_button(String text);
	public abstract TextField create_textfield(String text);
	public abstract Checkbox create_checkbox(String text);
}
