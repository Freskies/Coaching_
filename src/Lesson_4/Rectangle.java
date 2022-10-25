package Lesson_4;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Rectangle implements Polygon {

	/**
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @return A new rectangle with the given width and height.
	 */
	@Contract ("_, _ -> new")
	public static @NotNull Rectangle createRectangleBySides (double width, double height) {
		return new Rectangle (width, height);
	}

	/**
	 * @param diagonal The length of the diagonal of the rectangle.
	 * @param angle The angle between the diagonal and the width of the rectangle.
	 * @return A new rectangle with the given diagonal and angle.
	 */
	@Contract ("_, _ -> new")
	public static @NotNull Rectangle createRectangleByDiagonal (double diagonal, double angle) {
		double width = diagonal * Math.cos (angle);
		double height = diagonal * Math.sin (angle);
		return new Rectangle (width, height);
	}

	/**
	 * @param side The length of the side of the square.
	 * @param diagonal The length of the diagonal of the square.
	 * @return A new square with the given side and diagonal.
	 */
	@Contract ("_, _ -> new")
	public static @NotNull Rectangle createRectangleBySideAndDiagonal (double side, double diagonal) {
		double height = Math.sqrt (Math.pow (diagonal, 2) - Math.pow (side, 2));
		return new Rectangle (side, height);
	}

	private final double width;
	private final double height;

	/**
	 * The only way to create a rectangle is through the factory methods.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @see #createRectangleBySides(double, double)
	 * @see #createRectangleByDiagonal(double, double)
	 * @see #createRectangleBySideAndDiagonal(double, double)
	 */
	protected Rectangle (double width, double height) {
		if(!Polygon.legalPolygon (width, height))
			throw new IllegalArgumentException ("Illegal rectangle sides");
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the number of sides of the polygon
	 */
	@Override
	public int getNumberOfSides () {
		return 4;
	}

	/**
	 * @return the perimeter of the polygon
	 */
	@Override
	public double getPerimeter () {
		return 2 * (this.width + this.height);
	}

	/**
	 * @return the area of the polygon
	 */
	@Override
	public double getArea () {
		return this.width * this.height;
	}
}
