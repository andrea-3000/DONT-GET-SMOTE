import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class GameManager extends JPanel{
	static final int BOARD_WIDTH = 500;
	static final int BOARD_HEIGHT = 700;
	static int FRAME_COUNT = 0;
	
	private Scene scene;
	
	public GameManager() {
		
		Dimension BOARD_DIMENSION = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		
		setScene(new MenuScene());
		
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setFocusable(true);
		setMinimumSize(BOARD_DIMENSION);
		setMaximumSize(BOARD_DIMENSION);
		repaint();
		
	}
	
	public void setScene(Scene s) {
		scene = s;
		
		if (scene instanceof GameScene) addKeyListener(((GameScene) scene).getCharacter());
	}
	
	public void paint (Graphics g) {
		FRAME_COUNT++;
		scene.draw(g);
		repaint();
		
	}
}