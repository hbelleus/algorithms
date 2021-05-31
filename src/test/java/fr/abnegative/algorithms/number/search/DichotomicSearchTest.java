package fr.abnegative.algorithms.number.search;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DichotomicSearchTest {

	private DichotomicSearch dichotomicSearch = new DichotomicSearch();

	public static Stream<Arguments> searchTest_success() {

		int[] ints = new int[] { 1, 3, 9, 12, 14, 16, 28, 49, 100, 104, 148, 209 };

		return Stream.of(Arguments.of(ints, 1), Arguments.of(ints, 3), Arguments.of(ints, 16), Arguments.of(ints, 49),
				Arguments.of(ints, 28), Arguments.of(ints, 209));
	}

	@ParameterizedTest
	@MethodSource
	void searchTest_success(int[] ints, int value) {

		Assertions.assertTrue(dichotomicSearch.search(ints, value));
	}

	public static Stream<Arguments> searchTest_notPresent() {

		int[] ints = new int[] { 1, 3, 9, 12, 14, 16, 28, 49, 100, 104, 148, 209 };

		return Stream.of(Arguments.of(ints, 20), Arguments.of(ints, 101), Arguments.of(ints, 2000));
	}

	@ParameterizedTest
	@MethodSource
	void searchTest_notPresent(int[] ints, int value) {

		Assertions.assertFalse(dichotomicSearch.search(ints, value));
	}

}
