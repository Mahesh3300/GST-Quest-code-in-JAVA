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
public class GstInvoiceSeller {
	private String SGstin;
	private String SLglNm;
	private String STrdNm

	;
	private String SAddr1

	;
	private String SAddr2

	;
	private String SLoc

	;
	private BigDecimal SPin

	;
	private String SStcd

	;
	private String SPh;
	private String SEm;

}
