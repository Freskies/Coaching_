package Lesson_3;

public class FloydTriangle extends Shape {

	public FloydTriangle () {
		super ();
	}

	public FloydTriangle (int shapeHeight) {
		super (shapeHeight);
	}

	protected int getWidthOfNumber () {
		int counter = 0;
		for (int i = 1; i <= this.height; i++)
			for (int j = 0; j < i; j++)
				counter++;
		return String.valueOf (counter).length ();
	}

	@Override
	public void show () {
		int counter = 0;
		for (int i = 1; i <= this.height; i++) {
			for (int j = 0; j < i; j++) {
				counter++;
				System.out.printf ((" %0" + this.getWidthOfNumber () + "d"), counter);
			}
			System.out.println ();
		}
	}
}
