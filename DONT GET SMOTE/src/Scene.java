import java.awt.Graphics;
import java.awt.event.KeyListener;


public abstract class Scene implements KeyListener{
	GameStateManager gsm;
	
	public abstract void draw(Graphics g);
	
}
