package game;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
/**
 * The Body class defines the poker that is used in the Poker class. It implements KeyListener
 * and Paint. It defines the movement of the poker and the key events.
 */
public class Body extends Polygon implements KeyListener, Paint {
	public boolean moveUp;
	public boolean moveDown;
	public boolean rotateRight;
	public boolean rotateLeft;
	private int speed;
	/**
	 * 
	 * @param inShape
	 * @param inPosition
	 * @param inRotation
	 * constructor sets all movements to false and sets the speed to 5.
	 */
	public Body(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);		
		moveUp = false;
		moveDown = false;
		rotateRight = false;
		rotateLeft = false;
		speed = 5;	
	}
	/**
	 * @param brush
	 * The paint method uses points to paint the Body in the desired color
	 */
	public void paint(Graphics brush) {
		Point[] p = getPoints();
		int [] xPoints = getXPoints(p);
		int [] yPoints = getYPoints(p);
		brush.fillPolygon(xPoints, yPoints, super.getPoints().length);
	}
	
	/**
	 * The move snake method implements the rotation of the poker.
	 */
	public void movePoker() {
		if(moveUp) {
			double rotateRadians = Math.toRadians(rotation);
			double xAngle = Math.sin(rotateRadians);
			double yAngle = Math.cos(rotateRadians);
			position.setX((position.getX()+xAngle*speed));
			position.setY((position.getY()-yAngle*speed));
		}
		if(moveDown) {
			double rotateRadians = Math.toRadians(rotation);
			double xAngle = Math.sin(rotateRadians);
			double yAngle = Math.cos(rotateRadians);
			position.setX((position.getX()-xAngle*speed));
			position.setY((position.getY()+yAngle*speed));
		}
		
		if(rotateRight) {
			rotation += 3;
		}
		
		if(rotateLeft) {
			rotation -= 3;
		}
		
	}
	/**
	 * this method checks if the poker is in the bounds of the game.
	 * @return true if it is and false if it is not.
	 */
	public boolean inBounds() {
		Point[] p = getPoints();
		int [] xPoints = getXPoints(p);
		int [] yPoints = getYPoints(p);
		for(int i = 0; i < xPoints.length; i++) {
			if (xPoints[1] > 795 | xPoints[1] < 5) {
				return false;
			}
		}
		for(int i = 0; i < yPoints.length; i++) {
			if (yPoints[1] > 595 | yPoints[1] < 5) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Key presses are the only input that affects the poker's movement. The key movements are not
	 * typed.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}
	/**
	 * Rotation is determined by left and right inputs. The poker moves when the key is pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == 38) {
			moveUp = true;
			moveDown = false;
		}
		if(key == 40) {
			moveDown = true;
			moveUp = false;
			}
		if(key == 39) {
			rotateRight = true;
			rotateLeft = false;
		}
		if(key == 37) {
			rotateLeft = true;
			rotateRight = false;
		}
	
		System.out.println(rotation);
		
	}
	/**
	 * Poker stops moving if key is released
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == 38) {
			moveUp = false;
		}
		if(key == 40) {
			moveDown = false;
		}
		if(key == 39) {
			rotateRight = false;
		}
		if(key == 37) {
			rotateLeft = false;
		}
	}
}
