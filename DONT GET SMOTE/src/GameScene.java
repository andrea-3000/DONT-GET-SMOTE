import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class GameScene extends Scene {
	private ScrollingBackground background;
	private Cat cat;
	private Platform platform;
	private Flasher flasher;
	private LightningBoltFactory lbf;
	private HUD hud;
	
	public GameScene(GameStateManager gsm) {
		super(gsm);
		flasher = new Flasher();
		background = new ScrollingBackground(0,0, 5, "background");
		cat = new Cat(200, 100, "cat", 2);
		platform = new Platform (100, 500);
		lbf = new LightningBoltFactory(cat);
		hud = new HUD(cat);
	}
	
	public void draw(Graphics g) {
		g.setFont(super.getFont());
		if (flasher.willFlash()) flasher.flash(g);
		else {
			background.draw(g);
			cat.draw(g);
			platform.draw(g);
			lbf.draw(g);
			hud.draw(g);
		}		
		update();
	}
	
	public void update() {
		lbf.update();
		if (!cat.isOnPlatform(platform)) cat.fall();
		if (cat.isDead())  {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
