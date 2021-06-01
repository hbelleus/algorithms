package fr.abnegative.algorithms.number.sort;

import java.time.Duration;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BubbleSortTest extends SorterFunctionalTest {

	BubbleSortTest() {
		super(new BubbleSort());
	}

	@Override
	@Ignore("This test exceed any consensual or accetable value of execution time")
	@DisplayName("Testing sort method on large list")
	@ParameterizedTest
	@MethodSource
	public void sortTest_LargeListSize(int[] A) {

		sorter.sort(A);

		Assertions.assertTimeout(Duration.ofSeconds(2), () -> sorter.sort(A));

	}
}
