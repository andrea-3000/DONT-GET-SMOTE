import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/** MenuScene gives the opening Scene when game starts
 * 
 * @author Andrea Gonzales
 *
 */
public class MenuScene extends Scene {
	/** background image */
	private BufferedImage image;
	/** current choice user is on */
	private int curChoice = 0;
	/** allows the user to start the game or exit */
	private String[] options = {
			"START",
			"QUIT"
	};
	/** creates new Flasher object to generate flashing */
	private Flasher flasher;

	/** Only constructor, initializes flasher and background image, as well as GameStateManager
	 * 
	 * @param gsm GameStateManager
	 */
	public MenuScene(GameStateManager gsm) {
		super(gsm);
		flasher = new Flasher();		
		try {
			image = ImageIO.read(new File("res/menu_screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Proceeds or exits the game based on the user's current selection
	 * 
	 */
	public void select() {
		if (curChoice == 0) {
			gsm.setScene(new IntroScene(gsm));
			gsm.clearScene(this);
		} else {
			System.exit(0);
		}
	}

	/** Displays the image, flashes, and options given to the player
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
			g.drawString(options[i], 300, 550 + i*25);
		}
	}
	
	/** Allows the user to iterate through the selections, press ENTER to proceed or exit based on choice
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
