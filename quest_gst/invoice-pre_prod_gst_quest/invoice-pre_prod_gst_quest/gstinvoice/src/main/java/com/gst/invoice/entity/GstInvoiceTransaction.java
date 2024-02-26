package com.gst.invoice.entity;

import javax.persistence.Column;

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
public class GstInvoiceTransaction {
	@Column(name = "")
	private String TaxSch;
	private String SupTyp;
	private String RegRev;
	private String EcmGstin;
	private String IgstOnIntra;
}
