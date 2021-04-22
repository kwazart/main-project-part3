package lesson_04;

import java.util.List;

public class Sender implements Runnable {
	private Package data;

	public Sender(Package data) {
		this.data = data;
	}

	@Override
	public void run() {
		List<String> packages = List.of(
				"hello world! #1",
				"hello world! #2",
				"hello world! #3",
				"hello world! #4",
				"hello world! #5",
				"hello world! #6",
				"hello world! #7",
				"EOF"
		);

		for (String pack : packages) {
			data.send(pack); // записываем/отправляем данные в data

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
