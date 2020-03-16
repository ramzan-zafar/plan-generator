package com.lendico.plangenerator.api.converter;

import static org.junit.Assert.assertEquals;

import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.lendico.plangenerator.api.model.BorrowerPlanResponseModel;
import com.lendico.plangenerator.service.model.BorrowerPlanDto;

@RunWith(MockitoJUnitRunner.class)
public class BorrowerPlanConverterTest {

	private static Double BORROWER_PAYMENT_AMOUNT = Double.valueOf(219.36);
	private static ZonedDateTime DATE = ZonedDateTime.now();
	private static Double INITIAL_OUTSTANDING_PRINCIPAL = Double.valueOf(5_000.00);
	private static Double INTEREST = Double.valueOf(20.83);
	private static Double PRINCIPAL = Double.valueOf(198.53);
	private static Double REMAINING_PRINCIPAL = Double.valueOf(4801.47);

	private BorrowerPlanConverter underTest;

	@Before
	public void setup() {
		underTest = new BorrowerPlanConverter();
	}

	@Test
	public void testConvertShouldReturnBorrowerPlanResponseModelFromBorrowerPlanDto() {

		BorrowerPlanDto borrowerPlanDto = createBorrowerPlanDto();

		BorrowerPlanResponseModel result = underTest.convert(borrowerPlanDto);

		assertEquals(borrowerPlanDto.getBorrowerPaymentAmount(), result.getBorrowerPaymentAmount());
		assertEquals(borrowerPlanDto.getDate(), result.getDate());
		assertEquals(borrowerPlanDto.getInitialOutstandingPrincipal(), result.getInitialOutstandingPrincipal());
		assertEquals(borrowerPlanDto.getIntrest(), result.getInterest());
		assertEquals(borrowerPlanDto.getPrincipal(), result.getPrincipal());
		assertEquals(borrowerPlanDto.getRemainingOutstandingPrincipal(), result.getRemainingOutstandingPrincipal());
	}

	private BorrowerPlanDto createBorrowerPlanDto() {
		return BorrowerPlanDto.builder().borrowerPaymentAmount(BORROWER_PAYMENT_AMOUNT).date(DATE)
				.initialOutstandingPrincipal(INITIAL_OUTSTANDING_PRINCIPAL).intrest(INTEREST).principal(PRINCIPAL)
				.remainingOutstandingPrincipal(REMAINING_PRINCIPAL).build();
	}

}
