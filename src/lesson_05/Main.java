package lesson_05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
//		doSemaphoreDemo();

//		doCountDownLength();

		doCyclicBarrierDemo();
	}

	private static void doSemaphoreDemo() {
		Cabin cabin = new Cabin("line", 3);

		ExecutorService service = Executors.newFixedThreadPool(5);
		service.execute(() -> cabin.enter("T1"));
		service.execute(() -> cabin.enter("T2"));
		service.execute(() -> cabin.enter("T3"));
		service.execute(() -> cabin.enter("T4"));
		service.execute(() -> cabin.enter("T5"));
		service.execute(() -> cabin.enter("T6"));


		service.shutdown();
	}

	private static void doCountDownLength() {
		new RocketStation().launch();
	}

	private static void doCyclicBarrierDemo() {
		new CarCargoShipDock().launch();
	}
}
