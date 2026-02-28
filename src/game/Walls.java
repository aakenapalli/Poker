package game;

import java.awt.Graphics;

public class Walls extends Obstacles{
	
	public Walls(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}

	public void paint(Graphics brush) {
		Point[] p = getPoints();
		int [] xPoints = getXPoints(p);
		int [] yPoints = getYPoints(p);
		brush.fillPolygon(xPoints, yPoints, super.getPoints().length);
	}
}
