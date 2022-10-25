package Lesson_4;

public class Square extends Rectangle implements RegularPolygon {
	private final double side;

	public Square (double side) {
		super (side, side);
		this.side = side;
	}

	@Override
	public double getPerimeter () {
		return 4 * this.side;
	}
}
