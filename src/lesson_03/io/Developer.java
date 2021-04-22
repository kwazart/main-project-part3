package lesson_03.io;

import java.io.Serializable;

public class Developer implements Serializable {
	private String name;
	private String language;
	transient private int salary;
	transient private Notebook notebook;

	public Developer(String name, String language, int salary) {
		this.name = name;
		this.language = language;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Developer{" +
				"name='" + name + '\'' +
				", language='" + language + '\'' +
				", salary=" + salary +
				'}';
	}
}
