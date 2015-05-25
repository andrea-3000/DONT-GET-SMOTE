import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MenuScene extends Scene {
	private BufferedImage image;
	private int curChoice = 0;
	private String[] options = {
			"START",
			"QUIT"
	};
	private Flasher flasher;
	private Font font;

	public MenuScene(GameStateManager gsm) {
		super(gsm);
		flasher = new Flasher();
		try {
			image = ImageIO.read(new File("res/menu_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void select() {
		if (curChoice == 0) {
			gsm.setScene(new IntroScene(gsm));
			gsm.clearScene(this);
		} else {
			System.exit(0);
		}
	}

	public void draw(Graphics g) {
		if (flasher.willFlash()) {
			flasher.flash(g);
		} else {
			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		}
		//		g.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == curChoice) {
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], 300, 500 + i*25);
		}
	}
	
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
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

}
