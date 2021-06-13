package fr.abnegative.katas;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FizzBuzzTest {

	private FizzBuzz fizzbuzz;

	private PrintStream printer = Mockito.mock(PrintStream.class);

	FizzBuzzTest() {
		fizzbuzz = new FizzBuzz();
	}

	@Test
	void printTest_iterate100times() {

		fizzbuzz.print(printer);

		this.validate_isCalled100times(printer);

	}

	private void validate_isCalled100times(PrintStream printer) {

		Mockito.verify(printer, Mockito.times(100)).println(Mockito.isA(String.class));
	}

	@Test
	void printTest_multipleOf3() {

		fizzbuzz.print(printer);

		var result = fizzbuzz.print(printer);

		this.validate_numberOfMultiples(result, "Fizz", 39);

	}

	@Test
	void printTest_multipleOf5() {

		var result = fizzbuzz.print(printer);

		this.validate_numberOfMultiples(result, "Buzz", 20);

	}

	@Test
	void printTest_multipleOf7() {

		var result = fizzbuzz.print(printer);

		this.validate_numberOfMultiples(result, "Whizz", 14);

	}

	private void validate_numberOfMultiples(List<String> result, String term, int numberOfMultiples) {

		Assertions.assertEquals(numberOfMultiples,
				result.stream().filter(value -> value.contains(term)).collect(Collectors.toList()).size());
	}
}
