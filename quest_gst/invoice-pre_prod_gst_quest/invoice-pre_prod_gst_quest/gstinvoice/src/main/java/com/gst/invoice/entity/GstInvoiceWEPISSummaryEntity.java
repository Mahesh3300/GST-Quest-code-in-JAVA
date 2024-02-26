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
@Table(name = "WEPIS_GST_INV_SUMMARY_DETAILS")
public class GstInvoiceWEPISSummaryEntity {

	/**
	 * 
	 */
	private String ATTRIBUTE1;
	private String ATTRIBUTE2;
	private String ATTRIBUTE3;
	private String ATTRIBUTE4;
	private String ATTRIBUTE5;
	@Id
	@Column(name ="CUS_SEQ")
	private String CUS_SEQ;


	
}