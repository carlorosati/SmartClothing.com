package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

class DisplayImageTest {
	
	private static final String IMG_PATH = "src/images/img.png";

	public static void main(String[] args) {

		try
		{
			BufferedImage img = ImageIO.read( new File( IMG_PATH ) );
			ImageIcon icon = new ImageIcon( img );
			JLabel label = new JLabel( icon );
			JOptionPane.showMessageDialog( null, label );
		}
		catch ( Throwable t )
		{
			System.out.println("Exception " + t);
	        t.printStackTrace();
		}

		// JFrame frame = new JFrame();
		
	}

}