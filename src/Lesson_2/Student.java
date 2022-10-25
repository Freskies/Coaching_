package Lesson_2;

import org.jetbrains.annotations.NotNull;

public class Student extends Person {
	private ClassCode classCode;

	public Student (String name, String surname, int age, String classCode) {
		super (name, surname, age);
		this.setClassCode (classCode);
	}

	public Student (@NotNull Person person) {
		super (person.getName(), person.getSurname(), person.getAge());
	}

	// SETTERS
	public void setClassCode (String classCode) {
		this.classCode = ClassCode.fromString (classCode);
		if (this.classCode == null)
			throw new IllegalArgumentException ("Invalid class code.");
	}

	// GETTER

	public ClassCode getClassCode () {
		return this.classCode;
	}

	// METHODS

	public boolean isInClass (ClassCode classCode) {
		return this.classCode == classCode;
	}

	public static boolean areInSameClass (Student... students) {
		if (students.length == 0)
			throw new IllegalArgumentException ("No students provided.");
		ClassCode classCode = students[0].getClassCode ();
		for (Student student : students) {
			if (student == null || student.getClassCode () != classCode)
				return false;
		}
		return true;
	}
}
