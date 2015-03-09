package gui;

import java.util.Map;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Model {

	private Map<String,ImageIcon> shirts;
	private String loc;

	public List<String> colors;
	public List<String> patterns;
	public List<String> fabrics;
	public List<String> types;

	public Model()
	{
		// Set the image resources location
		this.loc = new String("src/images/shirts/");

		// Add all of the colors
		colors = new ArrayList<String>();
		colors.add("purple");
		colors.add("white");
		colors.add("red");
		colors.add("blue");
		colors.add("yellow");

		// Add all of the patterns
		patterns = new ArrayList<String>();
		patterns.add("plain");
		patterns.add("dots");
		patterns.add("stripes");

		// Add all of the fabrics
		fabrics = new ArrayList<String>();
		fabrics.add("plain");
		fabrics.add("diag");
		fabrics.add("weave");

		// Add all the types of the shirt styles
		types = new ArrayList<String>();
		types.add("polo");
		types.add("v-neck");
		types.add("button");

		// Initialize the Map of shirts here
		this.shirts = new HashMap<String,ImageIcon>();

		// Load in all of the 135 shirts
		for (String type : types) {
			for (String color : colors) {
				for (String pattern : patterns) {
					for (String fabric : fabrics) {
						addShirt(type + "-"
							+ color + "-"
							+ pattern + "-"
							+ fabric,
							".jpg"
						);
					}
				}
			}
		}
	}

	private void addShirt(String name, String extension) {
		ImageIcon icon = new ImageIcon(loc+name+extension);
		if (icon == null) {
			System.err.println("Ooops. missed one..");
		}
		shirts.put(name, icon);
	}
 
	public ImageIcon getShirtOrNull(String key) {
		return shirts.get(key);
	}
}