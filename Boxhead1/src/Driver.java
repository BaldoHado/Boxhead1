import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MenuKeyListener;
 
public class Driver extends JPanel implements KeyListener, ActionListener{

	private int shiftValsX;
	private int shiftValsY;
	private Player p1;
	private Map m;
	private Devil devil;
	private ArrayList<AmmoBox> ab = new ArrayList<AmmoBox>();
	private ArrayList<Guns> guns = new ArrayList<Guns>();
	private int gunIndex;

	private boolean firing;
	private int curDist;
	private long fireTime;
	private long firstShot;
	private int startBulletX;
	private String bulDir;
	//Luke code//
		private int round = 1;
		private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
		
		//


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Driver d  = new Driver();
	}
	
	public void paint(Graphics g) {
		Guns curGun = guns.get(gunIndex);
		fireTime = (long)guns.get(gunIndex).getFiringRate();
		
		
		m.paint(g);
		//System.out.println(curGun.getName());
		p1.setY(p1.getY()+shiftValsY);
		p1.setX(p1.getX()+shiftValsX);
		g.drawString(curGun.getName() + " : " + curGun.getAmmo(),p1.getX(),p1.getY()-30);
		if (inWall(p1.getX(),p1.getY()) == true || inWall(p1.getxEnd(),p1.getyEnd()) == true) {
			shiftValsX = 0;
			shiftValsY = 0;
		}
		for (AmmoBox b : ab) {
			b.paint(g);
		}

		//spawn zombie
		for(Zombie thisZomb : zombies) {
			
			thisZomb.paint(g);
			
		
	}
	
	for(Zombie thisZomb : zombies) {
		if(Math.abs(p1.getX() - thisZomb.getX()) < 20){
			thisZomb.setVX(0);
		} else {
			if(p1.getX() < thisZomb.getX() ) {
			thisZomb.setVX(-1);
			//System.out.println("move left");
		}
		
		if(p1.getX() > thisZomb.getX()) {
			thisZomb.setVX(1);
			//System.out.println("move right");
		} 
		}
		if(Math.abs(p1.getY() - thisZomb.getY()) < 20){
			thisZomb.setVY(0);
		} else {
			if(p1.getY() < thisZomb.getY()) {
			thisZomb.setVY(-1);
			//System.out.println("move up");
		} 
		if(p1.getY() > thisZomb.getY()) {
			thisZomb.setVY(1);
			//System.out.println("move down");
		}
		

			if (p1.getX() > thisZomb.getX() && p1.getX() < thisZomb.getX() + 40 || p1.getxEnd() > thisZomb.getX() && p1.getxEnd() < thisZomb.getX() + 40) {
				if (p1.getY() > thisZomb.getY() && p1.getY() < thisZomb.getY() + 60 || p1.getyEnd() > thisZomb.getY() && p1.getyEnd() < thisZomb.getY() + 60) {
					System.out.println("zombie on player");
					p1.setHealth(p1.getHealth()-4);
				}
				if (p1.getY() < thisZomb.getY() && p1.getyEnd() > thisZomb.getY() + 60) {
					System.out.println("zombie on player");
					p1.setHealth(p1.getHealth()-4);
				}
			}
			if (p1.getY() > thisZomb.getY() && p1.getY() < thisZomb.getY() + 60|| p1.getyEnd() > thisZomb.getY() && p1.getyEnd() < thisZomb.getY() + 60) {
			if (p1.getX() < thisZomb.getX() && p1.getxEnd() > thisZomb.getX()+ 40) {
				System.out.println("zombie on player");
				p1.setHealth(p1.getHealth()-4);
			}
		}
			
	
}

		//devil code
				if(Math.abs(p1.getX() - devil.getX()) < 150){
					devil.setVX(0);
				} else {
					if(p1.getX() < devil.getX() ) {
					devil.setVX(-1);
					//System.out.println("move left");
				}
				
				if(p1.getX() > devil.getX()) {
					devil.setVX(1);
					//System.out.println("move right");
				} 
				}
				if(Math.abs(p1.getY() - devil.getY()) < 150){
					devil.setVY(0);
				} else {
					if(p1.getY() < devil.getY()) {
					devil.setVY(-1);
					//System.out.println("move up");
				} 
				if(p1.getY() > devil.getY()) {
					devil.setVY(1);
					//System.out.println("move down");
				}
				}
		
				p1.paint(g);
				devil.paint(g);
				
			
		//pixels of the shooting
		//System.out.println("Duration " + (System.currentTimeMillis()-firstShot));
		if (firing == true) {
			if (bulDir.equals("right")) {
				p1.setDirection("right");
			}
			if (bulDir.equals("up")) {
				p1.setDirection("up");
			}
			if (bulDir.equals("left")) {
				p1.setDirection("left");
			}
			if (bulDir.equals("down")) {
				p1.setDirection("down");
				System.out.println("changing to down");
			}
			if (p1.getDirection().equals("right")) {
				//g.setColor(Color.BLACK);
				//g.fillRect(p1.getX()+60, p1.getY()+42, curGun.getDistance(), 2);
				//g.fillRect(p1.getX()+60, p1.getY()+46, curGun.getDistance(), 2);
				
				
				//firing = false;
				System.out.println("Starting");
				if (startBulletX == 0) {
					curGun.setX(p1.getX()+60);
					curGun.setY(p1.getY()+42);
					startBulletX = p1.getX()+60;

				}
				
				if (Math.abs(startBulletX - curGun.getX()) < curGun.getDistance()) {
					//curGun.fire(5, 0, "right");
					System.out.println("curgun x " + curGun.getX());
					curGun.fire(40,0,"right");
					curGun.paint(g);
					bulDir = "right";
					
//					for (Zombie tz : zombies) {
//						if (curGun.)
//					}
					
				} else {
					firstShot = System.currentTimeMillis();
					curGun.setAmmo(curGun.getAmmo()-1);
					startBulletX = 0;
					firing = false;
					bulDir = "";
				}
				
				
				//System.out.println("AMMO " + curGun.getAmmo());
			}
			
			if (p1.getDirection().equals("left")) {
				System.out.println("Starting");
				if (startBulletX == 0) {
					curGun.setX(p1.getX());
					curGun.setY(p1.getY()+42);
					startBulletX = p1.getX();
					
				}
				
				if (Math.abs(startBulletX - curGun.getX()) < curGun.getDistance()) {
					//curGun.fire(5, 0, "right");
					System.out.println("curgun x " + curGun.getX());
					curGun.fire(-40,0,"left");
					curGun.paint(g);
					bulDir = "left";
					
				} else {
					firstShot = System.currentTimeMillis();
					curGun.setAmmo(curGun.getAmmo()-1);
					startBulletX = 0;
					firing = false;
					bulDir = "";
				}
//				g.setColor(Color.BLACK);
//				g.fillRect(p1.getX()-curGun.getDistance(), p1.getY()+42, curGun.getDistance(), 2);
//				g.fillRect(p1.getX()-curGun.getDistance(), p1.getY()+46, curGun.getDistance(), 2);
				//curGun.setAmmo(curGun.getAmmo()-1);
				//firstShot = System.currentTimeMillis();
//				curGun.fire(p1.getX()+60, p1.getY()+42, "left");
//				curGun.paint(g);
				//System.out.println("AMMO " + curGun.getAmmo());
			}
			
			if (p1.getDirection().equals("down")) {
				System.out.println("Starting");
				if (startBulletX == 0) {
					curGun.setX(p1.getX());
					curGun.setY(p1.getY()+70);
					startBulletX = p1.getY();

				}
				
				if (Math.abs(startBulletX - curGun.getY()) < curGun.getDistance()) {
					//curGun.fire(5, 0, "right");
					System.out.println("curgun x " + curGun.getX());
					curGun.fire(0,40,"down");
					curGun.paint(g);
					bulDir = "down";
				} else {
					firstShot = System.currentTimeMillis();
					curGun.setAmmo(curGun.getAmmo()-1);
					startBulletX = 0;
					firing = false;
					bulDir = "";
				}
//				g.setColor(Color.BLACK);
//				g.fillRect(p1.getX(), p1.getY()+70, 2, curGun.getDistance());
//				g.fillRect(p1.getX()+4, p1.getY()+70, 2, curGun.getDistance());
//				curGun.setAmmo(curGun.getAmmo()-1);
//				firstShot = System.currentTimeMillis();
				//System.out.println("AMMO " + curGun.getAmmo());
			}
		
			if (p1.getDirection().equals("up")) {
				System.out.println("Starting");
				if (startBulletX == 0) {
					curGun.setX(p1.getX()+5);
					curGun.setY(p1.getY()+30);
					startBulletX = p1.getY()+30;

				}
				
				if (Math.abs(startBulletX - curGun.getY()) < curGun.getDistance()) {
					//curGun.fire(5, 0, "right");
					System.out.println("curgun x " + curGun.getX());
					curGun.fire(0,-40,"up");
					curGun.paint(g);
					bulDir = "up";
				} else {
					firstShot = System.currentTimeMillis();
					curGun.setAmmo(curGun.getAmmo()-1);
					startBulletX = 0;
					firing = false;
					bulDir ="";
				}
//				g.setColor(Color.BLACK);
//				g.fillRect(p1.getX()+5, p1.getY()+(30-curGun.getDistance()), 2, curGun.getDistance());
//				g.fillRect(p1.getX()+9, p1.getY()+(30-curGun.getDistance()), 2, curGun.getDistance());
//				curGun.setAmmo(curGun.getAmmo()-1);
//				firstShot = System.currentTimeMillis();
				//System.out.println("AMMO " + curGun.getAmmo());
			}
			if (curGun.getAmmo() <= 0) {
				guns.remove(gunIndex);
				gunIndex = 0;
			}
		}
		
		
		// Player to Box : HIT DETECTION
		int removeI = -1; //index of box to remove if the player is found on the box
		for (int a = 0; a < ab.size(); a++) {
 			if (p1.getX() > ab.get(a).getxStart() && p1.getX() < ab.get(a).getxEnd() || p1.getxEnd() > ab.get(a).getxStart() && p1.getxEnd() < ab.get(a).getxEnd()) {
 				if (p1.getY() > ab.get(a).getyStart() && p1.getY() < ab.get(a).getyEnd() || p1.getyEnd() > ab.get(a).getyStart() && p1.getyEnd() < ab.get(a).getyEnd()) {
 					System.out.println("standing on box");
 					removeI = a;
					break;
 				}
 				if (p1.getY() < ab.get(a).getyStart() && p1.getyEnd() > ab.get(a).getyEnd()) {
 					System.out.println("standing on a box");
 					removeI = a;
					break;
 				}
 			}
 			if (p1.getY() > ab.get(a).getyStart() && p1.getY() < ab.get(a).getyEnd() || p1.getyEnd() > ab.get(a).getyStart() && p1.getyEnd() < ab.get(a).getyEnd()) {
				if (p1.getX() < ab.get(a).getxStart() && p1.getxEnd() > ab.get(a).getxEnd()) {
					System.out.println("standing on box");
					removeI = a;
					break;
				}
			}
 			
		}
		if (removeI != -1) {
			ab.remove(removeI);
		 	//player gets a weapon (add this)
			Guns temp = newGun();
			boolean dup = false;
			for (int i = 0 ; i < guns.size(); i++) {
				if (guns.get(i).getName().equals(temp.getName())) {
					guns.get(i).resetAmmo();
					dup = true;
				}
			}
			if (dup == false) {
				guns.add(temp);
				gunIndex++;
				System.out.println(guns.size());
			}
			
		}
		}
		
		
		//g.fillRect(rectX, rectY, 50, 50);
		//System.out.println("refresh");
	}
	
	
	
	public Driver() {
		shiftValsX = 0;
		shiftValsY = 0;
		fireTime = 0;
		firstShot = 0;
		gunIndex = 0;
		startBulletX = 0;
		p1 = new Player(200,200,"down");
		m = new Map();
		firing = false;
		bulDir = "";
		// 600, 800
		devil = new Devil(730, 100);
		ab.add(new AmmoBox(730,270));
		ab.add(new AmmoBox(730,470));
		ab.add(new AmmoBox(730,670));
		 //zombie code
        for(int i = 0; i < round ; i++) {
        	int rand = (int) (Math.random() * 101) ;
        	Zombie temp = new Zombie(800 - rand,0);
        	zombies.add(temp);
        }
        
        //

		JFrame frame = new JFrame("Boxhead");
        frame.setSize(1500,1000);
        frame.add(this);
        guns.add(new Pistol());
        //this part makes sure the x button closes the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
       
        t.start();
        //make the frame show up
        frame.setVisible(true);
	}
	
	Timer t = new Timer(2, this);
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getKeyCode());
		if (arg0.getKeyCode() == 65 && inWall(p1.getX()-10,p1.getY()) == false) {
			//System.out.println("left");
			p1.setDirection("left");
			p1.setImage("Player-01Left-01.png");
			shiftValsX = -5;
		}
		if (arg0.getKeyCode() == 87 && inWall(p1.getX(),p1.getY()-10) == false) {
			//System.out.println("up");
			p1.setDirection("up");
			p1.setImage("Player-01Back-01.png");
			shiftValsY = -5;
		}
		if (arg0.getKeyCode() ==68 && inWall(p1.getX()+10,p1.getY()) == false && inWall(p1.getX()+60,p1.getY()) == false) {
			//System.out.println("right");
			p1.setDirection("right");
			p1.setImage("Player-01Right-01.png");
			shiftValsX = 5;
		}
		if (arg0.getKeyCode() == 83 && inWall(p1.getX(),p1.getY()+10) == false && inWall(p1.getX(),p1.getY()+110) == false) {
			//System.out.println("down");
			p1.setDirection("down");
			p1.setImage("Player-01.png");
			shiftValsY = 5;
		}
		if (arg0.getKeyCode() == 32 && System.currentTimeMillis()-firstShot >= fireTime) {
			firing = true;
		}
		if (arg0.getKeyCode() == 44 && gunIndex-1 >= 0 ) {
			gunIndex--;
			
		}
		if (arg0.getKeyCode() == 46 && gunIndex+1 < guns.size()) {
			gunIndex++;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == 65) {
			System.out.println("left");
			shiftValsX = 0 ;
		}
		if (arg0.getKeyCode() == 87) {
			System.out.println("up");
			shiftValsY = 0 ;
		}
		if (arg0.getKeyCode() == 68) {
			System.out.println("right");
			shiftValsX =0 ;
		}
		if (arg0.getKeyCode() == 83) {
			System.out.println("down");
			shiftValsY = 0 ;
		}
//		if (arg0.getKeyCode() == 32) {
//			firing = false;
//		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
	}
	
	public boolean inWall(int x, int y) { // needs work
		if (x <= 75 || x >= 1425 || y < 128 || y > 890) {
			return true;
		}
		
		return false;
	}

	public Guns newGun() {
		int random = (int)(Math.random()*101);
		if (random > 80) {
			Guns temp = new Rocket();
			System.out.println("rocket");
			return temp;
		} else if (random > 75) {
			Guns temp = new AkFour();
			System.out.println("akfour");
			return temp;
		} else if (random > 60) {
			Guns temp = new Sniper();
			System.out.println("sniper");
			return temp;
		} else if (random > 55) {
			Guns temp = new Railgun();
			System.out.println("rail");
			return temp;
		} else if (random > 40) {
			Guns temp = new Shotgun();
			System.out.println("shotgun");
			return temp;
		} else {
			Guns temp = new Uzi();
			System.out.println("uzi");
			return temp;
		}
	}
	
	
}



