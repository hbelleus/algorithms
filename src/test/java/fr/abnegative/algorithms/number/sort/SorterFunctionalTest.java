package fr.abnegative.algorithms.number.sort;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SorterFunctionalTest implements SorterDefinitionTest, SorterFunctionalCase {

	@NonNull
	protected Sorter sorter;

	@Override
	@DisplayName("Testing sort method on short list")
	@ParameterizedTest
	@MethodSource
	public void sortTest_ShortListSize(int[] A) {

		this.sortValidation(A);
	}

	@Override
	@DisplayName("Testing sort method on medium size list")
	@ParameterizedTest
	@MethodSource
	public void sortTest_MediumListSize(int[] A) {

		this.sortValidation(A);
	}

	protected void sortValidation(int[] A) {

		sorter.sort(A);

		MatcherAssert.assertThat(A, CoreMatchers.is(Arrays.stream(A).sorted().toArray()));
	}
}
