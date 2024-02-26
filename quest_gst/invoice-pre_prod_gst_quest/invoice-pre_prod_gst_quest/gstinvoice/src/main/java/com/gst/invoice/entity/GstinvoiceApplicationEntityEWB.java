package com.gst.invoice.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class GstinvoiceApplicationEntityEWB {

	@JsonProperty(value = "Irn")
	private String Irn = null;

	@JsonProperty(value = "TransId")
	private String TransId;
	@JsonProperty(value = "TransName")
	private String TransName = null;

	@JsonProperty(value = "TransMode")
	private String TransMode = null;
	@JsonProperty(value = "Distance")
	private BigDecimal Distance;

	@JsonProperty(value = "TransDocNo")
	private String TransDocNo = null;

	@JsonProperty(value = "TransDocDt")
	private String TransDocDt;

	@JsonProperty(value = "VehNo")
	private String VehNo;

	@JsonProperty(value = "VehType")
	private String VehType;

	private GstInvoiceShipmentDetailsEWB ExpShipDtls;

	private GstInvoiceDistributerEWB DispDtls;

}
