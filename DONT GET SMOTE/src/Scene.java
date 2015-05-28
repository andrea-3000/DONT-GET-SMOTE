import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public abstract class Scene implements KeyListener{
	GameStateManager gsm;
	Font font;
	
	public Scene(GameStateManager gsm) {		
		this.gsm = gsm;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/PressStart2P.ttf"))).deriveFont(Font.PLAIN, 18);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Font getFont() {
		return font;
	}
	
	public void resizeFont(int size) {
		font = font.deriveFont(Font.PLAIN, size);
	}
	
	public abstract void draw(Graphics g);
	
}
