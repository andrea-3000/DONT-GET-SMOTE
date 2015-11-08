import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class PauseScene extends Scene {
	private BufferedImage[] images;
	private int curImage; 

	public PauseScene(GameStateManager gsm) {
		super(gsm);
		images = new BufferedImage[2];	
		curImage = 0;
		try {
			for (int i = 0; i < 2; i++) {
				images[i] = ImageIO.read(new File("res/pause_screen" + i + ".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P) {
			gsm.setScene(new GameScene(gsm));
			gsm.clearScene(this);
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void update() {
		if (GameStateManager.FRAME_COUNT % 250 == 0) curImage++;
		if (curImage >= images.length) curImage = 0;
	}
	public void draw(Graphics g) {
		g.drawImage(images[curImage], 0,0, images[curImage].getWidth(), images[curImage].getHeight(), null);
		update();
	}

}
