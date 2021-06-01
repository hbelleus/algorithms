package fr.abnegative.algorithms.number.sort;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.provider.Arguments;

@TestInstance(Lifecycle.PER_CLASS)
public interface SorterFunctionalCase {

	static final int MEDIUM_SIZE = 2000;
	static final int LARGE_SIZE = 1000000;
	static final int[] MEDIUM_LIST = generateList(MEDIUM_SIZE);
	static final int[] LARGE_LIST = generateList(LARGE_SIZE);

	private static int[] generateList(int size) {

		var result = new int[size];
		var random = new Random(size);

		for (var i = 0; i < size - 1; i++) {

			result[i] = random.nextInt();
		}

		return result;
	}

	public static Stream<Arguments> sortTest_ShortListSize() {

		int[] ints = new int[] { 1, 42, 56, 9, 2000, 45, 76, 3, 98, 178, 456, 356, 76, 975, 9, 35 };

		return Stream.of(Arguments.of(ints));
	}

	public static Stream<Arguments> sortTest_MediumListSize() {

		return Stream.of(Arguments.of(MEDIUM_LIST));

	}

	public static Stream<Arguments> sortTest_LargeListSize() {

		return Stream.of(Arguments.of(LARGE_LIST));

	}
}
