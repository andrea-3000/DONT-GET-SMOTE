import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class HUD {
	private BufferedImage image;
	private Cat cat;
	
	public HUD(Cat cat) {
		this.cat = cat;
		try {
			image = ImageIO.read(new File("res/heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < cat.getLives(); i++) {
			g.drawImage(image, 10 + i * 25, 10, image.getWidth(), image.getHeight(), null);
		}
	}

}
