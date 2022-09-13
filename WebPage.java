package model;

import java.util.ArrayList;

public class WebPage extends java.lang.Object 
implements java.lang.Comparable<WebPage>{

	private java.lang.String title;
	ArrayList<Element> webPage;

	public WebPage(java.lang.String title) {
		this.title = title;
		webPage = new ArrayList<Element>();
	}

	public int addElement(Element element) {
		webPage.add(element);
		//returns id if the element is a TagElement, otherwise returns -1
		if(element instanceof TagElement) { 
			return ((TagElement) element).getId();
		} else {
			return -1;
		}
	}

	public java.lang.String getWebPageHTML(int indentation) {
		//first creates tagElements to simplify creation of final html
		TagElement tag = new TagElement("html", true, null, null);

		TagElement title = new TagElement("title", true, 
				new TextElement(this.title), null);

		TagElement head = new TagElement("head", true, null, null);

		String bodyContent = "";
		//creates the string for the body of the html
		for(Element webPageItem: webPage) {
			bodyContent += webPageItem.genHTML(0) + "\n";
		}

		TagElement body = new TagElement("body", true, null, null);	

		String indent = Utilities.spaces(indentation);

		String html = "<!doctype html>\n" + tag.getStartTag() + "\n" + indent 
				+ head.getStartTag() + "\n" + indent + indent 
				+ "<meta charset=\"utf-8\"/>\n" 
				+ title.genHTML(indentation*2) + "\n" + indent
				+ head.getEndTag() + "\n" + body.getStartTag() + "\n"
				+ bodyContent + body.getEndTag() + "\n" + tag.getEndTag();

		return html;

	}

	public void writeToFile(java.lang.String filename, int indentation) {
		Utilities.writeToFile(filename, getWebPageHTML(indentation));
	}

	public Element findElement(int id) {
		for(Element webPageItem: webPage) {
			if(webPageItem instanceof TagElement) {
				if(((TagElement) webPageItem).getId() == id) {
					return webPageItem;
				}
			}
		}
		return null;
	}

	public java.lang.String stats() {
		int paragraphItems = 0, listItems = 0, tableItems = 0;
		double tableUtil = 0;

		for(Element webPageItem: webPage) {
			if(webPageItem instanceof ParagraphElement) {
				paragraphItems++;
			} else if(webPageItem instanceof ListElement) {
				listItems++;
			} else if(webPageItem instanceof TableElement) {
				tableItems++;
				tableUtil += ((TableElement) webPageItem).getTableUtilization();
			}
		}

		return "List Count: " + listItems + "\nParagraph Count: "
		+ paragraphItems + "\nTable Count: " + tableItems
		+ "\nTableElement Utilization: " + tableUtil / tableItems;
	}

	@Override
	public int compareTo(WebPage o) {
		return title.compareTo(o.title);	
	}

	public static void enableId(boolean choice) {
		TagElement.enableId(choice);
	}

}
