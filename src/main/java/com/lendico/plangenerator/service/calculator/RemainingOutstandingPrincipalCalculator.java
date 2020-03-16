package com.lendico.plangenerator.service.calculator;

import org.springframework.stereotype.Component;

import com.lendico.plangenerator.service.model.Amount;

@Component
public class RemainingOutstandingPrincipalCalculator {

	public Double calculate(Double principal, Double intialOutstandingPrincipal) {
		return principal > intialOutstandingPrincipal ? new Amount(Double.valueOf(0)).doubleValueWithRounding()
				: new Amount(intialOutstandingPrincipal - principal).doubleValueWithRounding();
	}

}
