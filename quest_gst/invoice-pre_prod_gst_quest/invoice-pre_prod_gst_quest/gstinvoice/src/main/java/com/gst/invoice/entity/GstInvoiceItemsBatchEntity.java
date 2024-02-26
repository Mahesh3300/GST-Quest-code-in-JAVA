package com.gst.invoice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class GstInvoiceItemsBatchEntity {

	

	@JsonProperty(value = "BchNm")
	private String BchNm  ;  ;
	@JsonProperty(value = "BchExpDt")
	private String BchExpDt  ;
	@JsonProperty(value = "BchWrDt")
	private String BchWrDt  ;
	
	
	
	
	
	}
