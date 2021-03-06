package gui;

import javax.swing.ImageIcon;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

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
		view.colorSlider.addChangeListener(new ColorSliderListener());
		view.fabricArrowLeft.addActionListener(new FabricListenerLeft());
		view.fabricArrowRight.addActionListener(new FabricListenerRight());
		view.patternArrowLeft.addActionListener(new PatternListenerLeft());
		view.patternArrowRight.addActionListener(new PatternListenerRight());
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

	public class FabricListenerLeft implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int fabricIndex = model.fabrics.indexOf(fabric);
			if (fabricIndex == 0) {
				fabric = model.fabrics.get(model.fabrics.size()-1);
			}
			else {
				fabric = model.fabrics.get(fabricIndex-1);
			}
			view.setFabric(fabric);
			updateEditing();
		}
	}

	public class FabricListenerRight implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int fabricIndex = model.fabrics.indexOf(fabric);
			if (fabricIndex+1 == model.fabrics.size()) {
				fabric = model.fabrics.get(0);
			}
			else {
				fabric = model.fabrics.get(fabricIndex+1);
			}
			view.setFabric(fabric);
			updateEditing();
		}
	}


	public class PatternListenerLeft implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int patternIndex = model.patterns.indexOf(pattern);
			if (patternIndex == 0) {
				pattern = model.patterns.get(model.patterns.size()-1);
			}
			else {
				pattern = model.patterns.get(patternIndex-1);
			}
			view.setPattern(pattern);
			updateEditing();
		}
	}

	public class PatternListenerRight implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int patternIndex = model.patterns.indexOf(pattern);
			if (patternIndex+1 == model.patterns.size()) {
				pattern = model.patterns.get(0);
			}
			else {
				pattern = model.patterns.get(patternIndex+1);
			}
			view.setPattern(pattern);
			updateEditing();
		}
	}

	public class ColorSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			if (!source.getValueIsAdjusting()) {
				int colorIndex = (int) source.getValue();
				color = model.colors.get(colorIndex);
				updateEditing();
			}
		}
	}
}