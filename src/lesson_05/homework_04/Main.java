package lesson_05.homework_04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new Printer.Executor("A", "B"));
		service.execute(new Printer.Executor("B", "C"));
		service.execute(new Printer.Executor("C", "A"));

		service.shutdown();
	}
}
