import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class NWSImageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// make colormap lookup table
		HashMap colorMap = new HashMap();
/*		colorMap.put(new Color(253, 253, 253), new Color(0, 0, 0));
		colorMap.put(new Color(152, 84, 198), new Color(12, 12, 12));
		colorMap.put(new Color(248, 0, 253), new Color(24, 24, 24));
		colorMap.put(new Color(188, 0, 0), new Color(36, 36, 36));
		colorMap.put(new Color(212, 0, 0), new Color(49, 49, 49));
		colorMap.put(new Color(253, 0, 0), new Color(61, 61, 61));
		colorMap.put(new Color(253, 139, 0), new Color(73, 73, 73));
		colorMap.put(new Color(229, 188, 0), new Color(85, 85, 85));
		colorMap.put(new Color(253, 248, 2), new Color(97, 97, 97));
		colorMap.put(new Color(0, 142, 0), new Color(109, 109, 109));
		colorMap.put(new Color(1, 197, 1), new Color(121, 121, 121));
		colorMap.put(new Color(2, 253, 2), new Color(134, 134, 134));
		colorMap.put(new Color(3, 0, 244), new Color(146, 146, 146));
		colorMap.put(new Color(1, 159, 244), new Color(158, 158, 158));
		colorMap.put(new Color(4, 233, 231), new Color(170, 170, 170));
		colorMap.put(new Color(100, 100, 100), new Color(182, 182, 182));
		colorMap.put(new Color(153, 153, 102), new Color(194, 194, 194));
		colorMap.put(new Color(204, 204, 153), new Color(206, 206, 206));
		colorMap.put(new Color(102, 51, 102), new Color(219, 219, 219));
		colorMap.put(new Color(153, 102, 153), new Color(231, 231, 231));
		colorMap.put(new Color(204, 153, 204), new Color(243, 243, 243));
		colorMap.put(new Color(204, 255, 255), new Color(255, 255, 255));*/
/*		colorMap.put(new Color(253, 253, 253), new Color(255, 255, 255));
		colorMap.put(new Color(152, 84, 198), new Color(243, 243, 243));
		colorMap.put(new Color(248, 0, 253), new Color(231, 231, 231));
		colorMap.put(new Color(188, 0, 0), new Color(219, 219, 219));
		colorMap.put(new Color(212, 0, 0), new Color(206, 206, 206));
		colorMap.put(new Color(253, 0, 0), new Color(194, 194, 194));
		colorMap.put(new Color(253, 139, 0), new Color(182, 182, 182));
		colorMap.put(new Color(229, 188, 0), new Color(170, 170, 170));
		colorMap.put(new Color(253, 248, 2), new Color(158, 158, 158));
		colorMap.put(new Color(0, 142, 0), new Color(146, 146, 146));
		colorMap.put(new Color(1, 197, 1), new Color(134, 134, 134));
		colorMap.put(new Color(2, 253, 2), new Color(121, 121, 121));
		colorMap.put(new Color(3, 0, 244), new Color(109, 109, 109));
		colorMap.put(new Color(1, 159, 244), new Color(97, 97, 97));
		colorMap.put(new Color(4, 233, 231), new Color(85, 85, 85));
		colorMap.put(new Color(100, 100, 100), new Color(73, 73, 73));
		colorMap.put(new Color(153, 153, 102), new Color(61, 61, 61));
		colorMap.put(new Color(204, 204, 153), new Color(49, 49, 49));
		colorMap.put(new Color(102, 51, 102), new Color(36, 36, 36));
		colorMap.put(new Color(153, 102, 153), new Color(24, 24, 24));
		colorMap.put(new Color(204, 153, 204), new Color(12, 12, 12));
		colorMap.put(new Color(204, 255, 255), new Color(0, 0, 0));*/
		colorMap.put(new Color(253, 253, 253), new Color(153, 0, 255));
		colorMap.put(new Color(152, 84, 198), new Color(153, 0, 255));
		colorMap.put(new Color(248, 0, 253), new Color(153, 0, 255));
		colorMap.put(new Color(188, 0, 0), new Color(153, 0, 255));
		colorMap.put(new Color(212, 0, 0), new Color(136, 17, 255));
		colorMap.put(new Color(253, 0, 0), new Color(119, 34, 255));
		colorMap.put(new Color(253, 139, 0), new Color(102, 51, 255));
		colorMap.put(new Color(229, 188, 0), new Color(85, 68, 255));
		colorMap.put(new Color(253, 248, 2), new Color(68, 85, 255));
		colorMap.put(new Color(0, 142, 0), new Color(51, 102, 255));
		colorMap.put(new Color(1, 197, 1), new Color(34, 119, 255));
		colorMap.put(new Color(2, 253, 2), new Color(17, 136, 255));
		colorMap.put(new Color(3, 0, 244), new Color(0, 153, 255));
		colorMap.put(new Color(1, 159, 244), new Color(27, 164, 255));
		colorMap.put(new Color(4, 233, 231), new Color(54, 175, 255));
