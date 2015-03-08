package gui;

import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Source: stackoverflow.com
 * Title: Create a ImageIcon that is the mirror of another one
 * URL: http://stackoverflow.com/questions/1708011/create-a-imageicon-that-is-the-mirror-of-another-one
 */
class MirrorImageIcon extends ImageIcon {
	
	public MirrorImageIcon(String fileName) {
		super(fileName);
		// I don't have time to fix this now, but when the mouse is held
		// down on the image, it doesn't show the flipped image. I think this 
		// is b/c the paintIcon isn't called until the mouse is released. To
		// fix this I would flip the image in the constructor. idk how 2 do that	
		// Image i = super.getImage();
		// Graphics2D g2 = new Graphics2D();
	}

	@Override
	public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.translate(getIconWidth(), 0);
		g2.scale(-1, 1);
		super.paintIcon(c, g2, x, y);
	}
}