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
public class GstInvoiceBuyer {
	private String BGstin;
	private String BLglNm

	;
	private String BTrdNm

	;
	private String BPos

	;
	private String BAddr1

	;
	private String BAddr2

	;
	private String BLoc

	;
	private String BStcd

	;
	private BigDecimal BPin

	;
	private String BPh

	;
	private String BEm

	;

}
