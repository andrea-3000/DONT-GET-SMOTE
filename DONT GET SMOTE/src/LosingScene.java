import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 
 * @author Andrea Gonzales
 *
 */
public class LosingScene extends Scene {
	/** background image */
	private BufferedImage image;
	
	/** current choice player is on */
	private int curChoice = 0;
	/** possible decisions player can make at this screen */
	private String[] options = {
			"PLAY AGAIN",
			"MENU",
			"QUIT"
	};
	
	/** creates Flasher object to generate flashes */
	private Flasher flasher;
	
	/** Only constructor, initializes Flasher object and background image
	 * 
	 * @param gsm GameStateManager
	 */
	public LosingScene(GameStateManager gsm) {
		super(gsm);		
		flasher = new Flasher();		
		try {
			image = ImageIO.read(new File("res/losing_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Sets different scene based on current choice selected
	 * 
	 */
	public void select() {
		switch (curChoice) {
		case 0:
			gsm.setScene(new GameScene(gsm));
			gsm.clearScene(this);
			break;
		case 1:
			gsm.setScene(new MenuScene(gsm));
			gsm.clearScene(this);
			break;
		default:
			System.exit(0);
			break;
		}
	}
	
	/** Displays background images and options available, as well as flashes
	 * @param g Graphics
	 */
	public void draw(Graphics g) {
		if (flasher.willFlash()) {
			flasher.flash(g);
		} else {
			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		}		
		g.setFont(super.getFont());
		for (int i = 0; i < options.length; i++) {
			if (i == curChoice) {
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.BLACK);
			}
			g.drawString(options[i], 250, 550 + i*25);
		}
	}

	/** Goes up or down the options based on which key is pressed, ENTER to choose an option
	 * 
	 */
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
