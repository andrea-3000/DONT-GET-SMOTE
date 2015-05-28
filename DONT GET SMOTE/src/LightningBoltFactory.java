import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class LightningBoltFactory {
	private ArrayList<LightningBolt> bolts;
	private Random r = new Random();
	private int frequency;
	private Cat cat;
	
	public LightningBoltFactory(Cat c) {
		bolts = new ArrayList<LightningBolt>();
		frequency = 200;
		cat = c;
	}
	
	public boolean shouldGenerate() {
		if (r.nextInt(frequency) == 0) {
			return true;
		}
		return false;
	}
	

	public void createBolt() {
		Point randPoint = new Point(r.nextInt(GameStateManager.BOARD_WIDTH-50)+50, 0);
//		double speed = r.nextDouble()*1.1;
		double speed = 2;
//		if (randPoint.getX() > GameStateManager.BOARD_WIDTH/2) speed = -speed;
		
		bolts.add(new LightningBolt(randPoint, speed));
	}
	
	public void draw(Graphics g) {
		if (shouldGenerate()){
			createBolt();
		}		
		for (int i = 0; i < bolts.size(); i++) {
			bolts.get(i).draw(g);
		}
	}
	
	public void checkHit(LightningBolt l) {
		int buffer = 5;
		int leftCat = cat.getX() + buffer;
		int rightCat = cat.getX() + cat.getWidth() - buffer;
		int topCat = cat.getY() + buffer;
		int bottomCat = cat.getY() + cat.getHeight() - buffer;
		
		boolean xCollision = (l.getX() >= leftCat && l.getX() <= rightCat) || (l.getX() + l.getWidth() >= leftCat && l.getX() + l.getWidth() <= rightCat);
		boolean yCollision = (l.getY() >= topCat && l.getY() <= bottomCat) || (l.getY() + l.getHeight() >= topCat && l.getY() + l.getHeight() <= bottomCat);
		
		if (xCollision && yCollision && !l.hasHarmed()) {
			cat.harm();
			l.setHarmed(true);
		}
	}
	
	
	public void update() {
		for (int i = 0; i < bolts.size(); i++) {
			checkHit(bolts.get(i));
			bolts.get(i).update();
			if (bolts.get(i).getY() > GameStateManager.BOARD_HEIGHT) bolts.remove(i);
		}
	}
}
