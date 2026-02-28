package game;
import java.awt.Graphics;
/**
 * The Apple class defines the target shape and how it is painted. It extends Polygon
 * and implements Paint
 */
public class Apple extends Polygon implements Paint{
	  Point[] shape;
	  Point position;
	  double rotation;
	  /**
	   * 
	   * @param inShape
	   * @param inPosition
	   * @param inRotation
	   * Uses constructor of Polygon
	   */
	  public Apple(Point[] inShape, Point inPosition, double inRotation) {
			super(inShape, inPosition, inRotation);
		}
		/**
		 * @param brush
		 * Implements paint method defined by Paint interface
		 */
		public void paint(Graphics brush) {
			Point[] p = getPoints();
			int [] xPoints = getXPoints(p);
			int [] yPoints = getYPoints(p);
			brush.fillPolygon(xPoints, yPoints, super.getPoints().length);
		}
	}