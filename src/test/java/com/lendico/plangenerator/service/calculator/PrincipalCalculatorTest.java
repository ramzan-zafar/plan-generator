package com.lendico.plangenerator.service.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrincipalCalculatorTest {

	private static final Double EXPECTED_PRINCIPAL = 800.00;
	private static final Double ANNUITY = 1000.00;
	private static final Double INTREST = 200.00;

	private PrincipalCalculator undeTest = new PrincipalCalculator();

	@Test
	public void testCalculate() {
		assertEquals(EXPECTED_PRINCIPAL, undeTest.calculate(ANNUITY, INTREST));
	}

}
