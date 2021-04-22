package lesson_04;

public class Package {
	private Object locker = new Object();

	private String data;
	private boolean isReceived = false; // флаг, указывающий на то, получены данные или нет

	public synchronized void send(String in) {
		if (isReceived) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		data = in;
		isReceived = true;
		notifyAll();

	}

	public synchronized String receive() {
		if (!isReceived) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		synchronized (locker) {
			System.out.println("sfdklglkdf");
			locker.notify();
			System.out.println("sfdklglkdf");

		}

		isReceived = false;
		notifyAll();
		return data;
	}

	/*
	      W
T1	------- ......
	      |       |
T2	W......-------
	 */
}
