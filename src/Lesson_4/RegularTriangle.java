package Lesson_4;

public class RegularTriangle extends Triangle implements RegularPolygon {
	private final double side;

	public RegularTriangle(double side) {
		super(side, side, side);
		this.side = side;
	}

	@Override
	public double getArea() {
		return Math.sqrt(3) * Math.pow(this.side, 2) / 4;
	}
}
