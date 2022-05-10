import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Guns {
	
	private int startingAmmo;
	private int ammo;
	private int damage;
	private int recoil;
	private int firingRate;
	private int distance;
	private String name;
	private Image img;
	private AffineTransform tx;
	private int x;
	private int y;
	private int vx;
	private int vy;
	private int time = 0;
	private String direction;
	private int xEnd;
	private int yEnd;

	
	public Guns() {
		
		name = "";
		ammo = 0;
		damage = 0;
		recoil = 0;
		firingRate = 0;
		distance = 0;
		startingAmmo = 0;
		x = 0;
		y = 0;
		vx = 0;
		vy = 0;
		img = getImage("PistolAmmo-01-01.png");
	}
	
	public Guns(int ammo, int damage, int recoil, int firingRate, int distance, String name, Image in) {
		
		x = 0;
		y = 0;
		vx = 0;
		vy = 0;
		startingAmmo = ammo;
		this.ammo = ammo;
		this.damage = damage;
		this.recoil = recoil;
		this.firingRate = firingRate;
		this.distance = distance;
		this.name = name;
		img = in;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
		xEnd = x + (int)(852/0.05);
		yEnd = y + (int)(178/0.05);
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

	public void fire(int vx, int vy, String direction) {
		x += vx;
		y += vy;
		update();
		this.direction = direction;
		//reset firing time to 0
		//enable this gun
	}
	
	public void paint(Graphics g) {
		xEnd = x + (int)(852/0.05);
		yEnd = y + (int)(178/0.05);
		
		Graphics2D g2 = (Graphics2D) g;
		if (direction.equals("right")) {
			g2.drawImage(img, tx, null);
		} else if (direction.equals("left")) {
			AffineTransform old = g2.getTransform();
			g2.rotate(Math.toRadians(180),x,y+10);
			g2.drawImage(img, tx, null);
			g2.setTransform(old);
			
		}else if (direction.equals("down")) {
			AffineTransform old = g2.getTransform();
			g2.rotate(Math.toRadians(90),x,y);
			g2.drawImage(img, tx, null);
			g2.setTransform(old);
			
		}else if (direction.equals("up")) {
			AffineTransform old = g2.getTransform();
			g2.rotate(Math.toRadians(270),x,y);
			g2.drawImage(img, tx, null);
			g2.setTransform(old);
			
		}
		
		System.out.println("Painting Gun");
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmmo() {
		return ammo;
	}


	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}


	public int getDamage() {
		return damage;
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}


	public int getRecoil() {
		return recoil;
	}


	public void setRecoil(int recoil) {
		this.recoil = recoil;
	}


	public int getFiringRate() {
		return firingRate;
	}


	public void setFiringRate(int firingRate) {
		this.firingRate = firingRate;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public void resetAmmo() {
		ammo += startingAmmo;
	}
	

	

	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.05, 0.05);
		xEnd = x + (int)(852/0.05);
		yEnd = y + (int)(178/0.05);
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.05, 0.05);
		xEnd = x + (int)(852/0.05);
		yEnd = y + (int)(178/0.05);
	}
	
	protected static Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Guns.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
}

class Uzi extends Guns{
	public Uzi() {
		super(100,5,2,50,200,"Uzi", getImage("PistolAmmo-01-01.png"));
	}
	
}


class Pistol extends Guns{
	public Pistol() {
		super(10000,15,5,100,400,"Pistol", getImage("PistolAmmo-01-01.png"));
	}
	
}


class Shotgun extends Guns{
	public Shotgun() {
		super(10,40,10,500,100,"Shotgun", getImage("ShotgunAmmo-01.png"));
	}
	
}


class Railgun extends Guns{
	public Railgun() {
		super(10,300,0,1500,2000,"Railgun", getImage("RailgunAmmo-01.png"));
	}
	
}


class Sniper extends Guns{
	public Sniper() {
		super(20,200,15,1000,700,"Sniper", getImage("SniperAmmo-01-01.png"));
	}
	
}


class AkFour extends Guns{
	public AkFour() {
		super(200,8,4,50,200,"AkFour", getImage("AkFourAmmo-01.png"));
	}
	
}


class Rocket extends Guns{
	public Rocket() {
		super(5,150,20,3000,300,"Rocket", getImage("RocketAmmo-01.png"));
	}
	
}








