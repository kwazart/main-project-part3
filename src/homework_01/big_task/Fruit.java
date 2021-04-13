package homework_01.big_task;

public abstract class Fruit {
	final float WEIGHT;

	public Fruit(float WEIGHT) {
		this.WEIGHT = WEIGHT;
	}

	@Override
	public String toString() {
		return "фрукт";
	}

	public float getWEIGHT() {
		return WEIGHT;
	}
}
