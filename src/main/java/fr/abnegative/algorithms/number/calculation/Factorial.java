package fr.abnegative.algorithms.number.calculation;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

public class Factorial {

	public double calculate(List<String> values) {

		var num = Integer.parseInt(values.get(0)); // take argument as command line
		var result = 1;
		while (num > 0) {
			result = result * num;
			num--;
		}

		return Double.valueOf(result);
	}

	public double calculateOptimization(List<String> values) {

		return IntStream.rangeClosed(1, Integer.parseInt(values.get(0))).reduce(1, (x, y) -> x * y);
	}

	public String calculatePrecisely(List<String> values) {

		var num = BigInteger.valueOf(Long.valueOf(values.get(0))); // take argument as command line
		var result = BigInteger.valueOf(1);
		while (num.intValue() > 0) {
			result = result.multiply(num);
			num = num.subtract(BigInteger.valueOf(1));
		}

		return String.valueOf(result);
	}

}
