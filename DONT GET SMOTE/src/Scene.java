import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public abstract class Scene implements KeyListener{
	GameStateManager gsm;
	private BufferedImage image;
	private Font font;
	
	public Scene(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void draw(Graphics g);
	
}
