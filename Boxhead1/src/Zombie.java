import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Zombie {
	private int x;
	private int y;
	private int vx;
	private int vy;
	private int width;
	private int height;
	private Color color;
	private int HP;
	
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
	
	public int getVX() {
		return vx;
	} 
	public void setVX(int vx) {
		this.vx = vx;
		update();
	}

	public int getVY() {
		return vy;
	}
	
	public void setVY(int vy) {
		this.vy = vy;
		update();
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

	public Zombie(int x, int y) {
		this.x = x;
		this.y = y;
		HP = 100;
		
		img = getImage("ZombieFront-01.png"); 

		tx = AffineTransform.getTranslateInstance(x, y);
		init(x,y); 	
		
		
	}
	
	public void paint(Graphics g) {
		
		x += vx;
		y += vy;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		g.setColor(Color.red);
		g.fillRect(x,y-10,60 - HP / 60,5);
		
		
	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.03,.03);
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.03,.03);
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Zombie.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
}



