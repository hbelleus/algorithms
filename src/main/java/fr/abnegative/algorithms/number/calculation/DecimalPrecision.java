package fr.abnegative.algorithms.number.calculation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class DecimalPrecision {

	public double calculateWithoutPrecision(List<String> values) {

		return values.stream().mapToDouble(Double::valueOf).reduce((x, y) -> x + y).orElse(0d);

	}

	private Optional<BigDecimal> calculatePrecisely(List<String> values) {

		return values.stream().map(BigDecimal::new).reduce((x, y) -> x.add(y));

	}

	public double calculate(List<String> values) {

		return calculatePrecisely(values).orElseThrow().doubleValue();

	}

}
