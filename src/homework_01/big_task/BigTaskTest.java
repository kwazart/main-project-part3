package homework_01.big_task;

public class BigTaskTest {
	public static void main(String[] args) {
		// создаём коробку для яблок и заполняем её
		Box<Apple> appleBox1 = new Box<>();
		for (int i = 0; i < 15; i++) {
			appleBox1.put(new Apple());
		}
		System.out.println("Коробка яблок №1 весит " + appleBox1.getWeight());

		// создаём коробку для апельсинов и заполняем её
		Box<Orange> orangeBox = new Box<>();
		for (int i = 0; i < 10; i++) {
			orangeBox.put(new Orange());
		}
		System.out.println("Коробка апельсинов весит " + orangeBox.getWeight());
		System.out.println("Вес коробок одинаковый: " + appleBox1.compare(orangeBox));

		Box<Apple> appleBox2 = new Box<>();
		for (int i = 0; i < 16; i++) {
			appleBox2.put(new Apple());
		}

		System.out.println("-------------------------------------------------------------------");
		System.out.println("Коробка яблок №1 весит " + appleBox1.getWeight());
		System.out.println("Коробка яблок №2 весит " + appleBox2.getWeight());
		System.out.println("--------------Пересыпаем яблоки из 1-й коробки во 2-ю -------------");

		appleBox1.merge(appleBox2);
		System.out.println("Коробка яблок №1 весит " + appleBox1.getWeight());
		System.out.println("Коробка яблок №2 весит " + appleBox2.getWeight());
	}
}
