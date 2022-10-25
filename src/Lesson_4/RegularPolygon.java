package Lesson_4;

/**
 * A regular polygon is a polygon that has all sides and angles equal.
 */
public interface RegularPolygon extends Polygon {
	/**
	 * The number of sides of the polygon.
	 */
	int DEFAULT_SIDE_LENGTH = 1;

	/**
	 * @return The number of sides of the polygon.
	 */
	@Override
	int getNumberOfSides ();

	/**
	 * @return The length of each side of the polygon.
	 */
	default double sideLength () {
		return RegularPolygon.DEFAULT_SIDE_LENGTH;
	}

	/**
	 * @return The perimeter of the polygon.
	 */
	@Override
	default double getPerimeter () {
		return this.getNumberOfSides () * this.sideLength ();
	}

	@Override
	default double getArea () {
		int n = this.getNumberOfSides ();
		double s = this.sideLength ();
		return (n * Math.pow (s, 2)) / (4 * Math.tan (Math.PI / n));
	}

	/**
	 * @return The interior angle of the polygon.
	 */
	default double getInteriorAngle () {
		return (this.getNumberOfSides () - 2) * 180.0 / this.getNumberOfSides ();
	}
}
