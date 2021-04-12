package lesson_01.method_05;

public class Main05 {
	public static void main(String[] args) {
//		print(new Integer(35));
//		print(new Boolean("true"));

		Box<Apple> boxApple = new Box<>();
		Box<RottenApple> boxRottenApple = new Box<>();
		boxRottenApple.set(new RottenApple());
		merge(boxApple, boxRottenApple);
		System.out.println(boxApple.get());


	}

	private static <M, N extends M> void merge(Box<M> boxApple, Box<N> boxRottenApple) {
		N n = boxRottenApple.get();
		boxApple.set(n);
	}

	public static <T> void print(T value) {
		System.out.println(value);
	}

	public static <T1, T2> void method(T1 t1, T2 t2) {
		// ....
	}
}
