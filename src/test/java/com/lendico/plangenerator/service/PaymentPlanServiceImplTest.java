package com.lendico.plangenerator.service;

import static org.junit.Assert.assertEquals;

import java.time.ZonedDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lendico.plangenerator.service.model.BorrowerPlanDto;
import com.lendico.plangenerator.service.model.PlanRequest;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentPlanServiceImplTest {

	private static final Double TEST_LOAN = 5000.0;
	private static final Double TEST_INTEREST_PERCENT = 0.05;
	private static final Integer TEST_DURATION = 24;
	private static final ZonedDateTime TEST_DATE = ZonedDateTime.now();

	
	//EXPECTED FIRST PLAN VALUES
	private static final Double PLAN_ONE_EXPECTED_BORROWER_PAYMENT_AMOUNT = 219.36;
	private static final Double PLAN_ONE_EXPECTED_INITIAL_OUTSTANDING_PRINCIPAL = 5000.00;
	private static final Double PLAN_ONE_EXPECTED_INTEREST = 20.83;
	private static final Double PLAN_ONE_EXPECTED_PRINCIPAL = 198.53;
	private static final Double PLAN_ONE_REMAINING_OUTSTANDING_PRINCIPAL = 4801.47;
	
	//EXPECTED SECOND PLAN VALUES
	private static final Double PLAN_SECOND_EXPECTED_BORROWER_PAYMENT_AMOUNT = 219.36;
	private static final Double PLAN_SECOND_EXPECTED_INITIAL_OUTSTANDING_PRINCIPAL = 4801.47;
	private static final Double PLAN_SECOND_EXPECTED_INTEREST = 20.01;
	private static final Double PLAN_SECOND_EXPECTED_PRINCIPAL = 199.35;
	private static final Double PLAN_SECOND_REMAINING_OUTSTANDING_PRINCIPAL = 4602.12;
	
	
	//EXPECTED LAST PLAN VALUES
	private static final Double PLAN_LAST_EXPECTED_BORROWER_PAYMENT_AMOUNT = 219.28;
	private static final Double PLAN_LAST_EXPECTED_INITIAL_OUTSTANDING_PRINCIPAL = 218.37;
	private static final Double PLAN_LAST_EXPECTED_INTEREST = 0.91;
	private static final Double PLAN_LAST_EXPECTED_PRINCIPAL = 218.37;
	private static final Double PLAN_LAST_REMAINING_OUTSTANDING_PRINCIPAL = 0.00;

	
	


	@Autowired
	private PaymentPlanServiceImpl underTest;

	@Test
	public void generatePaymentPlan() {
		List<BorrowerPlanDto> borrowerPlanDtos = underTest.generatePaymentPlan(createPlanRequest());
		
		
		BorrowerPlanDto firstPlam = borrowerPlanDtos.get(0);
		BorrowerPlanDto secondPlan = borrowerPlanDtos.get(1);
		BorrowerPlanDto lastPlan = borrowerPlanDtos.get(borrowerPlanDtos.size() - 1);
		
		
		assertEquals(PLAN_ONE_EXPECTED_BORROWER_PAYMENT_AMOUNT, firstPlam.getBorrowerPaymentAmount());
        assertEquals(PLAN_ONE_EXPECTED_INITIAL_OUTSTANDING_PRINCIPAL, firstPlam.getInitialOutstandingPrincipal());
        assertEquals(PLAN_ONE_EXPECTED_INTEREST, firstPlam.getIntrest());
        assertEquals(PLAN_ONE_EXPECTED_PRINCIPAL, firstPlam.getPrincipal());
        assertEquals(PLAN_ONE_REMAINING_OUTSTANDING_PRINCIPAL, firstPlam.getRemainingOutstandingPrincipal());

        assertEquals(PLAN_SECOND_EXPECTED_BORROWER_PAYMENT_AMOUNT, secondPlan.getBorrowerPaymentAmount());
        assertEquals(PLAN_SECOND_EXPECTED_INITIAL_OUTSTANDING_PRINCIPAL, secondPlan.getInitialOutstandingPrincipal());
        assertEquals(PLAN_SECOND_EXPECTED_INTEREST, secondPlan.getIntrest());
        assertEquals(PLAN_SECOND_EXPECTED_PRINCIPAL, secondPlan.getPrincipal());
        assertEquals(PLAN_SECOND_REMAINING_OUTSTANDING_PRINCIPAL, secondPlan.getRemainingOutstandingPrincipal());

        assertEquals(PLAN_LAST_EXPECTED_BORROWER_PAYMENT_AMOUNT, lastPlan.getBorrowerPaymentAmount());
        assertEquals(PLAN_LAST_EXPECTED_INITIAL_OUTSTANDING_PRINCIPAL, lastPlan.getInitialOutstandingPrincipal());
        assertEquals(PLAN_LAST_EXPECTED_INTEREST, lastPlan.getIntrest());
        assertEquals(PLAN_LAST_EXPECTED_PRINCIPAL, lastPlan.getPrincipal());
        assertEquals(PLAN_LAST_REMAINING_OUTSTANDING_PRINCIPAL, lastPlan.getRemainingOutstandingPrincipal());
		
	}

	private PlanRequest createPlanRequest() {
		return PlanRequest.builder().duration(TEST_DURATION).loanAmount(TEST_LOAN).nominalRate(TEST_INTEREST_PERCENT)
				.startDate(TEST_DATE).build();
	}

}
