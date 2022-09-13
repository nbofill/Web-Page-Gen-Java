package model;

public class HeadingElement extends TagElement {

	public HeadingElement(Element content, int level, java.lang.String 
			attributes) {
		super("h" + level, true, content, attributes);
		//adds level to the h tag
	}
}
