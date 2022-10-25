package Lesson_1;

public class Square extends Rectangle {
	public Square (double side) {
		super (side, side);
	}

	public void setSide (double side) {
		super.setWidth (side);
		super.setHeight (side);
	}

	@Override
	public void setHeight (double height) {
		this.setSide (height);
	}

	@Override
	public void setWidth (double width) {
		this.setSide (width);
	}
}
