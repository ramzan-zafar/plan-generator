package com.lendico.plangenerator.service.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InterestCalculatorTest {

	private static final Double EXPECTED_INTEREST = 0.83;
	private static final Double INTEREST_RATE = 0.01;
	private static final Double INTIAL_OUTSTANDING_PRINCIPAL = 1000.00;

	private InterestCalculator undeTest = new InterestCalculator();

	@Test
	public void testCalculate() {
		assertEquals(EXPECTED_INTEREST, undeTest.calculate(INTEREST_RATE, INTIAL_OUTSTANDING_PRINCIPAL));
	}

}
