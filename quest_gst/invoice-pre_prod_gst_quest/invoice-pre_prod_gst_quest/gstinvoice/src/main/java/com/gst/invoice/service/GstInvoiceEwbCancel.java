package com.gst.invoice.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
public class GstInvoiceEwbCancel {

	
	
	private String  ewbNo;

	private String  cancelRsnCode;

	private String  cancelRmrk;
	
	
	private String ewayBillNo;
	
	private String cancelDate;
	
	private String Status;
	private String ErrorRecordsStatus;
	private Object ErrorDetails;
	
	

}