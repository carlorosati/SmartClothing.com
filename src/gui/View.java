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
import javax.swing.JSlider;
import java.util.Hashtable;

class View {

	private JFrame frame;

	public JLabel editing;
	public JButton otherStyle1;
	public JButton otherStyle2;

	public JSlider colorSlider;

	private ImageIcon editingIcon;
	private ImageIcon otherStyle1Icon;
	private ImageIcon otherStyle2Icon;

	public String editingType;
	public String otherStyle1Type; 
	public String otherStyle2Type;

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

		// Set the types based on the above order
		editingType = new String("button");
		otherStyle1Type = new String("polo");
		otherStyle2Type = new String("v-neck");

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
		JPanel centerContainer = new JPanel(new BorderLayout());
		centerContainer.add(editing, BorderLayout.CENTER);

		// Add the color slider on the bottom of the screen
		colorSlider = new JSlider(JSlider.HORIZONTAL, 0, 4, 2);
		colorSlider.setSnapToTicks(true);
		colorSlider.setPaintTicks(true);
		colorSlider.setPaintLabels(true);
		colorSlider.setMajorTickSpacing(1);
		colorSlider.setMinorTickSpacing(1);
		centerContainer.add(colorSlider, BorderLayout.SOUTH);

		//Create the label table
		Hashtable<Integer,JLabel> labelTable = new Hashtable<Integer,JLabel>();
		labelTable.put( new Integer( 0 ), new JLabel("purple") );
		labelTable.put( new Integer( 1 ), new JLabel("white") );
		labelTable.put( new Integer( 2 ), new JLabel("red") );
		labelTable.put( new Integer( 3 ), new JLabel("blue") );
		labelTable.put( new Integer( 4 ), new JLabel("yellow") );
		colorSlider.setLabelTable( labelTable );

		frame.add(centerContainer);

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

	// Idk if we still need that shit aboooove lol
	public void switchToOtherStyle1() {
		ImageIcon temp = getEditingIcon();
		setEditingIcon(getOtherStyle1Icon());
		setOtherStyle1Icon(temp);

		// Change the editing to be one of the other style shirts
		String tempString = editingType;
		editingType = otherStyle1Type;
		otherStyle1Type = tempString;
	}

	public void switchToOtherStyle2() {
		ImageIcon temp = getEditingIcon();
		setEditingIcon(getOtherStyle2Icon());
		setOtherStyle2Icon(temp);

		// Change the editing to be one of the other style shirts
		String tempString = editingType;
		editingType = otherStyle2Type;
		otherStyle2Type = tempString;	}
}