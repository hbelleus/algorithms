package fr.abnegative.algorithms.number.calculation;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialTest {

	private Factorial factorial = new Factorial();

	@Test
	void calculateTest() {

		Assertions.assertEquals(120d, this.factorial.calculate(Arrays.asList("5")));
	}
	
	@Test
	void calculateOptimizationTest() {

		Assertions.assertEquals(120d, this.factorial.calculateOptimization(Arrays.asList("5")));
	}
	
	@Test
	void calculateTest_case2() {

		Assertions.assertEquals(3628800.0d, this.factorial.calculate(Arrays.asList("10")));
	}
	
	@Test
	void calculateOptimizationTest_case2() {

		Assertions.assertEquals(3628800.0d, this.factorial.calculateOptimization(Arrays.asList("10")));
	}
	
	@Test
	void calculate2Test_case1() {

		Assertions.assertEquals("3628800", this.factorial.calculatePrecisely(Arrays.asList("10")));
	}
	
	@Test
	void calculate2Test_case2() {

		Assertions.assertEquals("265252859812191058636308480000000", this.factorial.calculatePrecisely(Arrays.asList("30")));
	}
}
