package model;

import java.util.ArrayList;

public class ListElement extends TagElement {
	private ArrayList<Element> list;

	public ListElement(boolean ordered, java.lang.String attributes) {
		super(ordered ? "ol" : "ul", true, null, attributes);
		//uses ternary operator to determine if it is an ordered or unordered
		//list
		list = new ArrayList<Element>();
	}

	public void addItem(Element item) {
		list.add(item);
	}

	public java.lang.String genHTML(int indentation) {
		java.lang.String html;

		String indent = Utilities.spaces(indentation);

		html = indent + getStartTag();
		//generates the html for each element item in the array
		for(Element listItem: list) { 
			html += "\n" + indent + indent + "<li>\n"
					+ listItem.genHTML(indentation*3) + "\n" + indent 
					+ indent + "</li>";
		}

		html += "\n" + indent + getEndTag();
		return html;
	}
}
