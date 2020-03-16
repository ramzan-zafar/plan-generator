package com.lendico.plangenerator.service.model;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorrowerPlanDto {

	private Double borrowerPaymentAmount;	
	private ZonedDateTime date;
	private Double initialOutstandingPrincipal;
	private Double intrest;
	private Double principal;
	private Double remainingOutstandingPrincipal;
		
	
}
