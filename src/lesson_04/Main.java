package lesson_04;

import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Package data = new Package();
//		Sender sender = new Sender(data);
//		Receiver receiver = new Receiver(data);

		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(new Sender(data));
		service.execute(new Receiver(data));

//		new Thread(sender).start();
//		new Thread(receiver).start();

		Future<String> future = service.submit(() -> "Hello world!");
		System.out.println(future.get());

		service.shutdown();
	}
}
