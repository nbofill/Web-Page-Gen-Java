package model;

public class TagElement extends java.lang.Object implements Element {

	private java.lang.String tagName;
	private boolean endTag;
	private Element content;
	private java.lang.String attributes;
	private static boolean showId;
	private static int uniqueIdTracker = 1;
	private int uniqueId;

	TagElement(java.lang.String tagName, boolean endTag, Element content, 
			java.lang.String attributes) {
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.attributes = attributes;
		uniqueId = uniqueIdTracker;
		uniqueIdTracker++;
	}

	public int getId() {
		return uniqueId;
	}

	public java.lang.String getStringId() {
		return "\"" + tagName + uniqueId + "\"";
	}

	public java.lang.String getStartTag() {
		if (showId) {
			if(attributes != null) {
				return "<"+ tagName + " id=" + getStringId() + " " + attributes 
						+ ">";
			} else {
				return "<"+ tagName + " id=" + getStringId() + ">";
			}
		} else {
			if(attributes != null) {
				return "<" + tagName + " " + attributes + ">" ;

			} else {
				return "<" + tagName + ">" ;
			}
		}
	}

	public java.lang.String getEndTag() {
		if (endTag) {
			return "</" + tagName + ">"; 
		} else {
			return "";
		}
	}

	public void setAttributes(java.lang.String attributes) {
		this.attributes = attributes;
	}

	public static void resetIds() {
		uniqueIdTracker = 1;
	}

	public static void enableId(boolean choice) {
		if (choice) {
			showId = true;
		} else {
			showId = false;
		}
	}

	public String genHTML(int indentation) {
		String indent = Utilities.spaces(indentation);

		if(content == null) {
			return indent + getStartTag() + getEndTag();
		} else {
			return indent + getStartTag() + content.genHTML(0) + getEndTag();
		}
	}

}
