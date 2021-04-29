package com.polozov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

// TDD
public class OwnMathTest {

	@ParameterizedTest
	@MethodSource("maxParametersProvider")
	void shouldReturnMaxValueFromTwoPassed(int expected, int a, int b) {
		Assertions.assertEquals(expected, OwnMath.max(a, b));
	}

	private static Stream<Arguments> maxParametersProvider() {
		return List.of(
				Arguments.arguments(2, 1, 2),
				Arguments.arguments(1, 1, 1),
				Arguments.arguments(0, 0, 0),
				Arguments.arguments(-1, -1, -1),
				Arguments.arguments(1, 1, -1),
				Arguments.arguments(1, -1, 1)
		).stream();
	}

	@Test
	void shouldReturnMinValueFromTwoPassed() {
		Assertions.assertEquals(1, OwnMath.min(1, 2));
	}

	@Test
	void shouldThrowIllegalArgumentExceptionWhenZeroPassedDivider() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> OwnMath.divide(4, 0));
	}


	@ParameterizedTest
	@MethodSource("divisionParametersProvider")
	void shouldReturnDividedValue(double expected, double a, double b) {
		Assertions.assertEquals(expected, OwnMath.divide(a, b));
	}

	private static Stream<Arguments> divisionParametersProvider() {
		return Stream.of(
				Arguments.arguments(2, 6, 3),
				Arguments.arguments(2.5, 5, 2)
		);
	}

	@Test
	public void shouldDurationNotMoreTwoSeconds() {
		Assertions.assertTimeout(Duration.ofSeconds(2), () -> OwnMath.someMethod());
	}
}
