package com.gst.invoice.service;

import org.springframework.beans.factory.annotation.Value;

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
public class GstInvoiceIrnEWB {

	@Value("${apibody.CnlRsn}")
	private String CnlRsn;
	
	@Value("${apibody.CnlRem}")
	private String CnlRem;
	
	private String Irn;
}