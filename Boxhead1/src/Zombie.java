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
	private double x;
	private double y;
	private double vx;
	private double vy;
	private int width;
	private int height;
	private Color color;
	private int HP;
	private double xEnd;
	private double yEnd;
	private Image img; 	
	private Image img2;
	private AffineTransform tx;
	private AffineTransform tx2;
	private boolean isHit;
	private String type;
	
	
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean isHit() {
		return isHit;
	}

	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		update();
	}

	public double getY() {
		return y;
	}
	
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public double getxEnd() {
		return xEnd;
	}

	public void setxEnd(double xEnd) {
		this.xEnd = xEnd;
	}

	public double getyEnd() {
		return yEnd;
	}

	public void setyEnd(double yEnd) {
		this.yEnd = yEnd;
	}

	public double getVX() {
		return vx;
	} 
	public void setVX(double vx) {
		this.vx = vx;
		update();
	}

	public double getVY() {
		return vy;
	}
	
	public void setVY(double vy) {
		this.vy = vy;
		update();
	}

	public void setY(double y) {
		this.y = y;
		update();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Zombie(int x, int y) {
		this.x = x;
		this.y = y;
		xEnd = x + 56;
		yEnd = y + 94;
		HP = 100;
		isHit = false;
		img = getImage("ZombieFront-01.png"); 
		img2 = getImage("splatter.gif");
		tx = AffineTransform.getTranslateInstance(x, y);
		tx2 =  AffineTransform.getTranslateInstance(x, y);
		init(x,y); 	
		type = "Zombie";
		
		
	}
	public Zombie(int x, int y, int z) {
		this.x = x;
		this.y = y;
		xEnd = x + 56;
		yEnd = y + 94;
		HP = 100;
		isHit = false;
		img = getImage("Devil-01.png");
		img2 = getImage("splatter.gif");
		tx = AffineTransform.getTranslateInstance(x, y);
		tx2 =  AffineTransform.getTranslateInstance(x, y);
		init(x,y); 	
		type = "Devil";
		
		
	}
	
	int timer = 0;
	public void paint(Graphics g) {
		
		x += vx;
		y += vy;
		xEnd = x + 56;
		yEnd = y + 94;
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		if (isHit == true ) {
			tx2.setToTranslation(x-300, y-210);
			//tx2.scale(5,5);
			g2.drawImage(img2,tx2,null);
			timer+=16;
			if(timer>=500) {
			isHit = false;
			timer = 0;
			}
		}
		g.setColor(Color.red);
		g.fillRect((int)x,(int)y-10,HP,5);
		
		
	}
	
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.03,.03);
		xEnd = x + 56;
		yEnd = y + 94;
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.03,.03);
		xEnd = x + 56;
		yEnd = y + 94;
	}
	
	protected static Image getImage(String path) {
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

 class Devil extends Zombie {

	// 29 by 67

	public Devil(int x, int y, int z) {
		super(x,y, 0);
		//Image img = getImage("Devil.png"); 
		super.setyEnd(y+67);
		super.setxEnd(x+29);
		super.setHP(200);
		
	}
	
	
	
	
	
}







