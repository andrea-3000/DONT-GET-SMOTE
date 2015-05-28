import java.awt.Dimension;

import javax.swing.JFrame;

/**Game initializes the game
 * 
 * @author Andrea Gonzales
 *
 */
public class Game extends JFrame {
	/** GameStateManager handles Scenes **/
	GameStateManager gsm;

	/** Creates new JFrame which houses JPanel
	 * 
	 */
	public Game() {
		gsm = new GameStateManager();
		setPreferredSize(new Dimension(GameStateManager.BOARD_WIDTH,GameStateManager.BOARD_HEIGHT));
		getContentPane().add(gsm);
		setVisible(true);
		pack();
		setResizable(false);
	}

	/**Starts game
	 * 
	 * @param args
	 */
	public static void main (String[] args) {
		Game game = new Game();
	}
	
}
