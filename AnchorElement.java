package model;

public class AnchorElement extends TagElement{

	private java.lang.String url;
	private java.lang.String linkText;
	private String attributes;

	public AnchorElement(java.lang.String url, java.lang.String linkText,
			java.lang.String attributes) {
		super("a", true, null, attributes);
		this.url = url;
		this.linkText = linkText;
		this.attributes = attributes;
	}

	public java.lang.String getLinkText() {
		return linkText;
	}

	public java.lang.String getUrlText() {
		return url;
	}

	public java.lang.String genHTML(int indentation) {
		String indent = Utilities.spaces(indentation);

		if(attributes == null) { //calls setAttributes to put the href attribute
			setAttributes("href=" + "\"" + url + "\""); //before the other
		} else {										//attributes
			setAttributes("href=" + "\"" + url + "\" " + attributes);
		}

		return indent + getStartTag() + getLinkText() + getEndTag();
	}
}
