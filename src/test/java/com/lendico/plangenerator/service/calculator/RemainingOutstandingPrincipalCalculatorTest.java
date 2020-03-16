package com.lendico.plangenerator.service.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemainingOutstandingPrincipalCalculatorTest {

	private static final Double EXPECTED_OUTSTANDING_ZERO = 0.00;
	private static final Double EXPECTED_REMAINING_OUTSTANDING_200 = 200.00;
	private static final Double PRINCIPAL = 1000.00;
	private static final Double INITIAL_OUTSTANDING_PAYMENT = 1200.00;

	private RemainingOutstandingPrincipalCalculator undeTest = new RemainingOutstandingPrincipalCalculator();

	@Test
	public void testCalculate() {
		assertEquals(EXPECTED_REMAINING_OUTSTANDING_200, undeTest.calculate(PRINCIPAL, INITIAL_OUTSTANDING_PAYMENT));
	}
	
	@Test
	public void testCalculateShouldReturnZeroWhenPricipalAmountIsGreaterThanIntialOutstandingPayment() {
		assertEquals(EXPECTED_OUTSTANDING_ZERO, undeTest.calculate(100.00, 50.00));
	}

}
