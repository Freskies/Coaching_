package Lesson_3;

import org.jetbrains.annotations.Contract;

public abstract class Shape {
	public static final int DEFAULT_HEIGHT = 5;
	protected final int height;

	public Shape () {
		this.height = Shape.DEFAULT_HEIGHT;
	}

	public Shape (int shapeHeight) {
		if (Shape.isHeightValid (shapeHeight))
			this.height = shapeHeight;
		else
			throw new IllegalArgumentException ("Height must be greater than 0");
	}
	
	@Contract (pure = true)
	public static boolean isHeightValid (int height) {
		return height > 0;
	}
	
	public abstract void show ();
}
