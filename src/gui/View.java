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
import javax.swing.SwingConstants;

class View {

	private JFrame frame;

	public JLabel editing;
	public JButton otherStyle1;
	public JButton otherStyle2;

	public JLabel fabric;
	public JButton fabricArrowRight;
	public JButton fabricArrowLeft;
	public JLabel pattern;
	public JButton patternArrowRight;
	public JButton patternArrowLeft;

	public JSlider colorSlider;

	private ImageIcon editingIcon;
	private ImageIcon otherStyle1Icon;
	private ImageIcon otherStyle2Icon;

	public String editingType;
	public String otherStyle1Type; 
	public String otherStyle2Type;

	public ImageIcon plain;
	public ImageIcon diag;
	public ImageIcon weave;
	public ImageIcon dots;
	public ImageIcon stripes;

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

		// Load in the icon images
		String loc = "src/images/";
		plain = new ImageIcon(loc+"plain.png");
		dots = new ImageIcon(loc+"polka-dot.jpg");
		stripes = new ImageIcon(loc+"stripes.png");
		diag = new ImageIcon(loc+"diag.jpg");
		weave = new ImageIcon(loc+"weave.png");

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

		// Set the layout
		frame.setLayout(new BorderLayout());

		// Create arrow buttons and display for the fabric button group
		String imagePath = new String("src/images/right-button.png");
		fabricArrowRight = new JButton(new ImageIcon(imagePath));
		fabricArrowLeft = new JButton(new MirrorImageIcon(imagePath));

		// Create arrow buttons and display for the pattern button group
		patternArrowRight = new JButton(new ImageIcon(imagePath));
		patternArrowLeft = new JButton(new MirrorImageIcon(imagePath));

		// Turn off the default borders and fills
		disableDefaultEffects(fabricArrowRight);
		disableDefaultEffects(fabricArrowLeft);
		disableDefaultEffects(patternArrowRight);
		disableDefaultEffects(patternArrowLeft);

		// Create the left hand side container
		JPanel leftContainer = new JPanel();
		BoxLayout layout = new BoxLayout(leftContainer, BoxLayout.Y_AXIS);
		leftContainer.setBackground(Color.BLACK);
		leftContainer.setLayout(layout);
		leftContainer.add(Box.createVerticalGlue());

		// Add the fabric selector group
		fabric = new JLabel(plain);
		leftContainer.add(newCenteredText("Fabric"));
		leftContainer.add(newSelectorPanel(fabricArrowLeft, fabric, fabricArrowRight));

		// Add vertical spacing between the panels
		leftContainer.add(Box.createRigidArea(new Dimension(0, 42)));

		// Add the pattern selector group
		pattern = new JLabel(plain);
		leftContainer.add(newCenteredText("Pattern"));
		leftContainer.add(newSelectorPanel(patternArrowLeft, pattern, patternArrowRight));

		// Add the left container to the application frame
		leftContainer.add(Box.createVerticalGlue());
		frame.add(leftContainer, BorderLayout.WEST);

		// Setup the main clothing image area
		JPanel centerContainer = new JPanel(new BorderLayout());
		centerContainer.add(editing, BorderLayout.CENTER);

		// Add the color slider on the bottom of the screen
		int startIndex = 0;
		int endIndex = 4;
		int initPosition = 2;
		colorSlider = new JSlider(JSlider.HORIZONTAL, startIndex, endIndex, initPosition);
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

		// Add center container to the main application frame
		frame.add(centerContainer);

		// Setup the clothing icon area with a right container
		JPanel rightContainer = new JPanel();
		layout = new BoxLayout(rightContainer, BoxLayout.Y_AXIS);
		rightContainer.setBackground(Color.BLACK);
		rightContainer.setLayout(layout);
		rightContainer.add(Box.createVerticalGlue());

		// Add the shirt icons with spacing in between
		rightContainer.add(newWidenedPanel(otherStyle1));
		rightContainer.add(Box.createRigidArea(new Dimension(0, 42)));
		rightContainer.add(newWidenedPanel(otherStyle2));

		// Add the right container to the GUI
		rightContainer.add(Box.createVerticalGlue());
		frame.add(rightContainer, BorderLayout.EAST);

		// Pack and show the main frame
		frame.pack();
		frame.setVisible(true);
	}

	public void update() {
		frame.pack();
	}

	public JPanel newWidenedPanel(JButton button) {
		// Create the panel with a horizontal layout
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);

		int width = 30;
		int height = 0;

		// Add the button with rigid area on both sides
		panel.add(Box.createRigidArea(new Dimension(width, height)));
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(width, height)));

		// Set the background color to black
		panel.setBackground(Color.BLACK);

		return panel;
	}

	public JPanel newSelectorPanel(
		JButton leftArrow,
		JLabel display,
		JButton rightArrow
	) {
		// Create the panel with a horizontal box layout
		JPanel selectorPanel = new JPanel();		
		BoxLayout layout = new BoxLayout(selectorPanel, BoxLayout.X_AXIS);
		selectorPanel.setLayout(layout);

		int outerDistance = 37;
		int innerDistance = 27;
		int y = 0;

		// Add the panels with spacing
		selectorPanel.add(Box.createRigidArea(new Dimension(outerDistance, y)));
		selectorPanel.add(leftArrow);
		selectorPanel.add(Box.createRigidArea(new Dimension(innerDistance,y)));
		selectorPanel.add(display);
		selectorPanel.add(Box.createRigidArea(new Dimension(innerDistance,y)));
		selectorPanel.add(rightArrow);
		selectorPanel.add(Box.createRigidArea(new Dimension(outerDistance,y)));

		// Set background to black
		selectorPanel.setBackground(Color.BLACK);

		return selectorPanel;
	}

	public JPanel newCenteredText(String text) {
		// Create the text label
		JLabel fabricLabel = new JLabel(text, SwingConstants.CENTER);
		fabricLabel.setForeground(Color.WHITE);
		float newSize = 20;
		fabricLabel.setFont(fabricLabel.getFont().deriveFont(newSize));

		// Create the panel to hold the text
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);

		// Add the label and surround it with horizontal glue
		panel.add(Box.createHorizontalGlue());
		panel.add(fabricLabel, BorderLayout.CENTER);
		panel.add(Box.createHorizontalGlue());

		// Set the background color to black
		panel.setBackground(Color.BLACK);
		return panel;
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

	public void setFabric(String f) {
		if ("weave".equals(f)) {
			fabric.setIcon(weave);
		}
		else if ("diag".equals(f)) {
			fabric.setIcon(diag);
		}
		else {
			fabric.setIcon(plain);
		}
	}

	public void setPattern(String p) {
		if ("dots".equals(p)) {
			pattern.setIcon(dots);
		}
		else if ("stripes".equals(p)) {
			pattern.setIcon(stripes);
		}
		else {
			pattern.setIcon(plain);
		}
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