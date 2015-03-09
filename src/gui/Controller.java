package gui;

import javax.swing.Icon;

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
		setEditing(model.getShirtOrNull("button-red"));
	}

	public void switchToOtherStyle1() {
		// ImageIcon temp = 
	}

	public void switchToOtherStyle2() {
		// ImageIcon temp = 
	}

	public void setEditing(Icon shirt) {
		view.setEditing(shirt);
		view.update();
	}

	/**
	 * Start the main program
	 */
	public static void main(String[] args)
	{
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
	}
}