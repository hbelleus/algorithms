package fr.abnegative.algorithms.number.search;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LinearSearchTest {

	private final LinearSearch linearSearch = new LinearSearch();

	@DisplayName("Test for found values")
	@ParameterizedTest
	@MethodSource
	void searchTest_found(int[] ints, int value) {

		Assertions.assertNotEquals(-1, linearSearch.search(ints, value));

	}

	static Stream<Arguments> searchTest_found() {

		int[] ints = new int[] { 1, 3, 9, 12, 14, 16, 28, 49, 100, 104, 148, 209 };

		return Stream.of(1, 3, 16, 49, 28, 209).map(value -> Arguments.of(ints, value));
	}

	@DisplayName("Test for not found values")
	@ParameterizedTest
	@MethodSource
	void searchTest_notFound(int[] ints, int value) {

		Assertions.assertEquals(-1, linearSearch.search(ints, value));
	}

	static Stream<Arguments> searchTest_notFound() {

		int[] ints = new int[] { 1, 3, 9, 12, 14, 16, 28, 49, 100, 104, 148, 209 };

		return Stream.of(0, 13, 149, 310).map(value -> Arguments.of(ints, value));
	}

}
