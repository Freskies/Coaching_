package Lesson_2;

import org.jetbrains.annotations.Nullable;

public enum ClassCode {
	CLASS_1A, CLASS_1B, CLASS_1C,
	CLASS_2A, CLASS_2B, CLASS_2C,
	CLASS_3A, CLASS_3B, CLASS_3C,
	CLASS_4A, CLASS_4B, CLASS_4C,
	CLASS_5A, CLASS_5B, CLASS_5C;

	public static @Nullable ClassCode fromString (String string) {
		for (ClassCode classCode : ClassCode.values()) {
			if (classCode.toString().equals(string))
				return classCode;
		}
		return null;
	}

	@Override
	public String toString () {
		return super.toString ();
	}
}
