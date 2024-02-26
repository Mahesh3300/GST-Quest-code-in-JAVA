package com.gst.invoice.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class GstInvoiceValidationDetails implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4264810636258785478L;
	@JsonProperty(value = "TotAssVal")
	private BigDecimal TotAssVal;
	@JsonProperty(value = "TotCgstVal")
	private BigDecimal TotCgstVal;
	@JsonProperty(value = "TotSgstVal")
	private BigDecimal TotSgstVal;
	@JsonProperty(value = "TotIgstVal")
	private BigDecimal TotIgstVal;
	@JsonProperty(value = "TotCesVal")
	private BigDecimal TotCesVal;
	@JsonProperty(value = "TotStCesVal")
	private BigDecimal TotStCesVal;
	@JsonProperty(value = "TotDiscount")
	private BigDecimal TotDiscount

	;
	@JsonProperty(value = "TotOthChrg")
	private BigDecimal TotOthChrg

	;
	@JsonProperty(value = "TotRndOffAmt")
	private BigDecimal TotRndOffAmt

	;
	@JsonProperty(value = "TotInvval")
	private BigDecimal TotInvval

	;
	@JsonProperty(value = "TotInvValFc")

	private BigDecimal TotInvValFc

	;


}
