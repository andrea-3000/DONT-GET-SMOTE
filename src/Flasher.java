import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/** Flasher handles the flashing mechanism of the game (not a glitch)
 * 
 * @author Andrea Gonzales
 *
 */
public class Flasher {
	/** 1/frequency chances of flashing **/
	private int frequency;
	/** random no. generator **/
	private Random r = new Random();
	
	/** initializes new Flasher object w/ frequency 45 and new Random generator **/
	public Flasher() {
		frequency = 45;
	}
	
	/** initializes new Flasher object w/ given frequency f and new Rancom generator
	 * 
	 * @param f frequency
	 */
	public Flasher(int f) {
		frequency = f;
	}
	
	/** willFlash() uses random number generator to evaluate whether a flash will occur
	 * 
	 * @return
	 */
	public boolean willFlash() {	
		if (r.nextInt(frequency) % frequency == 0 && r.nextInt(frequency) % frequency <= 20) {
			return true;
		}
		else return false;
	}
	
	/** flash(Graphics g) draws a white rectangle which fills whole screen to emulate a flash
	 * 	
	 * @param g Graphics
	 */
	public void flash(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GameStateManager.BOARD_WIDTH, GameStateManager.BOARD_HEIGHT);
	}

}
