package homework_01;

import java.util.ArrayList;
import java.util.Arrays;

public class MyHomeworkClass {
	public static void main(String[] args) {
		// создаём тестовый массив
		String[] testArray = {"111", "222", "333", "444"};

		// тест первого задания
		change(testArray, 0, 1);
		System.out.println("-------------------------------");

		// тест второго задания
		ArrayList<?> a = toArrayList(testArray);
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i));
			if (i < a.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("");
		System.out.println("-------------------------------");

	}

	// 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
	public static <T> void change (T[] array, int firstIndex, int secondIndex) {
		System.out.println("Before change: " + Arrays.toString(array));
		T temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
		System.out.println("After change: " + Arrays.toString(array));
	}

	// 2. Написать метод, который преобразует массив в ArrayList;
	public static <E> ArrayList<E> toArrayList(E[] array) {
		ArrayList<E> result = new ArrayList<>();
		for (E t : array) {
			result.add(t);
		}
		return result;
	}
}
