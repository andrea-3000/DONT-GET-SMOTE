import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Cat implements KeyListener{
	private int x;
	private int y;
	private int speed;
	private int lives;
	private boolean facingLeft;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	
	private BufferedImage[] images;
	private int curImage;
	
	private boolean isDead;
	
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
	
	public void animate() {
		if (x % 5 == 0) curImage++;
		if (curImage >= images.length) curImage = 0;
	}
	
	public void fall() {
		y+=2;
		if (y > GameStateManager.BOARD_HEIGHT) isDead = true;
	}
	
	public boolean isOnPlatform(Platform p) {
		if (y+images[curImage].getHeight() != p.getY() || (x+images[curImage].getWidth() < p.getX())  || x > p.getX() + p.getWidth()) return false;
		return true;		
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		if (facingLeft) {
			g.drawImage(images[curImage], x, y, images[curImage].getWidth(), images[curImage].getHeight(), null);
		} else {
			g.drawImage(images[curImage], x+images[curImage].getWidth(), y, -images[curImage].getWidth(), images[curImage].getHeight(), null);
		}
		update();
	}
	
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
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		leftPressed = false;
		rightPressed = false;
	}
	
	public void harm() {
		lives--; 
		if (lives == 0) isDead = true;
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public int getWidth() { return images[curImage].getWidth(); }
	public int getHeight() { return images[curImage].getHeight(); }
	public int getLives() { return lives; }

}
