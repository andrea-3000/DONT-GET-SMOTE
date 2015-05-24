import java.awt.Dimension;

import javax.swing.JFrame;


public class Game extends JFrame {
	
	GameStateManager board;

	public Game() {
		board = new GameStateManager();
		setPreferredSize(new Dimension(GameStateManager.BOARD_WIDTH,GameStateManager.BOARD_HEIGHT));
		getContentPane().add(board);
		setVisible(true);
		pack();
		setResizable(true);
	}

	public static void main (String[] args) {
		Game game = new Game();
	}
	
}
