import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener{
	static final long serialVersionUID = 1L;
	
	WritableRaster wr;
	BufferedImage image;
	private int width;
	private int height;
	private boolean dragging = false;
	private Point lastPoint;
	private int xoffs = 0, yoffs = 0;
	private int zoomFactor = 1;
	private ArrayList listeners = new ArrayList();
	private Cursor prevCursor = null;
	
	public ImagePanel (int width, int height) {
		this.width = width;
		this.height = height;
		addMouseListener(this);
		addMouseMotionListener(this);
//		resetImage(width, height);
	}
	
	public void addImagePanelListener(ImagePanelListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
	
	public void mousePressed (MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			dragging = true;
			lastPoint = e.getPoint();
			setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		}
	}
	
	public void mouseClicked (MouseEvent e) {}
	
	public void mouseReleased (MouseEvent e) {
		if (dragging) {
			dragging = false;
			setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		}
	}
	
	public void mouseMoved (MouseEvent e) {
		if (!dragging) {
			if (image != null && !listeners.isEmpty()) {
				int image_x = e.getPoint().x - xoffs;
				int image_y = e.getPoint().y - yoffs;
				
				if (image_x > 0 && image_y > 0 && image_x < width && image_y < height) {
					image_x /= zoomFactor;
					image_y /= zoomFactor;
					Color c = new Color(image.getRGB(image_x, image_y));
//					System.out.println("pixel at [" + image_x + "," + image_y + "] = " + new Color(image.getRGB(image_x, image_y)) );
					Iterator iter = listeners.iterator();
					while (iter.hasNext()) {
						((ImagePanelListener)iter.next()).mouseMoved(image_x, image_y, c);
					}
				}
			}
		}
	}
	
	public void mouseDragged (MouseEvent e) {
		if (dragging) {
			xoffs += e.getPoint().x - lastPoint.x;
			yoffs += e.getPoint().y - lastPoint.y;
			lastPoint.setLocation(e.getPoint());
			repaint();
		}
	}
	
	public void mouseEntered (MouseEvent e) {
		prevCursor = getCursor();
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}
	
	public void mouseExited (MouseEvent e) {
		setCursor(prevCursor);
	}
	
	public void resetImage(int width, int height) {
		this.width = width;
		this.height = height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		int diff = getWidth() - width;
		if (diff > 0) {
			xoffs = diff / 2;
		}
		diff = getHeight() - height;
		if (diff > 0) {
			yoffs = diff / 2;
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void updateImage (int column, int row, Color c) {
		if (column < image.getWidth() && row < image.getHeight()) {
			image.setRGB(column, row, c.getRGB());
		}	
//		repaint();
	}
	
	public void setZoomFactor(int factor) {
		this.zoomFactor = factor;
		width = image.getWidth()*factor;
		height = image.getHeight()*factor;
		repaint();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.DARK_GRAY);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.LIGHT_GRAY);
		g2.drawRect(xoffs-1, yoffs-1, width+1, height+1);
		if (image != null) {
			
			
//			g2.drawImage(image, xoffs+movePoint.x, yoffs+movePoint.y, width, height, this);
			g2.drawImage(image, xoffs, yoffs, width, height, this);
		}
		
	}
}
