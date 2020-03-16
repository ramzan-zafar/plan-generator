package com.lendico.plangenerator.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.plangenerator.api.handler.PlanRequestHandler;
import com.lendico.plangenerator.api.model.BorrowerPlanResponseModel;
import com.lendico.plangenerator.api.model.PlanRequestModel;

@RestController
public class PlanController {

	@Autowired
	private PlanRequestHandler planRequestHanlder;

	@PostMapping(value= "/generate-plan",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE} )
	public List<BorrowerPlanResponseModel> generatePlan(@RequestBody @Valid PlanRequestModel planRequest) {

		return planRequestHanlder.handlerPlanRequest(planRequest);
	}

}
