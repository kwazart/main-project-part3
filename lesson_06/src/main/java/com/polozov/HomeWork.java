package com.polozov;

public class HomeWork {
	public static int[] findAfterFour(int[] values) {
		if (values == null || values.length == 0) {
			throw new RuntimeException("Array cannot be empty");
		}

		int index = -1;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 4) {
				index = i + 1;
			}
		}

		if (index == -1) {
			throw new RuntimeException("There was not found - 4");
		}

		int[] copied = new int[values.length - index];
		System.arraycopy(values, index, copied, 0, copied.length);
		return copied;
	}
}
