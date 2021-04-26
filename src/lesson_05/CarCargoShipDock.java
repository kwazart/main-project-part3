package lesson_05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarCargoShipDock {
	private CyclicBarrier barrier;



	public void launch() {
		barrier = new CyclicBarrier(4);

		ExecutorService service = Executors.newFixedThreadPool(4);

		service.execute(() -> new CargoShip(barrier).launch());
		service.execute(() -> new Car(barrier, "BMW").embark());
		service.execute(() -> new Car(barrier, "Toyota").embark());
		service.execute(() -> new Car(barrier, "GAZ").embark());

		service.shutdown();

	}

	static class CargoShip {
		private CyclicBarrier barrier;

		public CargoShip(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		public void launch() {
			try {
				System.out.println("Cargo ship is going to set off..");
				barrier.await();
				System.out.println("Buy!");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

	static class Car {
		private CyclicBarrier barrier;
		private String name;

		public Car(CyclicBarrier barrier, String name) {
			this.barrier = barrier;
			this.name = name;
		}

		public void embark() {
			try {
				System.out.println(String.format("Car %s is parking...", name));
				Thread.sleep(1000 + (int)(3000 * Math.random()));
				barrier.await();
				System.out.println(String.format("Car %s is going to next island...", name));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
