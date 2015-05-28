/** Point class holds two values: x coordinate and y coodinate
 * 
 * @author Andrea Gonzales
 *
 */
public class Point {
	private int x;
	private int y;

	/** default constructor sets x to 0 and y to 0
	 * 
	 */
	public Point() {
		x = 0;
		y = 0;
	}
	
	/** creates new Point with given x and y coordinate
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}
	
}
