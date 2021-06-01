package fr.abnegative.algorithms.number.sort;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class HeapSortTest extends SorterFunctionalTest {

	HeapSortTest() {
		super(new HeapSort());
	}

	@Override
	@DisplayName("Testing sort method on large list")
	@ParameterizedTest
	@MethodSource
	public void sortTest_LargeListSize(int[] A) {

		super.sortValidation(A);
		
		Assertions.assertTimeout(Duration.ofSeconds(2), () -> sorter.sort(A));

	}
}
