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

public class Map {
	private int x;
	private int y;

	private Image img; 	
	private AffineTransform tx;
	


	public Map() {
		x = 0;
		y = 0;
		
		img = getImage("Map.png"); 

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x,y); 	
		
		
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
		tx.setToTranslation(x, y);
		tx.scale(1,1);
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1,1);
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
}



