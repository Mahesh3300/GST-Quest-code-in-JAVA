package com.gst.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@EqualsAndHashCode
@Entity
@Table(name = "RA_CUSTOMER_TRX_ALL")
public class GstInvoiceRACustomerTrEntity {

	/**
	 * 
	 */
	@Column(name = "global_attribute11")
	private String attribute11;
	@Column(name = "global_attribute12")
	private String attribute12;
	@Column(name = "global_attribute13")
	private String attribute13;
	@Column(name = "global_attribute14")
	private String attribute14;
	@Column(name = "global_attribute15")
	private String attribute15;
	@Id
	private String trx_number;
	private String org_id;

	
}