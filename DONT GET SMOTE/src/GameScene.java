import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class GameScene extends Scene {
	private ScrollingBackground background;
	private Cat cat;
	private Platform platform;
	private Flasher flasher;
	
	public GameScene(GameStateManager gsm) {
		super(gsm);
		flasher = new Flasher();
		background = new ScrollingBackground(0,0, 5, "stars_background");
		cat = new Cat(200, 100, 3, "cat", 2);
		platform = new Platform (100, 500);	
	}
	
	public void draw(Graphics g) {
		if (flasher.willFlash()) flasher.flash(g);
		else {
			background.draw(g);
			cat.draw(g);
			platform.draw(g);
		}		
		update();
	}
	
	public void update() {	
		if (!cat.isOnPlatform(platform)) cat.fall();
		if (cat.isDead())  {
			gsm.setScene(new LosingScene(gsm));
			gsm.clearScene(this);
		}
	}
	
	public Cat getCharacter() {
		return cat;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P); //go to pause screen		
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}
