package fr.abnegative.algorithms.number.identification;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenNumberIdentificationTest {

	private EvenNumberIdentification evenNumberIdentification;

	public EvenNumberIdentificationTest() {
		evenNumberIdentification = new EvenNumberIdentification();
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 2, 166, -254 })
	void isEven_successfull(int number) {
		Assertions.assertTrue(evenNumberIdentification.isEven(number));
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, 1, 55 })
	void isEven_isOdd(int number) {
		Assertions.assertFalse(evenNumberIdentification.isEven(number));
	}

	@DisplayName("Performance test")
	@ParameterizedTest
	@ValueSource(ints = { 1357283732, 900000002, 950009991 })
	void isEven_isOdd_Perf(int number) {

		Assumptions.assumeTrue(evenNumberIdentification.isEvenAsString(2));

		final long startTime = System.nanoTime();
		evenNumberIdentification.isEvenAsString(number);
		final long endTime = System.nanoTime();

		Assertions.assertTimeout(Duration.ofNanos(endTime - startTime), () -> evenNumberIdentification.isEven(number));
	}
}
