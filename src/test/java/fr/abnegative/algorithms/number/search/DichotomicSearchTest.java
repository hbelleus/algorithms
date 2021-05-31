package fr.abnegative.algorithms.number.search;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DichotomicSearchTest {

	private DichotomicSearch dichotomicSearch = new DichotomicSearch();
	private static int[] ints;

	@BeforeAll
	static void generateArray() {

		final var size = 1000000;

		ints = new int[size];

		for (var i = 1; i < size; i++) {
			ints[i] = new Random().nextInt();
		}

	}

	@DisplayName("Testing dichotomic search with null value")
	@ParameterizedTest
	@ValueSource(ints = { 0 })
	void searchTest_emptyArray(int value) {

		Assertions.assertFalse(dichotomicSearch.search(new int[0], value));
	}

	@DisplayName("Testing dichotomic search with existing value")
	@ParameterizedTest
	@MethodSource
	void searchTest_success(int[] ints, int value) {

		Assertions.assertTrue(dichotomicSearch.search(ints, value));
	}

	public static Stream<Arguments> searchTest_success() {

		int[] ints = new int[] { 1, 3, 9, 12, 14, 16, 28, 49, 100, 104, 148, 209 };

		return Stream.of(Arguments.of(ints, 1), Arguments.of(ints, 3), Arguments.of(ints, 16), Arguments.of(ints, 49),
				Arguments.of(ints, 28), Arguments.of(ints, 209));
	}

	@DisplayName("Testing dichotomic search with non existing value")
	@ParameterizedTest
	@MethodSource
	void searchTest_notPresent(int[] ints, int value) {

		Assertions.assertFalse(dichotomicSearch.search(ints, value));
	}

	public static Stream<Arguments> searchTest_notPresent() {

		int[] ints = new int[] { 1, 3, 9, 12, 14, 16, 28, 49, 100, 104, 148, 209 };

		return Stream.of(Arguments.of(ints, 20), Arguments.of(ints, 101), Arguments.of(ints, 2000));
	}

	@DisplayName("Testing recursive binary search")
	@ParameterizedTest
	@MethodSource
	void binarySearchTest_success(int[] ints, int value) {

		Assertions.assertTrue(dichotomicSearch.search(ints, value));
	}

	public static Stream<Arguments> binarySearchTest_success() {

		int[] ints = new int[] { 1, 3, 9, 12, 14, 16, 28, 49, 100, 104, 148, 209 };

		return Stream.of(Arguments.of(ints, 1), Arguments.of(ints, 3), Arguments.of(ints, 16), Arguments.of(ints, 49),
				Arguments.of(ints, 28), Arguments.of(ints, 209));
	}

	@DisplayName("Performance test")
	@ParameterizedTest
	@ValueSource(ints = { 1657, 2467, 950009, 14562, 7, 999999 })
	void recursivity_Perf(int number) {

		final long startTime = System.nanoTime();
		dichotomicSearch.search(ints, number);
		final long endTime = System.nanoTime();

		Assertions.assertTimeout(Duration.ofNanos(endTime - startTime),
				() -> dichotomicSearch.binarySearch(ints, number));

		final long startTime2 = System.nanoTime();
		dichotomicSearch.binarySearch(ints, number);
		final long endTime2 = System.nanoTime();

		Assertions.assertTrue(
				Duration.ofNanos(endTime - startTime).compareTo(Duration.ofNanos(endTime2 - startTime2)) > 0);
	}

}
