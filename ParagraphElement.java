package model;

import java.util.ArrayList;

public class ParagraphElement extends TagElement {
	private ArrayList<Element> paragraph;

	public ParagraphElement(java.lang.String attributes) {
		super("p", true, null, attributes);
		paragraph = new ArrayList<Element>();
	}

	public void addItem(Element item) {
		paragraph.add(item);
	}

	public java.lang.String genHTML(int indentation) {
		String html;

		String indent = Utilities.spaces(indentation);

		html = indent + getStartTag() + "\n";
		//generates html for each element in the arrayList
		for(Element paragraphItem: paragraph) {
			html += paragraphItem.genHTML(indentation + 3) + "\n";
		}

		html +=  indent + getEndTag();

		return html;
	}
}
