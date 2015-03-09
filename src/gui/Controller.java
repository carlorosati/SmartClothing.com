package gui;

import javax.swing.ImageIcon;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller {

	private Model model;
	private View view;

	/**
	 * Controller constructor
	 */
	public Controller(Model model, View view)
	{
		this.model = model;
		this.view = view;
	}

	public void switchToOtherStyle1() {
		ImageIcon temp = view.getEditingIcon();
		view.setEditingIcon(view.getOtherStyle1Icon());
		view.setOtherStyle1Icon(temp);
	}

	public void switchToOtherStyle2() {
		ImageIcon temp = view.getEditingIcon();
		view.setEditingIcon(view.getOtherStyle2Icon());
		view.setOtherStyle2Icon(temp);
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
		controller.setEditing(model.getShirtOrNull("button-red"));
		controller.addListeners();
	}


	public class Style1Listener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			switchToOtherStyle1();
		}
	}

	public class Style2Listener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			switchToOtherStyle2();
		}
	}
}