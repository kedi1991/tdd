package com.linkedincourse.tddtesting;

import org.junit.jupiter.api.Test;
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

		assertThrows(new ArithmeticException().getClass() , () -> calculator.divide(10.0, 0.0));
		
	}
}
 