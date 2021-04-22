package lesson_03.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectStream {
	public static void main(String[] args) {
		File file = new File("src/lesson_03/io/developers.txt");


		writeDeveloper(file);

		System.out.println(readDeveloper(file));
	}

	private static void writeDeveloper(File file) {
		Developer developer1 = new Developer("Mike", "Java", 4300);
		Developer developer2 = new Developer("John", "Python", 4300);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){

			oos.writeObject(developer1);
			oos.writeObject(developer2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Developer> readDeveloper(File file) {
		List<Developer> developerList = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			developerList.add((Developer) ois.readObject());
			developerList.add((Developer) ois.readObject());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return developerList;
	}
}
