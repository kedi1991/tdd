package com.linkedincourse.tddtesting;

public class Calculator {

	public Double divide(Double a, Double b) {
		
		Double result = 0.0;
		if (b != 0)
			result = a/b;
		else
			throw new ArithmeticException("Cannot divide by 0!");
		return result;
	}
}
