package game;

import java.awt.Graphics;
/**
 * Paint interface is a functional interface with one method. It is used as an interface because
 * many classes implement this method.
 */
public interface Paint {
	public void paint(Graphics brush);
}
