package lesson_01.wilcard_03;

public class GenericBox<T> {
	private T object;

	public void put(T o) {
		System.out.println("Открываем ящик");
		System.out.println("Предмет " + o + " помещен в ящик");
		this.object = o;
		System.out.println("Закрываем ящик\n=====================");
	}

	public T get() {
		System.out.println("Открываем ящик");
		if (object != null) {
			System.out.println("Предмет " + object + " доступен");
			System.out.println("Забираем предмет и закрываем ящик\n=====================");
			return object;
		} else {
			System.out.println("Ящик пуст");
		}
		return null;
	}
}