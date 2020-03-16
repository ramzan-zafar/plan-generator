package com.lendico.plangenerator.service.calculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AnnuityCalculatorTest {

	private static final Double EXPECTED_ANNUITY = 219.36;
	private static final Double TEST_LOAN = 5000.0;
	private static final Double TEST_INTEREST = 0.05;
	private static final Integer TEST_DURATION = 24;

	private AnnuityCalculator undeTest = new AnnuityCalculator();

	@Test
	public void testCalculate() {
		assertEquals(EXPECTED_ANNUITY, undeTest.calulate(TEST_LOAN, TEST_INTEREST, TEST_DURATION));
	}

}
