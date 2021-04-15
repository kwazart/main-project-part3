package lesson_01.homework01;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box<?>> {
	private List<T> fruits;

	public Box() {
		this.fruits = new ArrayList<>();
	}

	public List<T> getFruits() {
		return fruits;
	}

	public void add(T fruit) {
		fruits.add(fruit);
	}


	public void fillBox(Box<T> other) {
		fruits.addAll(other.getFruits());
		other.getFruits().clear();
	}

	@Override
	public int compareTo(Box<?> o) {
		return (int) (fruits.get(0).getWeight() * fruits.size() -
				o.getFruits().get(0).getWeight() * o.getFruits().size());
	}
}
