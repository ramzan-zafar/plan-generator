package com.lendico.plangenerator.api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lendico.plangenerator.api.model.PlanRequestModel;
import com.lendico.plangenerator.service.model.PlanRequest;

@Component
public class PlanRequestConverter implements Converter<PlanRequestModel, PlanRequest> {

	@Override
	public PlanRequest convert(PlanRequestModel planRequestModel) {

		return PlanRequest.builder().loanAmount(planRequestModel.getLoanAmount())
				.nominalRate(planRequestModel.getNominalRate()/100).startDate(planRequestModel.getStartDate())
				.duration(planRequestModel.getDuration()).build();
	}

}
