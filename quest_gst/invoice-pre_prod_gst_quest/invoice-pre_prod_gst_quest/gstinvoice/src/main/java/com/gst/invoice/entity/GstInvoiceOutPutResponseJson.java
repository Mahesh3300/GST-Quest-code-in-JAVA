package com.gst.invoice.entity;

import java.util.List;

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
public class GstInvoiceOutPutResponseJson {

	private GstInvoiceOutPutQrcodeResponse QRCode;
	private Object ErrorDetails;
	private Object ErrorRecords;
	private String Status;
	private String AckNo;
	private String AckDt;
	private String Irn;
	private String DocNo;
	private String data;
	private String SignedInvoice;

	private String SignedQRCode;
	private String ErrorRecordsStatus;

	private String EwbNo;
	private String EwbDt;
	private String EwbValidTill;
	
	private List<GstInvoiceOutPutResponseJsonInfo> InfoDtls;

}
