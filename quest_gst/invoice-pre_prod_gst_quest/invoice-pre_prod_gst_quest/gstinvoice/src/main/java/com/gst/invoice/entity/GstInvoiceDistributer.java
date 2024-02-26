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
public class GstInvoiceDistributer {
	private String DisTrdNm

	;
	private String DisAddr1

	;
	private String DisAddr2

	;
	private String DisLoc

	;
	private BigDecimal DisPin

	;
	private String DisStcd

	;
}
