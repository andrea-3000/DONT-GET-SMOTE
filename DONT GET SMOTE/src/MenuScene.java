import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MenuScene implements Scene {
	private BufferedImage image;
	
	public MenuScene() {

		try {
			image = ImageIO.read(new File("res/menu_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics g) {
		if (flash()) {
			g.setColor(Color.white);
			g.fillRect(0, 0, GameManager.BOARD_WIDTH, GameManager.BOARD_HEIGHT);
		} else {
			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		}
	}
	
	public boolean flash() {	
		if (GameManager.FRAME_COUNT % 500 >= 0 && GameManager.FRAME_COUNT % 500 <= 20) {
			return true;
		}
		else return false;
	}

}
