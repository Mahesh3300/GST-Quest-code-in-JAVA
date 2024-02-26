package com.gst.invoice.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(value=Include.ALWAYS)
public class GstInvoicePaymenttDetails {
	private String PayNm

	;
	private String PayMode

	;
	private String PayFinInsBr

	;
	private String PayTerm

	;
	private String PayInstr

	;
	private String PayCrtrn

	;
	@JsonInclude(value=Include.ALWAYS)
	private String PayDirDr =null;

	;
	private BigDecimal PayCrDay

	;
	private BigDecimal PayPaidAmt

	;
	private BigDecimal PayPaymtDue

	;
	private String PayAcctDet

	;
}
