package Lesson_3;

public class BinaryFloydTriangle extends Shape {

	public BinaryFloydTriangle () {
		super ();
	}

	public BinaryFloydTriangle (int shapeHeight) {
		super (shapeHeight);
	}

	@Override
	public void show () {
		int start = 0;
		for (int i = 0; i < this.height; i++) {
			start = (start + 1) % 2;
			for (int j = 0; j <= i; j++)
				System.out.print ((j + start) % 2 + " ");
			System.out.println ();
		}
	}
}
