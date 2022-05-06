import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AmmoBox {
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;
	private int width;
	private int height;
	private Color color;
	
	private Image img; 	
	private AffineTransform tx;
	
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AmmoBox(int x, int y) {
		xStart = x;
		yStart = y;
		xEnd = x + 40;
		yEnd = y+ 42;
		
		img = getImage("AmmoBox-01.png"); 

		tx = AffineTransform.getTranslateInstance(xStart, yStart);
		init(xStart,yStart); 	
		
		
	}
	
	public void setImage(String file) {
		Image image = getImage(file);  
		img = image;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}
	
	private void update() {
		tx.setToTranslation(xStart, yStart);
		tx.scale(.1,.1);
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.1,.1);
	}
	
	public int getxStart() {
		return xStart;
	}

	public void setxStart(int xStart) {
		this.xStart = xStart;
	}

	public int getyStart() {
		return yStart;
	}

	public void setyStart(int yStart) {
		this.yStart = yStart;
	}

	public int getxEnd() {
		return xEnd;
	}

	public void setxEnd(int xEnd) {
		this.xEnd = xEnd;
	}

	public int getyEnd() {
		return yEnd;
	}

	public void setyEnd(int yEnd) {
		this.yEnd = yEnd;
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = AmmoBox.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
}



