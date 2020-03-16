package com.lendico.plangenerator.service.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BorrowerPaymentAmountCalculatorTest {

	private static final Double EXPECTED_PAYMENT_AMOUNT = 6000.00;
	private static final Double PRINCIPAL_AMOUNT = 5000.00;
	private static final Double INTEREST_AMOUN = 1000.00;

	private BorrowerPaymentAmountCalculator undeTest = new BorrowerPaymentAmountCalculator();

	@Test
	public void testCalculate() {
		assertEquals(EXPECTED_PAYMENT_AMOUNT, undeTest.calulate(PRINCIPAL_AMOUNT, INTEREST_AMOUN));
	}

}
