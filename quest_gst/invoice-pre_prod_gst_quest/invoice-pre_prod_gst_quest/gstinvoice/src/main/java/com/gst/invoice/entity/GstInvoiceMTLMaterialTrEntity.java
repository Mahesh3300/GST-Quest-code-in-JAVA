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
@Table(name = "MTL_MATERIAL_TRANSACTIONS")
public class GstInvoiceMTLMaterialTrEntity {

	/**
	 * 
	 */
	private String attribute11;
	private String attribute12;
	private String attribute13;
	private String attribute14;
	private String attribute15;
	@Id
	@Column(name ="shipment_number")
	private String trx_number;
	@Column(name ="organization_id")
	private String org_id;

	
}