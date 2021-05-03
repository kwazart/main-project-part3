package com.polozov;

/*
2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class HomeWorkTest {
	@ParameterizedTest
	@NullAndEmptySource
	void shouldThrowRuntimeExceptionWhenArrayIsEmpty(int[] values) {
		Assertions.assertThrows(
				RuntimeException.class,
				() -> HomeWork.findAfterFour(values));
	}

	@Test
	void shouldThrowRuntimeExceptionWhenFourNotFound() {
		Assertions.assertThrows(
				RuntimeException.class,
				() -> HomeWork.findAfterFour(new int[] {1, 3}));
	}

	@Test
	void shouldReturnValuesAfterLastFour() {
		Assertions.assertArrayEquals(
				new int[] {1, 7},
				HomeWork.findAfterFour(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}));
	}

}
