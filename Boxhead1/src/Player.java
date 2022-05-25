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

public class Player {
	private int x;
	private int y;
	private int xEnd;
	private int yEnd;
	private int width;
	private int height;
	private Color color;
	private String direction;
	private double health;

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

	public double getHealth() {
		return health;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	private Image img;
	private AffineTransform tx;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		
		update();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		update();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Player(int x, int y, String dir) {
		this.x = x;
		this.y = y;
		xEnd = x+60;
		yEnd = y+110;
		direction = dir;
		img = getImage("Player-01.png");
		health = 100;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);

	}

	public void setImage(String file) {
		Image image = getImage(file);
		img = image;
	}

	public void paint(Graphics g) {

		g.setColor(Color.green);
		g.fillRect(600, 800, (int) (health * 3), 30);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);


	}

	private void update() {
		tx.setToTranslation(x, y);
		xEnd = x+60;
		yEnd = y+110;
		tx.scale(.05, .05);

	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.05, .05);
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


