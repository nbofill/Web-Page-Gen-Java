package model;

public class TableElement extends TagElement{
	private Element[][] table;

	public TableElement(int rows, int cols, java.lang.String attributes) {
		super("table", true, null, attributes);
		//prevents error message from failing to successfully make 2d array
		if (rows < 0 || cols < 0) { 
			table = new Element[0][0];
		} else {
			table = new Element[rows][cols];
		}
	}	

	public void addItem(int rowIndex, int colIndex, Element item) {
		if(table.length == 0 || table[0].length == 0) {
			; //does not accept index greater than size or less than 0
		} else if(rowIndex > table.length - 1 
				|| colIndex > table[0].length - 1 
				|| rowIndex < 0 
				|| colIndex < 0) {
			;
		} else {
			table[rowIndex][colIndex] = item; 
		}
	}

	public double getTableUtilization() {
		if(table.length == 0 || table[0].length == 0) {
			return 100;
		}

		double cellsUsed = 0; 

		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				if (table[i][j] != null) {
					cellsUsed++;
				}
			}
		}

		return (cellsUsed / (table.length * table[0].length)) * 100;
	}

	public java.lang.String genHTML(int indentation) {
		String html;
		String indent = Utilities.spaces(indentation);

		html = indent + getStartTag() + "\n";
		//if the length of row or column is zero, the array does not possess
		//elements
		if(table.length == 0 || table[0].length == 0) {
			return html + indent + getEndTag();
		}

		for(int i = 0; i < table.length; i++) {
			html += indent + indent + "<tr>";
			for(int j = 0; j < table[0].length; j++) {
				if(table[i][j] != null) {
					html += "<td>" + table[i][j].genHTML(0) + "</td>";
				} else {
					html += "<td>" + "</td>";
				}
			}
			html += "</tr>" + "\n";
		}
		html += indent + getEndTag();
		return html;
	}
}
