import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/** Creates platform for Cat to stand on 
 * 
 * @author Andrea Gonzales
 *
 */
public class Platform {
	private int x;
	private int y;
	private BufferedImage image;
	private Random r = new Random();

	/** creates new Platform object with given location, initializes platform image
	 * 
	 * @param x location of platform
	 * @param y location of platform
	 */
	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
		
		try {
			image = ImageIO.read(new File("res/platform.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/** Displays the platform
	 * 
	 * @param g Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
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
	 * @return width of the platform
	 */
	public int getWidth() {	return image.getWidth(); }
	
}
