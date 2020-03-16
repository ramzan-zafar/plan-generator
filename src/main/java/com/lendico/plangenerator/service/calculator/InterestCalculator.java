package com.lendico.plangenerator.service.calculator;

import org.springframework.stereotype.Component;

import com.lendico.plangenerator.service.model.Amount;

@Component
public class InterestCalculator {

	private static final int DAYS_PER_MONTH = 30;
	private static final int DAYS_PER_YEAR = 360;

	public Double calculate(Double nominalInerest, Double intialOutStandingPrincipal) {

		Double interest = (nominalInerest * DAYS_PER_MONTH * intialOutStandingPrincipal) / DAYS_PER_YEAR;

		return new Amount(interest).doubleValueWithRounding();
	}

}
