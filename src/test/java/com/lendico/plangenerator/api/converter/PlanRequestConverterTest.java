package com.lendico.plangenerator.api.converter;

import static org.junit.Assert.assertEquals;

import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.lendico.plangenerator.api.model.PlanRequestModel;
import com.lendico.plangenerator.service.model.PlanRequest;

@RunWith(MockitoJUnitRunner.class)
public class PlanRequestConverterTest {

	private static Integer DURATION = 24;
	private static ZonedDateTime DATE = ZonedDateTime.now();
	private static Double LOAN_AMOUNT = Double.valueOf(5_000.00);
	private static Double INTEREST_RATE = Double.valueOf(20.83);

	private PlanRequestConverter underTest;

	@Before
	public void setup() {
		underTest = new PlanRequestConverter();
	}

	@Test
	public void testConvertShouldReturnPlanRequestFromPlanRequestModel() {

		PlanRequestModel planRequestModel = createPlanRequestModel();

		PlanRequest result = underTest.convert(planRequestModel);

		assertEquals(planRequestModel.getDuration(), result.getDuration());
		assertEquals(planRequestModel.getStartDate(), result.getStartDate());
		assertEquals(planRequestModel.getLoanAmount(), result.getLoanAmount());
		assertEquals(Double.valueOf(planRequestModel.getNominalRate()/100), result.getNominalRate());
		
	}

	private PlanRequestModel createPlanRequestModel() {
		return PlanRequestModel.builder().duration(DURATION).loanAmount(LOAN_AMOUNT).nominalRate(INTEREST_RATE).startDate(DATE).build();
	}

}
