package Lesson_3;

public interface ShapeNumber {
	int DEFAULT_HEIGHT = 10;

	void show ();

	static boolean checkHeight (int height) {
		return height > 0;
	}
}
