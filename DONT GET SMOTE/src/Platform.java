import java.awt.Color;
import java.awt.Graphics;


public class Platform {
	
	private int x;
	private int y;
	
	private int width;
	private int height;

	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
		
		width = 200;
		height = 25;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	public int getX() { return x; }
	
	public int getY() { return y; }
	
	public int getWidth() {	return width; }
	
}
