package Lesson_2;

public class Person {
	private String name;
	private String surname;
	private int age;

	public Person(String name, String surname, int age) {
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
	}

	// GETTERS

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getAge() {
		return this.age;
	}

	// SETTERS

	protected void setName(String name) {
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("Name cannot be null or empty.");
		this.name = name;
	}

	protected void setSurname(String surname) {
		if (surname == null || surname.isEmpty())
			throw new IllegalArgumentException("Surname cannot be null or empty.");
		this.surname = surname;
	}

	protected void setAge(int age) {
		if (age < 0)
			throw new IllegalArgumentException("Age cannot be negative.");
		this.age = age;
	}
}
