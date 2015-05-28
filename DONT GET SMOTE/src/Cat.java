import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Andrea Gonzales
 * Generates the cat of the game. Uses KeyListeners for interaction, controlled by LEFT and RIGHT arrow keys;
 *
 */
public class Cat implements KeyListener{
	private int x;
	private int y;
	private int speed;
	private int lives;
	/**marks direction of cat**/
	private boolean facingLeft;
	/**direction booleans help decrease lag from KeyListener input**/
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	/** array of images which are needed to animate the cat **/
	private BufferedImage[] images;
	private int curImage;
	
	private boolean isDead;
	
	/** Only given constructor, creates an animating cat
	 * 
	 * @param x starting x position of the cat
	 * @param y starting y position of the cat
	 * @param name name of the picture(s) being used
	 * @param arraySize is the number of frames for the cat's animation
	 */
	public Cat(int x, int y, String name, int arraySize) {
		this.x = x;
		this.y = y;
		this.speed = 1;
		lives = 9;
		
		images = new BufferedImage[arraySize];
		
		try {
			for (int i = 0; i < arraySize; i++) {
				images[i] = ImageIO.read(new File("res/"+name+i+".png"));
			}
		} catch (IOException e) {
			System.out.println("no image found!");
			e.printStackTrace();
		}
		
		curImage = 0;
		facingLeft = false;

		isDead = false;
		
	}
	
	/** animate() switches between the frames of animation based on movement
	 * 
	 */
	public void animate() {
		if (x % 5 == 0) curImage++;
		if (curImage >= images.length) curImage = 0;
	}
	
	/** fall() moves the cat downwards, checks to see if the cat is out of frame
	 * 
	 */
	public void fall() {
		y+=2;
		if (y > GameStateManager.BOARD_HEIGHT) isDead = true;
	}
	
	/** isOnPlatform(Platform p) evaluates whether the cat is on top of the platform or not
	 * 
	 * @param p is the platform which is checked with the cat
	 * @return whether the cat is on the platform or not
	 */
	public boolean isOnPlatform(Platform p) {
		if (y+images[curImage].getHeight() != p.getY() || (x+images[curImage].getWidth() < p.getX())  || x > p.getX() + p.getWidth()) return false;
		return true;		
	}
	
	/** isDead() evaluates whether the cat is alive or not
	 * 
	 * @return whether the cat is dead or not
	 */
	public boolean isDead() {
		return isDead;
	}
	
	/** draw(Graphics g) draws the image of the cat, flips image based on direction the cat is facing
	 * 
	 * @param g Graphics
	 */
	public void draw(Graphics g) {
		if (facingLeft) {
			g.drawImage(images[curImage], x, y, images[curImage].getWidth(), images[curImage].getHeight(), null);
		} else {
			g.drawImage(images[curImage], x+images[curImage].getWidth(), y, -images[curImage].getWidth(), images[curImage].getHeight(), null);
		}
		update();
	}
	
	/** harm() deducts a life from the cat's stock of lives, if there are no more lives the cat is flagged dead.
	 * 
	 */
	public void harm() {
		lives--; 
		if (lives == 0) isDead = true;
	}
	
	/** update() changes the x location of the cat depending on whether the LEFT or RIGHT arrow keys are pressed
	 * will only animated when keys are pressed
	 * 
	 */
	public void update() {
		if (leftPressed)  {
			x-=speed;
			animate();
		}
		else if (rightPressed) {
			animate();
			x+=speed;
		}
	}

	/**keyPressed(KeyEvent e) changes the direction the cat is facing and flags that given key is being pressed
	 * 
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			leftPressed = true;
			facingLeft = true;
			update();
			break;
		case KeyEvent.VK_RIGHT:
			rightPressed = true;
			facingLeft = false;
			update();
			break;
		}
	}
	/**keyReleased(KeyEvent e) resets the values of the key press booleans based when keys are released
	 * 
	 */
	public void keyReleased(KeyEvent e) {
		leftPressed = false;
		rightPressed = false;
	}
	public void keyTyped(KeyEvent e) {}

	/**
	 * 
	 * @return x location of cat
	 */
	public int getX() { return x; }
	
	/**
	 * 
	 * @return y location of cat
	 */
	public int getY() { return y; }
	
	/**
	 * 
	 * @return width of current cat image
	 */
	public int getWidth() { return images[curImage].getWidth(); }
	
	/**
	 * 
	 * @return height of current cat image
	 */
	public int getHeight() { return images[curImage].getHeight(); }
	
	/**
	 * 
	 * @return amount of lives remaining
	 */
	public int getLives() { return lives; }

}
