package com.lendico.plangenerator.service.calculator;

import org.springframework.stereotype.Component;

import com.lendico.plangenerator.service.model.Amount;

@Component
public class AnnuityCalculator {

	private static final int NUMBER_OF_MONTH_PER_YEAR = 12;

	public Double calulate(Double presentValue, Double annualRatePerPeriod, Integer numberOfPeriods) {

		Double montlyRatePerPeriod = annualRatePerPeriod / NUMBER_OF_MONTH_PER_YEAR;

		Double divident = presentValue * montlyRatePerPeriod;

		Double divisor = 1 - Math.pow(1 + montlyRatePerPeriod, -numberOfPeriods);

		return new Amount(divident / divisor).doubleValueWithRounding();
	}

}
