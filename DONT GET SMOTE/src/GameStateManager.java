import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

/** GameStateManager handles the switching between Scenes; also provides JPanel for Scenes to be drawn on
 * 
 * @author Andrea Gonzales
 *
 */
public class GameStateManager extends JPanel{
	/** sets final BOARD_WIDTH */
	static final int BOARD_WIDTH = 500;
	/** sets final BOARD_HEIGHT */
	static final int BOARD_HEIGHT = 700;
	/** starts FRAME_COUNT */
	static int FRAME_COUNT = 0;
	/** starts SCORE*/
	static int SCORE = 0;
	
	/**creates parent object Scene */
	private Scene scene;
	
	/**only constructor, intializes with new MenuScene
	 * 
	 */
	public GameStateManager() {
		
		Dimension BOARD_DIMENSION = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
		
		setScene(new MenuScene(this));
		
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setFocusable(true);
		setMinimumSize(BOARD_DIMENSION);
		setMaximumSize(BOARD_DIMENSION);
		repaint();
		
	}
	
	/** Allows the changing of scenes and appending of keyListeners
	 * 
	 * @param s scene to change to
	 */
	public void setScene(Scene s) {
		scene = s;
		
		if (scene instanceof GameScene) addKeyListener(((GameScene) scene).getCharacter());
		else addKeyListener(s);
	}
	
	/** Allows the removing of scenes (namely, removing the keyListeners to avoid stacking of keyListeners)
	 * 
	 * @param s scene to remove
	 */
	public void clearScene(Scene s) {
		removeKeyListener(s);
	}
	
	/** Draws and updates the scene being displayed
	 * @param g Graphics
	 */
	public void paint (Graphics g) {
		FRAME_COUNT++;
		scene.draw(g);
		repaint();
		
	}
}