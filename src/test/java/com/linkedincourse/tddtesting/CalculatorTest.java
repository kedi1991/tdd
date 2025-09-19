package com.linkedincourse.tddtesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

	@Test
	void testDivideTwoNumbers() {
		Calculator calculator = new Calculator();
		
		Double result = calculator.divide(10.0,5.0);
		
		assertEquals(2.0, result);
	}
	
	@Test
	void testDivideByZero() {
		
		Calculator calculator = new Calculator();
		//Double result = calculator.divide(10.0,0.0);

		assertThrows(ArithmeticException.class , () -> calculator.divide(10.0, 0.0));
		
	}
	@Test
	void testDivideNegativeNumbers() {
		Calculator calculator = new Calculator();
		Double result = calculator.divide(-20.0, -5.0);
		
		assertEquals(4, result);
	}
}
 