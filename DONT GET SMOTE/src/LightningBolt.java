import java.awt.Color;
import java.awt.Graphics;


public class LightningBolt {
	
	public int x;
	public int y;
	public int speed;
	
	public int size;
	
	public LightningBolt(int x, int y, int speed) {
		this.x = x;
		this.y = y;		
		this.speed = speed;
		
		size = 10;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 10, 10);
	}
	
	public double setRandomSlope() {
		return 1;
	}

}
