import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/** Game Scene houses the actual gameplay
 * 
 * @author Andrea Gonzales
 *
 */
public class GameScene extends Scene {
	/** declares ScrollingBackground to simulate rain*/
	private ScrollingBackground background;
	/** declares Cat object for player to intract with  */
	private Cat cat;
	/** declares Platform object for cat to stand on */
	private Platform platform;
	/** declares Flasher object to create random flashes */
	private Flasher flasher;
	/** declares LightningBoltFactory which generates lightningbolts **/
	private LightningBoltFactory lbf;
	/** declares HUD to display amount of lives to user */
	private HUD hud;
	
	/** Only constructor, needs a GameStateManager to be created
	 * 
	 * @param gsm GameStateManager
	 */
	public GameScene(GameStateManager gsm) {
		super(gsm);
		flasher = new Flasher();
		background = new ScrollingBackground(0,0, 5, "background");
		cat = new Cat(200, 100, "cat", 2);
		platform = new Platform (100, 500);
		lbf = new LightningBoltFactory(cat);
		hud = new HUD(cat);
	}
	
	/**draw() displays all objects in the game
	 * 
	 * @param g Graphics
	 */
	public void draw(Graphics g) {
		g.setFont(super.getFont());
		if (flasher.willFlash()) flasher.flash(g);
		else {
			background.draw(g);
			cat.draw(g);
			platform.draw(g);
			lbf.draw(g);
			hud.draw(g);
			g.setColor(Color.BLACK);
			g.drawString("SCORE: " + Integer.toString(GameStateManager.SCORE), GameStateManager.BOARD_WIDTH/2 + 20, 30);
		}		
		update();
	}
	
	/** update() checks if cat is dead
	 * will proceed to next screen if dead
	 * 
	 */
	public void update() {
		lbf.update();
		if (!cat.isOnPlatform(platform)) cat.fall();
		if (GameStateManager.FRAME_COUNT % 100 == 0) GameStateManager.SCORE++;
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
	
	/**
	 * 
	 * @return playable cat
	 */
	public Cat getCharacter() {
		return cat;
	}

	public void keyPressed(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}
