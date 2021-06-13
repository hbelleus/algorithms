package fr.abnegative.katas;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	private static final String VALUE_FOR_3 = "Fizz";
	private static final String VALUE_FOR_5 = "Buzz";
	private static final String VALUE_FOR_7 = "Whizz";

	public List<String> print(PrintStream printer) {

		List<String> values = new ArrayList<>(100);

		for (var i = 1; i <= 100; i++) {

			var value = this.print(i, printer);

			values.add(value);
		}

		return values;
	}

	public String print(int i, PrintStream printer) {

		var value = "";

		value = this.identifyValue(i, 3, value, VALUE_FOR_3);

		value = this.identifyValue(i, 5, value, VALUE_FOR_5);

		value = this.identifyValue(i, 7, value, VALUE_FOR_7);

		if (value.isEmpty()) {
			value = String.valueOf(i);

			if (value.endsWith("3"))
				value = VALUE_FOR_3;
		}

		printer.println(value);

		return value;
	}

	private String identifyValue(int i, int divisor, String value, String output) {

		if (this.isMultipleOf(i, divisor))
			return value.concat(output);

		return value;
	}

	private boolean isMultipleOf(int testedValue, int divisor) {
		return testedValue % divisor == 0;
	}

}
