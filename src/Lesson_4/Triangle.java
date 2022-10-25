package Lesson_4;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A Triangle is a polygon with three sides.
 * The only way to create a Triangle is through the factory methods.
 * you can create a Triangle with three sides.
 * you can create a Triangle with two sides and an angle between them.
 * you can create a Triangle with two angles and a side between them.
 */
public class Triangle implements Polygon {

	// FACTORY METHODS

	/**
	 * @param side1 The length of the first side.
	 * @param side2 The length of the second side.
	 * @param side3 The length of the third side.
	 * @return A new triangle with the given sides.
	 */
	public static @NotNull Triangle createTriangleBy3Sides (double side1, double side2, double side3) {
		return new Triangle (side1, side2, side3);
	}

	/**
	 * @param side1 The length of the first side.
	 * @param side2 The length of the second side.
	 * @param angle The angle between the two sides.
	 * @return A new triangle with the given sides.
	 */
	public static @NotNull Triangle createTriangleBy2SidesAndAngle (double side1, double side2, double angle) {
		Triangle triangle = new Triangle (GETTING.BY_2_SIDES_AND_ANGLE);
		if (!Polygon.legalSides (side1, side2))
			throw new IllegalArgumentException ("Illegal triangle sides");
		if (!Polygon.legalAngles (angle))
			throw new IllegalArgumentException ("Illegal triangle angle");
		triangle.side1 = side1;
		triangle.side2 = side2;
		triangle.angle1 = angle;
		return triangle;
	}

	/**
	 * @param side   The length of the side.
	 * @param angle1 The angle between the side and the first base.
	 * @param angle2 The angle between the side and the second base.
	 * @return A new triangle with the given sides.
	 */
	public static @NotNull Triangle createTriangleBy2AnglesAndSide (double side, double angle1, double angle2) {
		Triangle triangle = new Triangle (GETTING.BY_2_ANGLES_AND_SIDE);
		if (!Polygon.legalSides (side))
			throw new IllegalArgumentException ("Illegal triangle side");
		if (!Polygon.legalAngles (angle1, angle2))
			throw new IllegalArgumentException ("Illegal triangle angles");
		triangle.side1 = side;
		triangle.angle1 = angle1;
		triangle.angle2 = angle2;
		return triangle;
	}

	/**
	 * @param base   The length of the base.
	 * @param height The length of the height.
	 * @return A new triangle with the given sides.
	 */
	public static @NotNull Triangle createTriangleByBaseAndHeight (double base, double height) {
		Triangle triangle = new Triangle (GETTING.BY_BASE_AND_HEIGHT);
		if (!Polygon.legalSides (base, height))
			throw new IllegalArgumentException ("Illegal triangle sides");
		triangle.base = base;
		triangle.height = height;
		return triangle;
	}

	/**
	 * this enum is used to determine which constructor was used to create the triangle.
	 */
	private enum GETTING {
		BY_3_SIDES, BY_2_SIDES_AND_ANGLE, BY_2_ANGLES_AND_SIDE, BY_BASE_AND_HEIGHT
	}

	/**
	 * witch constructor was used to create the triangle.
	 */
	private final GETTING getting;

	private double side1, side2, side3;
	private double angle1, angle2;
	private double base, height;

	/**
	 * The only way to create a triangle is by using the factory methods.
	 * @param getting witch constructor was used to create the triangle.
	 */
	@Contract (pure = true)
	private Triangle (GETTING getting) {
		this.getting = getting;
	}

	/**
	 * The only way to create a triangle is by using the factory methods.
	 * @param side1 The length of the first side.
	 * @param side2 The length of the second side.
	 * @param side3 The length of the third side.
	 * @see #createTriangleBy3Sides(double, double, double)
	 * @see #createTriangleBy2SidesAndAngle(double, double, double)
	 * @see #createTriangleBy2AnglesAndSide(double, double, double)
	 * @see #createTriangleByBaseAndHeight(double, double)
	 */
	protected Triangle (double side1, double side2, double side3) {
		this.getting = GETTING.BY_3_SIDES;
		if (!Polygon.legalPolygon (side1, side2, side3))
			throw new IllegalArgumentException ("Illegal triangle sides");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public int getNumberOfSides () {
		return 3;
	}

	@Override
	public double getPerimeter () {
		return switch (this.getting) {
			case BY_3_SIDES -> this.side1 + this.side2 + this.side3;
			case BY_2_SIDES_AND_ANGLE -> this.side1 + this.side2 + Math.sqrt (Math.pow (this.side1, 2) +
					Math.pow (this.side2, 2) - 2 * this.side1 * this.side2 * Math.cos (this.angle1));
			case BY_2_ANGLES_AND_SIDE -> 2 * this.side1 * Math.sin (this.angle1 / 2) * Math.sin (this.angle2 / 2);
			case BY_BASE_AND_HEIGHT -> 2 * (this.base + this.height);
		};
	}

	@Override
	public double getArea () {
		return switch (this.getting) {
			case BY_3_SIDES -> {
				double s = this.getPerimeter () / 2;
				yield Math.sqrt (s * (s - this.side1) * (s - this.side2) * (s - this.side3));
			}
			case BY_2_SIDES_AND_ANGLE -> this.side1 * this.side2 * Math.sin (this.angle1) / 2;
			case BY_2_ANGLES_AND_SIDE -> Math.pow (this.side1, 2) * Math.sin (this.angle1) * Math.sin (this.angle2) / 2;
			case BY_BASE_AND_HEIGHT -> this.base * this.height / 2;
		};
	}

	/**
	 * @return true if the triangle is equilateral, false otherwise.
	 */
	public boolean isEquilateral () {
		return switch (this.getting) {
			case BY_3_SIDES -> this.side1 == this.side2 && this.side2 == this.side3;
			case BY_2_SIDES_AND_ANGLE -> this.side1 == this.side2;
			case BY_2_ANGLES_AND_SIDE -> this.angle1 == this.angle2;
			case BY_BASE_AND_HEIGHT -> Math.sqrt (Math.pow (this.base / 2, 2) + Math.pow (this.height, 2)) == this.base;
		};
	}

	/**
	 * @return true if the triangle is isosceles, false otherwise.
	 */
	public boolean isIsosceles () {
		return switch (this.getting) {
			case BY_3_SIDES -> this.side1 == this.side2 || this.side2 == this.side3 || this.side1 == this.side3;
			case BY_2_SIDES_AND_ANGLE -> this.side1 == this.side2 || this.side1 == this.side2 * Math.sin (this.angle1);
			case BY_2_ANGLES_AND_SIDE -> this.angle1 == this.angle2 || this.angle1 == Math.PI - this.angle2;
			case BY_BASE_AND_HEIGHT -> this.base == this.height || this.base == 2 * this.height;
		};
	}

	/**
	 * @return true if the triangle is rectangle, false otherwise.
	 */
	public boolean isRectangle () {
		return switch (this.getting) {
			case BY_3_SIDES -> Math.pow (this.side1, 2) + Math.pow (this.side2, 2) == Math.pow (this.side3, 2) ||
					Math.pow (this.side2, 2) + Math.pow (this.side3, 2) == Math.pow (this.side1, 2) ||
					Math.pow (this.side1, 2) + Math.pow (this.side3, 2) == Math.pow (this.side2, 2);
			case BY_2_SIDES_AND_ANGLE -> this.side1 == this.side2 * Math.sin (this.angle1);
			case BY_2_ANGLES_AND_SIDE -> this.angle1 == Math.PI / 2 || this.angle2 == Math.PI / 2;
			case BY_BASE_AND_HEIGHT -> this.base == this.height;
		};
	}
}