import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/** IntroScene provides instructions and context
 * 
 * @author Andrea Gonzales
 *
 */
public class IntroScene extends Scene{
	/** marks current location in string array */
	private int curChoice = 0;
	
	/** gives what text will be displayed during the intro */
	private String[] textContent = {
		"INTRO [Press ENTER to continue]",
		"The Gods are angry!",
		"They're trying to smite you!",
		"Press LEFT and RIGHT to dodge lightning.",
		"You have 9 lives.",
		"But whatever you do...",
		"DON'T GET SMOTE!"
	};

	/** only constructor, calls super-constructor of Scene and sets font to 12
	 * 
	 * @param gsm GameStateManager
	 */
	public IntroScene(GameStateManager gsm) {
		super(gsm);
		super.resizeFont(12);
	}
	
	/** Goes through the text that needs to be displayed before proceeding
	 * 
	 */
	public void draw(Graphics g) {
		g.fillRect(0, 0, GameStateManager.BOARD_WIDTH, GameStateManager.BOARD_HEIGHT);
		g.setFont(super.getFont());
		for (int i = 0; i < curChoice + 1; i++) {
			g.setColor(Color.WHITE);
			g.drawString(textContent[i], 10, 100 + i*50);
		}

	}
	
	/** Increments curChoice to move through the text that needs to be displayed
	 * proceeds to GameScene when done
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		if (KeyEvent.VK_ENTER == e.getKeyCode()) curChoice ++;
		if (curChoice >= textContent.length) {
			gsm.setScene(new GameScene(gsm));
			gsm.clearScene(this);
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
