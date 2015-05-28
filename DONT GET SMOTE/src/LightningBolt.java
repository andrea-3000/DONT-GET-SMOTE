import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class LightningBolt {
	private int x;
	private int y;
	private double speed;	
	private BufferedImage image;
	private boolean harmed;
	
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
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
	}
	
	public void update() {
		y+=speed;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getWidth() { return image.getWidth(); }
	public int getHeight() { return image.getHeight(); }
	public boolean hasHarmed() { return harmed; }
	public void setHarmed(boolean b) { harmed = b; }
}
