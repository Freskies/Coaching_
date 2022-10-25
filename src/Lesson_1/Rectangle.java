package Lesson_1;

public class Rectangle {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.setWidth (width);
		this.setHeight (height);
	}

	// GETTERS

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	// SETTERS

	public void setWidth(double width) {
		if (width < 0)
			throw new IllegalArgumentException("Width cannot be negative.");
		this.width = width;
	}

	public void setHeight(double height) {
		if (height < 0)
			throw new IllegalArgumentException("Height cannot be negative.");
		this.height = height;
	}

	// METHODS

	public double getArea() {
		return this.width * this.height;
	}

	public double getPerimeter() {
		return 2 * (this.width + this.height);
	}
}
