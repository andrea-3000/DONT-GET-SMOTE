import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ScrollingBackground {
	private BufferedImage imageOne;
	private BufferedImage imageTwo;
	
	private int xOne;
	private int yOne;
	
	private int xTwo;
	private int yTwo;
	
	private int speed;
	
	/**
	 * 
	 * @param x is the x coordinate
	 * @param y is the y coordinate
	 * @param speed is the speed the image moves
	 * @param name is the name of the image used for the background
	 */
	public ScrollingBackground(int x, int y, int speed, String name) {
		this.xOne = x;
		this.yOne = y;
		
		this.speed = speed;
		
		try {
			imageOne = ImageIO.read(new File("res/" + name + ".png"));
			imageTwo = ImageIO.read(new File("res/" + name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.xTwo = x;
		this.yOne = y-imageOne.getHeight();
	}
	
	/**
	 * 
	 * @param g is the Graphics
	 */
	public void draw(Graphics g) {
		g.drawImage(imageOne, xOne, yOne, imageOne.getWidth(), imageOne.getHeight(), null);
		g.drawImage(imageTwo, xTwo, yTwo, imageTwo.getWidth(), imageOne.getHeight(), null);
		update();
	}
	
	public void update(){
		if (yOne < 700 && yOne >= 0){
			yOne+=speed;
			yTwo = yOne - imageOne.getHeight();
		} else {
			yOne = 0;
		}	
	}
	
	/**
	 * 
	 * @param x
	 * @return new x value
	 */
	public int setX(int x) {
		this.xOne = x;
		return x;
	}
	
	/**
	 * 
	 * @param y
	 * @return new y value
	 */
	public int setY(int y) {
		this.yOne = y;
		return y;
	}
	
	/**
	 * 
	 * @return x coordinate
	 */
	public int getX() {
		return xOne;
	}
	
	/**
	 * 
	 * @return y coordinate
	 */
	public int getY() {
		return yOne;
	}
	
}
