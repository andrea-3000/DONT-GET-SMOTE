import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class LosingScene implements Scene {
	
	private BufferedImage image;
	
	public LosingScene() {
		try {
			image = ImageIO.read(new File("res/losing_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics g) {		
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
	}

}
