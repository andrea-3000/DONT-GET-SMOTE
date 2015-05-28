import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class IntroScene extends Scene{
	
	private int curChoice = 0;
	
	private String[] textContent = {
		"INTRO",
		"The Gods are angry!",
		"They're trying to smite you!",
		"Press LEFT and RIGHT to dodge lightning.",
		"You have 9 lives.",
		"But whatever you do...",
		"DON'T GET SMOTE!"
	};

	public IntroScene(GameStateManager gsm) {
		super(gsm);
		super.resizeFont(12);
	}
	
	public void draw(Graphics g) {
		g.fillRect(0, 0, GameStateManager.BOARD_WIDTH, GameStateManager.BOARD_HEIGHT);
		g.setFont(super.getFont());
		for (int i = 0; i < curChoice + 1; i++) {
			g.setColor(Color.WHITE);
			g.drawString(textContent[i], 10, 100 + i*50);
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
