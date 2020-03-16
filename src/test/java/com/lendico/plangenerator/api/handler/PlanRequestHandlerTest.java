package com.lendico.plangenerator.api.handler;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.lendico.plangenerator.api.converter.BorrowerPlanConverter;
import com.lendico.plangenerator.api.converter.PlanRequestConverter;
import com.lendico.plangenerator.api.model.BorrowerPlanResponseModel;
import com.lendico.plangenerator.api.model.PlanRequestModel;
import com.lendico.plangenerator.service.PaymentPlanService;
import com.lendico.plangenerator.service.model.BorrowerPlanDto;
import com.lendico.plangenerator.service.model.PlanRequest;

@RunWith(MockitoJUnitRunner.class)
public class PlanRequestHandlerTest {

	@Mock
	private PlanRequestModel planRequestModel;

	@Mock
	private PlanRequest planRequest;

	@Mock
	private PlanRequestConverter planRequestConverter;

	@Mock
	private PaymentPlanService paymentPlanService;

	@Mock
	private BorrowerPlanConverter borrowerPlanConverter;

	@InjectMocks
	private PlanRequestHandler underTest;

	@Test
	public void testHandlePlanRequestShouldResultListOfBorrowerPlan() {

		List<BorrowerPlanDto> mockBorrowerPlanList = createMockBorrowerPlanDto();
		List<BorrowerPlanResponseModel> mockBorrowerRessponseList = createMockBorrowerPlanResponseModel();

		Mockito.when(planRequestConverter.convert(planRequestModel)).thenReturn(planRequest);
		Mockito.when(paymentPlanService.generatePaymentPlan(planRequest)).thenReturn(mockBorrowerPlanList);
		Mockito.when(borrowerPlanConverter.convert(mockBorrowerPlanList.get(0)))
				.thenReturn(mockBorrowerRessponseList.get(0));

		List<BorrowerPlanResponseModel> result = underTest.handlerPlanRequest(planRequestModel);

		Mockito.verify(planRequestConverter).convert(planRequestModel);
		Mockito.verify(paymentPlanService).generatePaymentPlan(planRequest);
		Mockito.verify(borrowerPlanConverter, Mockito.times(mockBorrowerPlanList.size()))
				.convert(mockBorrowerPlanList.get(0));

		assertEquals(1, result.size());

	}

	private List<BorrowerPlanDto> createMockBorrowerPlanDto() {
		return Collections.singletonList(BorrowerPlanDto.builder().build());
	}

	private List<BorrowerPlanResponseModel> createMockBorrowerPlanResponseModel() {
		return Collections.singletonList(BorrowerPlanResponseModel.builder().build());
	}

}
