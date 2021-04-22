package lesson_04;

public class Receiver implements Runnable {
	private Package data;

	public Receiver(Package data) {
		this.data = data;
	}

	@Override
	public void run() {
		for (String s = data.receive(); !"EOF".equals(s); s = data.receive()) {
			System.out.println(s);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
