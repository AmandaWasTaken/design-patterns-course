package ascii;

class BFactory extends UIFactory {

	@Override 
	public Button create_button(String text){
		return new ButtonB(text);
	}

	@Override 
	public Checkbox create_checkbox(String text) {
		return new CheckboxB(text);
	}

	@Override
	public TextField create_textfield(String text) {
		return new TextFieldB(text);
	}
}
