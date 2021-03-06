package org.scilab.forge.jlatexmath.platform.geom;

public interface Rectangle2D {

	public interface Float extends Rectangle2D {

	}

	public double getX();

	public double getY();

	public double getWidth();

	public double getHeight();

	public void setRectangle(double x, double y, double width, double height);
}
