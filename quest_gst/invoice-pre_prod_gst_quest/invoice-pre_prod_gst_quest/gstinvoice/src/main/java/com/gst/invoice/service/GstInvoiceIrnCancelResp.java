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
public class GstInvoiceIrnCancelResp {
	@JsonProperty(value = "OutputResponse")
	private GstInvoiceIrnCancel OutputResponse;
	
}