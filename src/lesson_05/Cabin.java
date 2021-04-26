package lesson_05;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cabin {
	private ReentrantReadWriteLock lock;
	private Semaphore semaphore;
	private String value;

	public Cabin(String value, int permits) {
		this.semaphore = new Semaphore(permits);
		this.value = value;
		lock = new ReentrantReadWriteLock();
	}

	public Cabin(String value) {
		this(value, 4);
	}

	public void enter(String mixValue) {
		try {
			System.out.println("Someone is going to enter the cabin...");
			semaphore.acquire();

			changeValue(mixValue);

			System.out.println("Someone is entered...");
			readValue();

			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
			System.out.println("Cabin released...");
		}
	}

	private void readValue() {
		try {
			lock.readLock().lock();
			System.out.println("value = " + value);
		} finally {
			lock.readLock().unlock();
		}
	}

	private void changeValue(String mixValue) {
		try {
			lock.writeLock().lock();
			value = "A" + mixValue + value + new Random().nextInt(20);
		} finally {
			lock.writeLock().unlock();
		}

	}
}
