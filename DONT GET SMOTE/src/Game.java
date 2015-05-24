import java.awt.Dimension;

import javax.swing.JFrame;


public class Game extends JFrame {
	
	GameManager board;

	public Game() {
		board = new GameManager();
		setPreferredSize(new Dimension(GameManager.BOARD_WIDTH,GameManager.BOARD_HEIGHT));
		getContentPane().add(board);
		setVisible(true);
		pack();
		setResizable(true);
	}

	public static void main (String[] args) {
		Game game = new Game();
	}
	
}
