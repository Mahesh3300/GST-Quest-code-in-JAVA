package com.gst.invoice.entity;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
@Data
public class GstInvoiceOutPutResponseJsonEWBResponse {

	

	private String EwbNo;
	private String EwbDt;
	private String EwbValidTill;
	private String Status;
    private Object InfoDtls;
    private Object ErrorDetails;

}


