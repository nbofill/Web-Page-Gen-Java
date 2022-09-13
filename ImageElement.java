package model;

public class ImageElement extends TagElement {
	private java.lang.String imageURL;

	public ImageElement(java.lang.String imageURL, int width, int height,
			java.lang.String alt,
			java.lang.String attributes) {
		super("img", false, null, attributes);
		this.imageURL = imageURL;
		
		setAttributes("src=\"" + imageURL + "\" width=\"" + width 
				+"\" height=\"" + height + "\" alt=\""+ alt
				+ "\"");
		//changes the given attributes into an appropriate set of attributes
		//for an image
	}

	public java.lang.String getImageURL() {
		return imageURL;
	}
}
