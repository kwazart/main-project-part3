package lesson_01.arrays_04;

import lesson_01.wilcard_03.Apple;
import lesson_01.wilcard_03.GenericBox;
import lesson_01.wilcard_03.Lemon;
import lesson_01.wilcard_03.Product;

public class Main04 {
	public static void main(String[] args) {
//		GenericBox<Apple>[] boxes1 = new GenericBox[10];
//		GenericBox<Apple>[] boxes2 = new GenericBox<Apple>[10];
//		GenericBox[] boxes3 = new GenericBox[10];

		GenericBox<?>[] boxes4 = new GenericBox<?>[10];
		boxes4[0] = new GenericBox<Apple>();
		boxes4[1] = new GenericBox<Lemon>();

		GenericBox<Apple> appleBox = new GenericBox<>();
		appleBox.put(new Apple());
		boxes4[0] = appleBox;
	}
}
