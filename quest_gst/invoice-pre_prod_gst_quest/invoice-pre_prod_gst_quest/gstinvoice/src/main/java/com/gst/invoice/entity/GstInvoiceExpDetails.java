package com.gst.invoice.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@EqualsAndHashCode
public class GstInvoiceExpDetails {

	private String ExpShipBNo;
	private String ExpShipBDt;
	private String ExpPort;
	private String ExpRefClm;
	private String ExpForCur

	;
	private String ExpCntCode

	;
	private BigDecimal ExpDuty;



	
}