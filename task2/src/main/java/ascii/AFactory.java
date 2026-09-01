package ascii;

class AFactory extends UIFactory {

	@Override 
	public Button create_button(String text){
		return new ButtonA(text);
	}

	@Override 
	public Checkbox create_checkbox(String text) {
		return new CheckboxA(text);
	}

	@Override
	public TextField create_textfield(String text) {
		return new TextFieldA(text);
	}
}
