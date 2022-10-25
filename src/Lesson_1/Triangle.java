package Lesson_1;

import org.jetbrains.annotations.Contract;

public class Triangle {
	double a, b, c;

	public Triangle (double a, double b, double c) {
		this.setA (a);
		this.setB (b);
		this.setC (c);
		if (!this.isTriangle ())
			throw new IllegalArgumentException ("Invalid triangle.");
	}

	public void setA (double a) {
		this.checkSide (a);
		this.a = a;
	}

	public void setB (double b) {
		this.checkSide (b);
		this.b = b;
	}

	public void setC (double c) {
		this.checkSide (c);
		this.c = c;
	}

	private void checkSide (double side) {
		if (side <= 0)
			throw new IllegalArgumentException ("Side cannot be negative or zero.");
	}

	@Contract (pure = true)
	private boolean isTriangle () {
		return this.a + this.b > this.c &&
				this.a + this.c > this.b &&
				this.b + this.c > this.a;
	}

	public double getPerimeter () {
		if (!this.isTriangle ())
			throw new IllegalArgumentException ("This is not a triangle.");
		return this.a + this.b + this.c;
	}

	public double getArea () {
		double semiPerimeter = this.getPerimeter () / 2;
		return Math.sqrt (
				semiPerimeter *
						(semiPerimeter - this.a) *
						(semiPerimeter - this.b) *
						(semiPerimeter - this.c)
		);
	}
}
