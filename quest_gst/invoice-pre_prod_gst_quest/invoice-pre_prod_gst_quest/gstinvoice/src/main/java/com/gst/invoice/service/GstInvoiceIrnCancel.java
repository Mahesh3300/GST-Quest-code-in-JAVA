package com.gst.invoice.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
@ConfigurationProperties
@Component
public class GstInvoiceIrnCancel {

	@JsonProperty(value = "CnlRsn")
	private String CnlRsn;
	
	@JsonProperty(value = "CnlRem")
	private String CnlRem;
	
	@JsonProperty(value = "Irn")
	private String Irn;
	
	@JsonProperty(value = "CancelDate")
	private String CancelDate;
	private String ErrorRecordsStatus;
	private Object ErrorDetails;
}