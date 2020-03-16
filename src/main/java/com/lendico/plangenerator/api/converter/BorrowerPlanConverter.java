package com.lendico.plangenerator.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lendico.plangenerator.api.model.BorrowerPlanResponseModel;
import com.lendico.plangenerator.service.model.BorrowerPlanDto;

@Component
public class BorrowerPlanConverter implements Converter<BorrowerPlanDto, BorrowerPlanResponseModel> {

	@Override
	public BorrowerPlanResponseModel convert(BorrowerPlanDto borrowerPlanDto) {

		
		return BorrowerPlanResponseModel.builder().borrowerPaymentAmount(borrowerPlanDto.getBorrowerPaymentAmount())
				.date(borrowerPlanDto.getDate())
				.initialOutstandingPrincipal(borrowerPlanDto.getInitialOutstandingPrincipal())
				.interest(borrowerPlanDto.getIntrest()).principal(borrowerPlanDto.getPrincipal())
				.remainingOutstandingPrincipal(borrowerPlanDto.getRemainingOutstandingPrincipal())
				.build();
	}

}
