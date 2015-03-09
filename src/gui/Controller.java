package gui;

import javax.swing.ImageIcon;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller {

	private Model model;
	private View view;

	private String type;
	private String color;
	private String pattern;
	private String fabric;

	private String other1;
	private String other2;

	/**
	 * Controller constructor
	 */
	public Controller(Model model, View view)
	{
		this.model = model;
		this.view = view;

		type = new String("button");
		color = new String("red");
		pattern = new String("plain");
		fabric = new String("plain");

		other1 = new String("polo");
		other2 = new String("v-neck");
	}

	public void setEditing(ImageIcon shirt) {
		view.setEditing(shirt);
		view.update();
	}

	public void addListeners() {
		view.otherStyle1.addActionListener(new Style1Listener());
		view.otherStyle2.addActionListener(new Style2Listener());
	}

	/**
	 * Start the main program
	 */
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		controller.setEditing(model.getShirtOrNull("button-red-plain-plain"));
		controller.addListeners();
	}

	public void updateEditing() {
		setEditing(
			model.getShirtOrNull(
				type + "-"
				+ color + "-"
				+ pattern + "-"
				+ fabric
			)
		);
	}


	public class Style1Listener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			view.switchToOtherStyle1();

			String temp = type;
			type = other1;
			other1 = temp;

			updateEditing();
		}
	}

	public class Style2Listener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			view.switchToOtherStyle2();

			String temp = type;
			type = other2;
			other2 = temp;

			updateEditing();
		}
	}
}