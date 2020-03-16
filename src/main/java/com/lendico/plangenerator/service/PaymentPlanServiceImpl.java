package com.lendico.plangenerator.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lendico.plangenerator.service.calculator.AnnuityCalculator;
import com.lendico.plangenerator.service.calculator.BorrowerPaymentAmountCalculator;
import com.lendico.plangenerator.service.calculator.InterestCalculator;
import com.lendico.plangenerator.service.calculator.PrincipalCalculator;
import com.lendico.plangenerator.service.calculator.RemainingOutstandingPrincipalCalculator;
import com.lendico.plangenerator.service.model.Amount;
import com.lendico.plangenerator.service.model.BorrowerPlanDto;
import com.lendico.plangenerator.service.model.PlanRequest;

@Service
public class PaymentPlanServiceImpl implements PaymentPlanService {

	private AnnuityCalculator annuityCalculator;
	private PrincipalCalculator principalCalculator;
	private InterestCalculator interestCalculator;
	private BorrowerPaymentAmountCalculator borrowerPaymentAmountCalculator;
	private RemainingOutstandingPrincipalCalculator remainingOutstandingPrincipalCalculator;

	public PaymentPlanServiceImpl(AnnuityCalculator annuityCalculator, PrincipalCalculator principalCalculator,
			InterestCalculator interestCalculator, BorrowerPaymentAmountCalculator borrowerPaymentAmountCalculator,
			RemainingOutstandingPrincipalCalculator remainingOutstandingPrincipalCalculator) {
		this.annuityCalculator = annuityCalculator;
		this.principalCalculator = principalCalculator;
		this.interestCalculator = interestCalculator;
		this.borrowerPaymentAmountCalculator = borrowerPaymentAmountCalculator;
		this.remainingOutstandingPrincipalCalculator = remainingOutstandingPrincipalCalculator;
	}

	@Override
	public List<BorrowerPlanDto> generatePaymentPlan(PlanRequest planRequest) {

		List<BorrowerPlanDto> borrowerPlanList = new ArrayList<>();

		final Double annuity = annuityCalculator.calulate(planRequest.getLoanAmount(), planRequest.getNominalRate(),
				planRequest.getDuration());

		Double outstandingPrincipalAmount = new Amount(planRequest.getLoanAmount()).doubleValueWithRounding();

		for (int i = 0; i < planRequest.getDuration(); i++) {

			ZonedDateTime payoutDay = planRequest.getStartDate().plusMonths(i);
			Double interest = interestCalculator.calculate(planRequest.getNominalRate(), outstandingPrincipalAmount);
			Double principal = calculatePrincipalAmount(annuity, interest, outstandingPrincipalAmount);
			Double borrowerPaymentAmount = borrowerPaymentAmountCalculator.calulate(principal, interest);
			Double remainingOutStandingPrincipal = remainingOutstandingPrincipalCalculator.calculate(principal,
					outstandingPrincipalAmount);

			BorrowerPlanDto borrowerPlan = BorrowerPlanDto.builder().borrowerPaymentAmount(borrowerPaymentAmount)
					.date(payoutDay).initialOutstandingPrincipal(outstandingPrincipalAmount).intrest(interest)
					.principal(principal).remainingOutstandingPrincipal(remainingOutStandingPrincipal).build();

			outstandingPrincipalAmount = new Amount(outstandingPrincipalAmount - principal).doubleValueWithRounding();
			
			borrowerPlanList.add(borrowerPlan);
		}
		
		return borrowerPlanList;
	}

	private Double calculatePrincipalAmount(final Double annuity, final Double interest,
			final Double outstandingPrincipalAmount) {
		Double principal = principalCalculator.calculate(annuity, interest);

		if (principal.compareTo(outstandingPrincipalAmount) > 0) {
			principal = outstandingPrincipalAmount;
		}
		return principal;
	}

}
