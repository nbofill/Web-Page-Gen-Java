package model;

public class TextElement extends java.lang.Object implements Element {

	private java.lang.String text;

	public TextElement(java.lang.String text) {
		this.text = text;
	}

	@Override
	public String genHTML(int indentation) {
		String indent = Utilities.spaces(indentation);

		if(text == null) {
			return "";
		} else {
			return indent + text;
		}	
	}


}
