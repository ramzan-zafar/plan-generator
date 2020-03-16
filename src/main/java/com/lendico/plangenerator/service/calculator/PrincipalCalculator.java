package com.lendico.plangenerator.service.calculator;

import org.springframework.stereotype.Component;

import com.lendico.plangenerator.service.model.Amount;

@Component
public class PrincipalCalculator {
	
	public Double calculate(Double annuity,Double intrest) {
		return new Amount(annuity - intrest).doubleValueWithRounding();
	}

}
