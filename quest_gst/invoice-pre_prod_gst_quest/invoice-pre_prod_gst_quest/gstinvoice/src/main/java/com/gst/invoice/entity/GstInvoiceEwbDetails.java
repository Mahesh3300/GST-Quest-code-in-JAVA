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
public class GstInvoiceEwbDetails {

	private String TransId;
	private String TransName

	;
	private String TransMode;
	private BigDecimal Distance

	;
	private String TransDocNo;
	private String TransDocDt;
	private String VehNo;
	private String VehType;

}
