package lesson_05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RocketStation {
	static class Rocket {
		private CountDownLatch countDownLatch;

		public Rocket(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		public void launch() {
			try {
				System.out.println("Rocket is going to launch...");
				System.out.println("Waiting for a tanker...");
				countDownLatch.await(5, TimeUnit.SECONDS);
				System.out.println("THREE... TWO... ONE... START!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Tanker {
		private CountDownLatch countDownLatch;

		public Tanker(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		public void fuel() {
			for (int i = 1; i < 4 ; i++) {
				try {
					System.out.println("Tanker #" + i);
					System.out.println("Fueling...");
					Thread.sleep(2000);
					System.out.println("Tanker #" + i + ". Complete\n");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					countDownLatch.countDown();
				}
			}
		}
	}

	public void launch() {
		ExecutorService service = Executors.newFixedThreadPool(2);
		CountDownLatch countDownLatch = new CountDownLatch(3);

		service.execute(() -> new Rocket(countDownLatch).launch());
		service.execute(() -> new Tanker(countDownLatch).fuel());

		service.shutdown();
	}
}
