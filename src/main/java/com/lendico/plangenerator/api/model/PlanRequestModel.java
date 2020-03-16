package com.lendico.plangenerator.api.model;

import java.time.ZonedDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.validation.annotation.Validated;

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
@ApiModel(description = "Plan Request")
@Validated
public class PlanRequestModel {

	@ApiModelProperty(name = "Loan Amount (Principal Amount)")
	@NotNull(message = "Loan amount cannot be null")
	@Positive(message ="Loan amount shoule be a positive value")
	private Double loanAmount;

	@ApiModelProperty(name = "Nominal Rate (Annual Intrest Rate")
	@NotNull(message = "nominalRate(Annual Intrest rate) cannot be null")
	@Positive(message ="nominalRate shoule be a positive value")
	private Double nominalRate;

	@ApiModelProperty(name = "Duration (Number of installments in the month)")
	@NotNull(message = "Duration cannot be null")
	@Min(1)
	private Integer duration;

	@NotNull
	@ApiModelProperty(name = "StartDate (Date of Disbursement/Payout)")
	@NotNull(message = "Start date cannot be null")
	private ZonedDateTime startDate;

}
