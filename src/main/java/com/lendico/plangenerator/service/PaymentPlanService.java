package com.lendico.plangenerator.service;

import java.util.List;

import com.lendico.plangenerator.service.model.BorrowerPlanDto;
import com.lendico.plangenerator.service.model.PlanRequest;

public interface PaymentPlanService {

	List<BorrowerPlanDto> generatePaymentPlan(PlanRequest planRequest);
}
