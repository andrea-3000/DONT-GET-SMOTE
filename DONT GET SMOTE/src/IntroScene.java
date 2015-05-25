import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class IntroScene extends Scene{
	
	private int curChoice = 0;
	
	private String[] textContent = {
		"The Gods are angry with you.",
		"They're trying to smite you!",
		"Press the LEFT and RIGHT arrow keys to dodge the lightning bolts.",
		"But whatever you do...",
		"DON'T GET SMOTE!"
	};

	public IntroScene(GameStateManager gsm) {
		super(gsm);
	}
	
	public void draw(Graphics g) {
		g.fillRect(0, 0, GameStateManager.BOARD_WIDTH, GameStateManager.BOARD_HEIGHT);

		for (int i = 0; i < curChoice + 1; i++) {
			g.setColor(Color.WHITE);
			g.drawString(textContent[i], 5, 10 + i*25);
		}

	}
	
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
