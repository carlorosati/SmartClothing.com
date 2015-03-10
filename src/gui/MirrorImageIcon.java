package gui;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

class MirrorImageIcon extends ImageIcon {
	
	public MirrorImageIcon(String filePath) {

		// Call parent class default constructor
		super();

		BufferedImage bufferedImage = null;

		try
		{
			// Attempt to read in the image file
			bufferedImage = ImageIO.read(new File(filePath));

			// Flip the buffered image over the y-axis
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);

			// First translate the image over the y-axis
			tx.translate(-bufferedImage.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(
				tx,
				AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

			// Perform the transformation
			bufferedImage = op.filter(bufferedImage, null);

			// Set the image of the super class to the mirrored image
			super.setImage(bufferedImage);
		}
		catch (IOException e)
		{
			System.out.println("Exception " + e);
			e.printStackTrace();
		}
	}
}