package com.lendico.plangenerator.api.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.lendico.plangenerator.api.converter.BorrowerPlanConverter;
import com.lendico.plangenerator.api.converter.PlanRequestConverter;
import com.lendico.plangenerator.api.model.BorrowerPlanResponseModel;
import com.lendico.plangenerator.api.model.PlanRequestModel;
import com.lendico.plangenerator.service.PaymentPlanService;
import com.lendico.plangenerator.service.model.BorrowerPlanDto;
import com.lendico.plangenerator.service.model.PlanRequest;

@Component
public class PlanRequestHandler {

	private PlanRequestConverter planRequestConverter;
	private PaymentPlanService paymentPlanService;
	private BorrowerPlanConverter borrowerPlanConverter;

	public PlanRequestHandler(PlanRequestConverter planRequestConverter, PaymentPlanService paymentPlanService,
			BorrowerPlanConverter borrowerPlanConverter) {
		this.planRequestConverter = planRequestConverter;
		this.paymentPlanService = paymentPlanService;
		this.borrowerPlanConverter = borrowerPlanConverter;
	}

	public List<BorrowerPlanResponseModel> handlerPlanRequest(PlanRequestModel planRequestModel) {

		PlanRequest planRequest = planRequestConverter.convert(planRequestModel);

		List<BorrowerPlanDto> plans = paymentPlanService.generatePaymentPlan(planRequest);

		return plans.stream().map(borrowerPlanConverter::convert).collect(Collectors.toList());

	}

}
