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
public class GstInvoiceOutPutQrcodeResponse {

	
	
	
	private String SellerGstin;
	private String BuyerGstin;
	private String DocNo;
	private String DocTyp;
	private String     DocDt;
	private String TotInvVal;
	private String ItemCnt;
	private String MainHsnCode;
	private String Irn;
	
	private String AckNo;
	private String AckDt;
	
	
	
	
}
