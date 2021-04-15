package lesson_01.homework01;

public class Fruit {
	private long id;
	private String name;
	private float weight;

	public Fruit(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Fruit(float weight) {
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Fruit{" +
				"id=" + id +
				", name='" + name + '\'' +
				", weight=" + weight +
				'}';
	}
}
