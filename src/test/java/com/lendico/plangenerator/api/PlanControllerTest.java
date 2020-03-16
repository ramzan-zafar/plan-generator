package com.lendico.plangenerator.api;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.lendico.plangenerator.api.handler.PlanRequestHandler;
import com.lendico.plangenerator.api.model.BorrowerPlanResponseModel;
import com.lendico.plangenerator.api.model.PlanRequestModel;

@RunWith(MockitoJUnitRunner.class)
public class PlanControllerTest {

	@Mock
	private PlanRequestModel planRequestModel;

	@Mock
	private PlanRequestHandler planRequestHanlder;

	@InjectMocks
	private PlanController underTest;

	@Test
	public void testGeneratePlan() {

		Mockito.when(planRequestHanlder.handlerPlanRequest(planRequestModel))
				.thenReturn(Collections.singletonList(BorrowerPlanResponseModel.builder().build()));

		List<BorrowerPlanResponseModel> result = underTest.generatePlan(planRequestModel);

		Mockito.verify(planRequestHanlder).handlerPlanRequest(planRequestModel);
		assertEquals(1, result.size());
	}

}
