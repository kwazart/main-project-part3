package lesson_01.homework01;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box<?>> {
	@Override
	public int compare(Box<?> o1, Box<?> o2) {
		return (int) (o1.getFruits().get(0).getWeight() * o1.getFruits().size() -
				o2.getFruits().get(0).getWeight() * o2.getFruits().size());
	}
}
