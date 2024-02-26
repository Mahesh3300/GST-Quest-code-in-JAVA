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
public class GstInvoiceShipmentDetails {
	private String ShipGstin;
	private String ShipLglNm
	;
	private String ShipTrdNm
	;
	private String ShipAddr1

	;
	private String ShipAddr2

	;
	private String ShipLoc

	;
	private BigDecimal ShipPin

	;
	private String ShipStcd

	;
}
