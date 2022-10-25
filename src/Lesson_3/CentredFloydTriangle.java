package Lesson_3;

public class CentredFloydTriangle extends FloydTriangle {
	public CentredFloydTriangle () {
		super ();
	}

	public CentredFloydTriangle (int shapeHeight) {
		super (shapeHeight);
	}

	@Override
	public void show () {
		int counter = 0;
		for (int i = 1; i <= this.height; i++) {
			for (int j = 0; j < this.height - i; j++)
				for(int k = 0; k < this.getWidthOfNumber (); k++)
					System.out.print (" ");
			for (int j = 0; j < i; j++) {
				counter++;
				for(int k = 0; k < this.getWidthOfNumber (); k++)
					System.out.print (" ");
				System.out.printf (("%0" + this.getWidthOfNumber () + "d"), counter);
			}
			System.out.println ();
		}
	}
}
