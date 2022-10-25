package Lesson_4;

import org.jetbrains.annotations.Contract;

/**
 * A polygon is a plane figure that is bounded by a finite chain of straight line segments
 * closing in a loop to form a closed chain or circuit.
 */
public interface Polygon {
	/**
	 * @param sides All sides you want to check.
	 * @return True if the sides are valid, false otherwise.
	 */
	@Contract (pure = true)
	static boolean legalSides (double... sides) {
		for (double side : sides)
			if (side <= 0)
				return false;
		return true;
	}

	/**
	 * @param angles All angles you want to check.
	 * @return True if the angles are valid, false otherwise.
	 */
	@Contract (pure = true)
	static boolean legalAngles (double... angles) {
		for (double angle : angles)
			if (angle <= 0 || angle >= 180)
				return false;
		return true;
	}

	/**
	 * @param sides All sides of a polygon.
	 * @return True if the sides can form a polygon, false otherwise.
	 */
	@Contract (pure = true)
	static boolean legalPolygon (double... sides) {
		if (!Polygon.legalSides (sides))
			return false;
		double sum = 0;
		for (double side : sides)
			sum += side;
		for (double side : sides)
			if (side >= sum - side)
				return false;
		return true;
	}

	/**
	 * @return the number of sides of the polygon
	 */
	int getNumberOfSides ();

	/**
	 * @return the perimeter of the polygon
	 */
	double getPerimeter ();

	/**
	 * @return the area of the polygon
	 */
	double getArea ();
}
