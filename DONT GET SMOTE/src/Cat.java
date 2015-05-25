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
	private int direction;
	
	private BufferedImage[] images;
	private int curImage;
	
	private boolean isDead;
	
	public Cat(int x, int y, int speed, String name, int arraySize) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		
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
		direction = 0;

		isDead = false;
		
	}
	
	public void animate() {
		if (GameStateManager.FRAME_COUNT % 6 == 0) curImage++;
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
	
	public boolean isHit(LightningBolt l) {
		isDead = true;
		return true;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		
		if (direction == 0) {
			g.drawImage(images[curImage], x, y, images[curImage].getWidth(), images[curImage].getHeight(), null);
		} else {
			g.drawImage(images[curImage], x+images[curImage].getWidth(), y, -images[curImage].getWidth(), images[curImage].getHeight(), null);
		}
	}

	public void keyPressed(KeyEvent e) {
		animate();
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			direction = 0;
			x -= speed;
			break;
		case KeyEvent.VK_RIGHT:
			direction = 1;
			x += speed;
			break;
		}		
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

}