//		colorMap.put(new Color(4, 233, 231), Color.red);
		colorMap.put(new Color(100, 100, 100), new Color(81, 186, 255));
		colorMap.put(new Color(153, 153, 102), new Color(108, 197, 255));
		colorMap.put(new Color(204, 204, 153), new Color(134, 208, 255));
		colorMap.put(new Color(102, 51, 102), new Color(161, 219, 255));
		colorMap.put(new Color(153, 102, 153), new Color(188, 230, 255));
		colorMap.put(new Color(204, 153, 204), new Color(215, 241, 255));
		colorMap.put(new Color(204, 255, 255), new Color(241, 252, 255));
/*		colorMap.put(new Color(253, 253, 253), new Color(241, 252, 255));
		colorMap.put(new Color(152, 84, 198), new Color(215, 241, 255));
		colorMap.put(new Color(248, 0, 253), new Color(188, 230, 255));
		colorMap.put(new Color(188, 0, 0), new Color(161, 219, 255));
		colorMap.put(new Color(212, 0, 0), new Color(134, 208, 255));
//		colorMap.put(new Color(254, 0, 0), new Color(108, 197, 255));
		colorMap.put(new Color(253, 0, 0), new Color(108, 197, 255));
		colorMap.put(new Color(253, 139, 0), new Color(81, 186, 255));
//		colorMap.put(new Color(253, 149, 0), new Color(81, 186, 255));
		colorMap.put(new Color(229, 188, 0), new Color(54, 175, 255));
		colorMap.put(new Color(253, 248, 2), new Color(27, 164, 255));
		colorMap.put(new Color(0, 142, 0), new Color(0, 153, 255));
		colorMap.put(new Color(1, 197, 1), new Color(17, 136, 255));
		colorMap.put(new Color(2, 253, 2), new Color(34, 119, 255));
		colorMap.put(new Color(3, 0, 244), new Color(51, 102, 255));
		colorMap.put(new Color(1, 159, 244), new Color(68, 85, 255));
		colorMap.put(new Color(4, 233, 231), new Color(85, 68, 255));
		colorMap.put(new Color(100, 100, 100), new Color(102, 51, 255));
		colorMap.put(new Color(153, 153, 102), new Color(119, 34, 255));
		colorMap.put(new Color(204, 204, 153), new Color(136, 17, 255));
		colorMap.put(new Color(102, 51, 102), new Color(153, 0, 255));
		colorMap.put(new Color(153, 102, 153), new Color(153, 0, 255));
		colorMap.put(new Color(204, 153, 204), new Color(153, 0, 255));
		colorMap.put(new Color(204, 255, 255), new Color(153, 0, 255));
*/
		// read in the image
		BufferedImage originalImage = ImageIO.read(new File(args[0]));
		BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		// for each pixel 
		int count = 0;
		int total_pixels = originalImage.getHeight() * originalImage.getWidth();
		
//		Color gray = new Color(230, 230, 230);
		Color targetColor = new Color(4, 233, 231);
		
//		String writers[] = ImageIO.getWriterFormatNames();
//		for (int i = 0; i < writers.length; i++) {
//			System.out.println(i + " - " + writers[i]);
//		}
		
		for (int row = 0; row < originalImage.getHeight(); row++) {
			for (int col = 0; col < originalImage.getWidth(); col++) {
				// read pixel color 	
				Color currentColor = new Color(originalImage.getRGB(col, row));
				
				Color newColor = (Color)colorMap.get(currentColor);
								
//				if (currentColor.equals(targetColor)) {
//					System.out.println("replacing " + currentColor.toString() + " with " + newColor.toString());
//				}
				
				// replace pixel with new color map
				if (newColor != null) {
					newImage.setRGB(col, row, newColor.getRGB());
				} else {
					newImage.setRGB(col, row, currentColor.getRGB());
//					originalImage.setRGB(col, row, Color.black.getRGB());
				}
//				System.out.println((++count) + " / " + total_pixels + " pixels set");
			}
		}
		
		ImagePanel imagePanel = new ImagePanel(originalImage.getWidth(), originalImage.getHeight());
		imagePanel.setPreferredSize(new Dimension(originalImage.getWidth(), originalImage.getHeight()));
		imagePanel.setBorder(BorderFactory.createEtchedBorder());
		imagePanel.resetImage(originalImage.getWidth(), originalImage.getHeight());
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		for (int row = 0; row < originalImage.getHeight(); row++) {
			for (int col = 0; col < originalImage.getWidth(); col++) {
				imagePanel.updateImage(col, row, new Color(newImage.getRGB(col, row)));
			}
		}

		// write the image to disk
		ImageIO.write(newImage, "png", new File(args[1]));
	}

}
