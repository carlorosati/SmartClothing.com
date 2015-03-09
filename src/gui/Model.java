package gui;

import java.util.Map;
import javax.swing.ImageIcon;
import java.util.HashMap;

class Model {

	private Map<String,ImageIcon> shirts;
	private String loc;

	public Model()
	{
		// Set the image resources location
		this.loc = new String("src/images/");

		// Initialize the Map of shirts here
		this.shirts = new HashMap<String,ImageIcon>();
		addShirt("button-red", ".jpg");
	}

	private void addShirt(String name, String extension) {
		shirts.put(name, new ImageIcon(loc+name+extension));
	}

	public ImageIcon getShirtOrNull(String key) {
		return shirts.get(key);
	}
}