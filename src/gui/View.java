package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JSlider;
import java.util.List;
import javax.swing.Icon;

class View {

	private JFrame frame;

	public JLabel editing;
	public JButton otherStyle1;
	public JButton otherStyle2;

	private ImageIcon editingIcon;
	private ImageIcon otherStyle1Icon;
	private ImageIcon otherStyle2Icon;

	public void disableDefaultEffects(JButton b) {
		b.setBorder(BorderFactory.createEmptyBorder());
		b.setContentAreaFilled(false);
	}

	private void updateIcons() {
		editing = new JLabel(editingIcon);
		otherStyle1 = new JButton(otherStyle1Icon);
		otherStyle2 = new JButton(otherStyle2Icon);
	}

	public View() {

		// Initialize the shirt style icons
		editingIcon = new ImageIcon("src/images/button-icon.png");
		otherStyle1Icon = new ImageIcon("src/images/polo-icon.png");
		otherStyle2Icon = new ImageIcon("src/images/v-neck-icon.png");
		updateIcons();

		// Disable default effects
		disableDefaultEffects(otherStyle1);
		disableDefaultEffects(otherStyle2);

		// Create and title the main application frame
		this.frame = new JFrame( "SmartClothing.com" );

		// Exit the program when user closes the frame
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		frame.setLayout( new BorderLayout() );

		// Create the left panel button groups
		JLabel label = new JLabel("Fabric");

		String imagePath = new String("src/images/right-button.png");

		// Create arrow button from the image
		JButton right = new JButton(new ImageIcon(imagePath));
		JButton left = new JButton(new MirrorImageIcon(imagePath));

		// Turn off the default border and fill
		left.setBorder(BorderFactory.createEmptyBorder());
		left.setContentAreaFilled(false);
		right.setBorder(BorderFactory.createEmptyBorder());
		right.setContentAreaFilled(false);

		JPanel selector = new JPanel();		
		BoxLayout layout = new BoxLayout(selector, BoxLayout.X_AXIS);
		selector.setLayout(layout);

		imagePath = new String("src/images/polka-dot.jpg");
		JLabel pattern = new JLabel(new ImageIcon(imagePath));

		int x = 27;
		int y = 0;
		selector.add(Box.createRigidArea(new Dimension(44, 0)));
		selector.add(left);
		selector.add(Box.createRigidArea(new Dimension(x,y)));
		selector.add(pattern);
		selector.add(Box.createRigidArea(new Dimension(x,y)));
		selector.add(right);

		selector.setBackground(Color.BLACK);

		// Create the left hand side container
		JPanel leftContainer = new JPanel();
		layout = new BoxLayout(leftContainer, BoxLayout.Y_AXIS);
		leftContainer.setLayout(layout);

		leftContainer.add(Box.createVerticalGlue());
		JLabel fabricLabel = new JLabel("Fabric");
		fabricLabel.setForeground(Color.WHITE);
		leftContainer.add(fabricLabel);
		leftContainer.add(selector);

		JPanel selector2 = new JPanel();
		layout = new BoxLayout(selector2, BoxLayout.X_AXIS);
		selector2.setLayout(layout);

		pattern = new JLabel(new ImageIcon(imagePath));
		imagePath = new String("src/images/right-button.png");

		// Create new buttons
		right = new JButton(new ImageIcon(imagePath));
		left = new JButton(new MirrorImageIcon(imagePath));

		// Turn off the default border and fill
		left.setBorder(BorderFactory.createEmptyBorder());
		left.setContentAreaFilled(false);
		right.setBorder(BorderFactory.createEmptyBorder());
		right.setContentAreaFilled(false);

		selector2.add(Box.createRigidArea(new Dimension(44, 0)));
		selector2.add(left);
		selector2.add(Box.createRigidArea(new Dimension(x,y)));
		selector2.add(pattern);
		selector2.add(Box.createRigidArea(new Dimension(x,y)));
		selector2.add(right);


		selector2.setBackground(Color.BLACK);

		leftContainer.add(Box.createRigidArea(new Dimension(0, 36)));
		JLabel patternLabel = new JLabel("Pattern");
		patternLabel.setForeground(Color.WHITE);
		leftContainer.add(patternLabel);
		leftContainer.add(selector2);
		leftContainer.add(Box.createVerticalGlue());

		leftContainer.setBackground(Color.BLACK);
		frame.add(leftContainer, BorderLayout.WEST);

		// Setup the main clothing image area
		frame.add(this.editing);

		// Setup the clothing icon area

		JPanel rightContainer = new JPanel();
		layout = new BoxLayout(rightContainer, BoxLayout.Y_AXIS);
		rightContainer.setLayout(layout);

		rightContainer.add(Box.createVerticalGlue());

		rightContainer.add(this.otherStyle1);
		rightContainer.add(Box.createRigidArea(new Dimension(0, 31)));
		rightContainer.add(this.otherStyle2);

		rightContainer.add(Box.createVerticalGlue());

		rightContainer.setBackground(Color.BLACK);

		frame.add(rightContainer, BorderLayout.EAST);

		// Pack and show the main frame
		frame.pack();
		frame.setVisible(true);
	}

	public void update() {
		frame.pack();
	}

	// Setters

	public void setEditing(Icon shirt) {
		editing.setIcon(shirt);
	}

	public void setOtherStyle1(Icon shirt) {
		otherStyle1.setIcon(shirt);
	}

	public void setOtherStyle2(Icon shirt) {
		otherStyle2.setIcon(shirt);
	}

	public void setEditingIcon(ImageIcon shirt) {
		editingIcon = shirt;
	}

	public void setOtherStyle1Icon(ImageIcon shirt) {
		otherStyle1Icon = shirt;
		setOtherStyle1(shirt);
	}

	public void setOtherStyle2Icon(ImageIcon shirt) {
		otherStyle2Icon = shirt;
		setOtherStyle2(shirt);
	}

	// Getters

	public Icon getEditing() {
		return editing.getIcon();
	}

	public Icon getOtherStyle1() {
		return otherStyle1.getIcon();
	}

	public Icon getOtherStyle2() {
		return otherStyle2.getIcon();
	}

	public ImageIcon getEditingIcon() {
		return editingIcon;
	}

	public ImageIcon getOtherStyle1Icon() {
		return otherStyle1Icon;
	}

	public ImageIcon getOtherStyle2Icon() {
		return otherStyle2Icon;
	}
}