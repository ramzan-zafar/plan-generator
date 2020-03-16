package com.lendico.plangenerator.api.model;

import java.time.ZonedDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Borrower Plan Response")
public class BorrowerPlanResponseModel {

	@ApiModelProperty(name="Payment Amount)")
	private Double borrowerPaymentAmount;
	
	@ApiModelProperty(name="Date")
	private ZonedDateTime date;
	
	@ApiModelProperty(name="Initial Outstanding Principal)")
	private Double initialOutstandingPrincipal;
	
	@ApiModelProperty(name="Interest")
	private Double interest;
	
	@ApiModelProperty(name="Principal")
	private Double principal;
	
	@ApiModelProperty(name="Remaining Outstanding Principal")
	private Double remainingOutstandingPrincipal;
		
	
}
