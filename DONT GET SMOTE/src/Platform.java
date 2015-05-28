import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Platform {
	
	private int x;
	private int y;
	private BufferedImage image;
	private Random r = new Random();

	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
		
		try {
			image = ImageIO.read(new File("res/platform.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
	}
	
	public Point getRandomPoint() {
		int randX = r.nextInt(image.getWidth()) + x;
		return new Point(randX, y);
	}
	
	public int getX() { return x; }	
	public int getY() { return y; }	
	public int getWidth() {	return image.getWidth(); }
	
}
