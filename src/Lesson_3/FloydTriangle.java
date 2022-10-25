package Lesson_3;

public class FloydTriangle implements ShapeNumber {
	private final int height;

	public FloydTriangle () {
		this.height = ShapeNumber.DEFAULT_HEIGHT;
	}

	public FloydTriangle (int triangleHeight) {
		this.height = triangleHeight;
	}

	private int getWidthOfNumber () {
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
				System.out.printf ((" %" + this.getWidthOfNumber () + "d"), counter);
			}
			System.out.println ();
		}
	}
}
