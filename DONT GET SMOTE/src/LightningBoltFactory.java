import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/** LightningBoltFactory manages the bulk of LightningBolts and their collision
 * 
 * @author Andrea Gonzales
 *
 */
public class LightningBoltFactory {
	/** declares ArrayList of LightningBolts */
	private ArrayList<LightningBolt> bolts;
	/** intializes new random no. generator */
	private Random r = new Random();
	/** declares frequency at which bolts will be generated */
	private int frequency;
	/** declares Cat object which bolts will collide with */
	private Cat cat;
	
	/** Only constructor, needs a Cat object, sets frequency to 200
	 * 
	 * @param c Cat
	 */
	public LightningBoltFactory(Cat c) {
		bolts = new ArrayList<LightningBolt>();
		frequency = 200;
		cat = c;
	}
	
	/** determines whether bolt should be generated (1/frequency chance)
	 * 
	 * @return whether a new bolt should be generated
	 */
	public boolean shouldGenerate() {
		if (r.nextInt(frequency) == 0) {
			return true;
		}
		return false;
	}
	
	/** creates a new bolt and adds it to the ArrayList of bolts, gives random location at top of screen
	 * 
	 */
	public void createBolt() {
		Point randPoint = new Point(r.nextInt(GameStateManager.BOARD_WIDTH-50)+50, 0);
		double speed = 2;
		
		bolts.add(new LightningBolt(randPoint, speed));
	}
	
	/** iterates through Arraylist to display all of the bolts in the ArrayList
	 * 
	 * @param g Graphics
	 */
	public void draw(Graphics g) {
		if (shouldGenerate()){
			createBolt();
		}		
		for (int i = 0; i < bolts.size(); i++) {
			bolts.get(i).draw(g);
		}
	}
	
	/** Checks to see if a bolt has collided with a cat
	 * 
	 * @param l LightningBolt
	 */
	public void checkHit(LightningBolt l) {
		int buffer = 5; //makes collision box of cat more forgiving
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
	
	/**Checks to see if bolt is hit; removes bolt if off-screen
	 * 
	 */
	public void update() {
		for (int i = 0; i < bolts.size(); i++) {
			checkHit(bolts.get(i));
			bolts.get(i).update();
			if (bolts.get(i).getY() > GameStateManager.BOARD_HEIGHT) bolts.remove(i);
		}
	}
}
