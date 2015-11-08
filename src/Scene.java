import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/** Parent class Scene allows for GameStateManager to handle all of the Scenes
 * 
 * @author Andrea Gonzales
 *
 */
public abstract class Scene implements KeyListener{
	GameStateManager gsm;
	/** standard font */
	Font font;
	
	/** Intializes Scene with custom font PressStart2P.ttf and GameStateManager
	 * 
	 * @param gsm GameStateManager
	 */
	public Scene(GameStateManager gsm) {		
		this.gsm = gsm;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/PressStart2P.ttf"))).deriveFont(Font.PLAIN, 18);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	 * 
	 * @return font being used
	 */
	public Font getFont() {
		return font;
	}
	
	/** changes the size of the font
	 * 
	 * @param size you want the font to be
	 */
	public void resizeFont(int size) {
		font = font.deriveFont(Font.PLAIN, size);
	}
	
	/** required method of scenes */
	public abstract void draw(Graphics g);
	
}
