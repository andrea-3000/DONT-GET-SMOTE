import java.awt.Graphics;


public class GameScene implements Scene {
	private ScrollingBackground background;
	private Cat cat;
	private Platform platform;
	
	public GameScene() {
		
		background = new ScrollingBackground(0,0, 5, "stars_background");
		cat = new Cat(200, 100, 3, "cat", 2);
		platform = new Platform (100, 500);	
	}
	
	public void draw(Graphics g) {
		background.draw(g);
		cat.draw(g);
		platform.draw(g);
		
		update();
	}
	
	public void update() {	
		if (!cat.isOnPlatform(platform)) cat.fall();
	}
	
	public Cat getCharacter() {
		return cat;
	}
	
}
