import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** Manages one Lightning Bolt, which can collide with the cat
 * 
 * @author Andrea Gonzales
 *
 */
public class LightningBolt {
	private int x;
	private int y;
	private double speed;
	private BufferedImage image;
	/** whether the bolt has harmed the cat already, prevents it from harming multiple times */
	private boolean harmed;
	
	/** Only constructor
	 * 
	 * @param p Point object of location
	 * @param speed gives speed that bolt falls
	 */
	public LightningBolt(Point p, double speed) {
		x = p.getX();
		y = p.getY();
		harmed = false;
		this.speed = speed;
		try {
			image = ImageIO.read(new File("res/lightning_bolt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Displays a lightning bolt image
	 *  
	 * @param g Graphcis
	 */
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
	}
	
	/** Moves the bolt downwards
	 * 
	 */
	public void update() {
		y+=speed;
	}
	
	/** 
	 * 
	 * @return x location
	 */
	public int getX() { return x; }
	/**
	 * 
	 * @return y location
	 */
	public int getY() { return y; }
	/**
	 * 
	 * @return width of bolt image
	 */
	public int getWidth() { return image.getWidth(); }
	/**
	 * 
	 * @return height of bolt image
	 */
	public int getHeight() { return image.getHeight(); }
	/**
	 * 
	 * @return whether the bolt has already harmed the cat or not
	 */
	public boolean hasHarmed() { return harmed; }
	/** Changes the value of boolean harmed
	 * 
	 * @param b sets the bolt to harmed or not harmed
	 */
	public void setHarmed(boolean b) { harmed = b; }
}
