package lesson_05.homework_04;

public class Printer {
	public static String symbol = "A";
	public static Object lock = new Object();

	public static class Executor implements Runnable {
		private String current;
		private String next;

		public Executor(String current, String next) {
			this.current = current;
			this.next = next;
		}

		@Override
		public void run() {
			synchronized (lock) {
				for (int i = 0; i < 3; i++) {
					try {
						while (!symbol.equals(current)) {
							lock.wait();
						}

						System.out.println(current);
						symbol = next;

						Thread.sleep(500);

						lock.notifyAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
