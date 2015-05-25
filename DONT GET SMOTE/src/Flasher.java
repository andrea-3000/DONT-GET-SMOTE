import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Flasher {
	
	private int frequency;
	private Random r;
	
	public Flasher() {
		frequency = 45;
		r = new Random();
	}
	
	public Flasher(int f) {
		frequency = f;
	}
	
	public boolean willFlash() {	
		if (r.nextInt(frequency) % frequency == 0 && r.nextInt(frequency) % frequency <= 20) {
			return true;
		}
		else return false;
	}
	
	public void flash(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GameStateManager.BOARD_WIDTH, GameStateManager.BOARD_HEIGHT);
	}

}
