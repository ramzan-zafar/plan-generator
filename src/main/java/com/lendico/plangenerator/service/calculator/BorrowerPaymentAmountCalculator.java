package com.lendico.plangenerator.service.calculator;

import org.springframework.stereotype.Component;

import com.lendico.plangenerator.service.model.Amount;

@Component
public class BorrowerPaymentAmountCalculator {

	public Double calulate(Double principal, Double interest) {
		return new Amount(principal + interest).doubleValueWithRounding();
	}

}
