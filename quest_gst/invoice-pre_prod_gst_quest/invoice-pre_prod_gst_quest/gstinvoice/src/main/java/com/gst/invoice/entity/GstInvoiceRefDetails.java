package com.gst.invoice.entity;

import java.util.List;

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
public class GstInvoiceRefDetails {
	private String RefInvRm

	;

	private DocPerdDtls DocPerdDtls;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Immutable
	@EqualsAndHashCode
	public class DocPerdDtls {
		private String InvStDt;
		private String InvEndDt;
	}

	private List<PrecDocDtls> PrecDocDtls;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Immutable
	@EqualsAndHashCode
	public class PrecDocDtls {
		private String InvNo

		;
		private String InvDt;

		private String OthRefNo;

	}

	private List<ContrDtls> ContrDtls;

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Immutable
	@EqualsAndHashCode
	public class ContrDtls {
		private String RecAdvRefr;
		private String RecAdvDt;
		private String TendRefr;
		private String ContrRefr;
		private String ExtRefr;
		private String ProjRefr;
		private String PORefr;
		private String PORefDt;
	}
}
