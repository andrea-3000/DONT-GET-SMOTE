import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MenuScene extends Scene implements KeyListener{
	private BufferedImage image;
	private int curChoice = 0;
	private String[] options = {
			"START",
			"QUIT"
	};
	
	public MenuScene(GameStateManager gsm) {
		try {
			image = ImageIO.read(new File("res/menu_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void draw(Graphics g) {
		if (flash()) {
			g.setColor(Color.white);
			g.fillRect(0, 0, GameStateManager.BOARD_WIDTH, GameStateManager.BOARD_HEIGHT);
		} else {
			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		}
		
		//g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == curChoice) {
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.GRAY);
			}
			g.drawString(options[i], 210, 180*25);
		}
	}
	
	public void drawOptions() {
		
	}
	
	public boolean flash() {	
		if (GameStateManager.FRAME_COUNT % 500 >= 0 && GameStateManager.FRAME_COUNT % 500 <= 20) {
			return true;
		}
		else return false;
	}
	
	public void select() {
		if (curChoice == 0) {
			gsm.setScene(new GameScene());
		} else {
			System.exit(0);
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			select();
			break;
		case KeyEvent.VK_UP:
			curChoice--;
			if (curChoice < 0) curChoice = options.length-1;
			break;
		case KeyEvent.VK_DOWN:
			curChoice++;
			if (curChoice > options.length-1) curChoice = 0;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {}

}
