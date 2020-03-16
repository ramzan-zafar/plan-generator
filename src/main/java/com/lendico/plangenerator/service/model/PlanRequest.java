package com.lendico.plangenerator.service.model;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanRequest {

	private Double loanAmount;
	private Double nominalRate;
	private Integer duration;
	private ZonedDateTime startDate;
}
