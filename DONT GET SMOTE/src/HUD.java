import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** Heads Up Display communicates the amount of lives the cat has left to the user
 * 
 * @author Andrea Gonzales
 *
 */
public class HUD {
	/** declares image which will show hear */
	private BufferedImage image;
	/** declares Cat object which HUD evalutes the number of lives */
	private Cat cat;
	
	/** only constructor, creates heart image and initializes cat
	 * 
	 * @param cat Cat
	 */
	public HUD(Cat cat) {
		this.cat = cat;
		try {
			image = ImageIO.read(new File("res/heart.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** displays hearts corresponding to the amount of lives remaining */
	public void draw(Graphics g) {
		for (int i = 0; i < cat.getLives(); i++) {
			g.drawImage(image, 10 + i * 25, 10, image.getWidth(), image.getHeight(), null);
		}
	}

}
