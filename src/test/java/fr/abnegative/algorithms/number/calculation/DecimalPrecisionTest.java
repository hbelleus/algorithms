package fr.abnegative.algorithms.number.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class DecimalPrecisionTest {

	private DecimalPrecision decimalPrecision;

	public DecimalPrecisionTest() {
		decimalPrecision = new DecimalPrecision();
	}

	@DisplayName("Test respecting double precision limitation")
	@ParameterizedTest
	@MethodSource
	void calculateWithoutPrecision_case1(List<String> values) {

		final double result = decimalPrecision.calculateWithoutPrecision(values);

		Assertions.assertEquals(11.4691, result);

	}

	static Stream<List<String>> calculateWithoutPrecision_case1() {

		List<List<String>> values = new ArrayList<>();
		values.add(List.of("10.459", "1.01010"));

		return values.stream();
	}

	@DisplayName("Test to show limitations of double precision")
	@ParameterizedTest
	@MethodSource
	void calculateWithoutPrecision_wrongResult(List<String> values) {

		final double result = decimalPrecision.calculateWithoutPrecision(values);

		Assertions.assertEquals(11.469109999999999, result);

	}

	static Stream<List<String>> calculateWithoutPrecision_wrongResult() {

		List<List<String>> values = new ArrayList<>();
		values.add(List.of("10.45901", "1.01010"));

		return values.stream();
	}

	@DisplayName("Test to validate BigDecimal solution")
	@ParameterizedTest
	@MethodSource
	void calculate_preciseResult(List<String> values) {

		final double result = decimalPrecision.calculate(values);

		Assertions.assertEquals(11.46911, result);

	}

	static Stream<List<String>> calculate_preciseResult() {

		List<List<String>> values = new ArrayList<>();
		values.add(List.of("10.45901", "1.01010"));

		return values.stream();
	}

}
