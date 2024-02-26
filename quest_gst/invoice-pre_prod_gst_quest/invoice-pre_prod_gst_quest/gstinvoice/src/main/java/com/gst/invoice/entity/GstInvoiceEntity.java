package com.gst.invoice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gst.invoice.constant.GstInvoiceEntityConstant;

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
@Table(name = GstInvoiceEntityConstant.XX_GST_HEADER_TABLE, schema = GstInvoiceEntityConstant.XX_GST_SCHEMA)
public class GstInvoiceEntity {
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.DOCDTLS_TYP)
	private String DOCDTLS_TYP;
	@JsonIgnore
	@Id
	@Column(name = GstInvoiceEntityConstant.dOCDTLS)
	private String dOCDTLS;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.DOCDTLS_DT)
	private Date DOCDTLS_DT;
	@Transient
	@JsonIgnore
	private String DocDtls = "DocDtls";
	@Transient
	@JsonIgnore
	private String TranDtls = "TranDtls";
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.TRANDTLS_TAX_SCH)
	private String TRANDTLS_TAX_SCH;

	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.TRANDTLS_SUP_TYP)
	private String TRANDTLS_SUP_TYP;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.TRANDTLS_REG_REV)
	private String TRANDTLS_REG_REV;
	@JsonIgnore
	@Transient
	//@Column(name = "ECOM_GSTN")
	private String TRANDTLS_ECM_GSTIN;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.TRANDTLS_IGST_ON_INTRA)
	private String TRANDTLS_IGST_ON_INTRA;

	@Transient
	@JsonIgnore
	private String SellerDtls = "SellerDtls";

	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_GSTIN)
	private String SELLERDTLS_GSTIN;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_LGLNM,insertable = false, updatable = false)
	private String SELLERDTLS_LGLNM;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_TRDNM,insertable = false, updatable = false)
	private String SELLERDTLS_TRDNM

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_ADDR1)
	private String SELLERDTLS_ADDR1

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_ADDR2)
	private String SELLERDTLS_ADDR2

	;
	
	
	
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_LOC)
	private String SELLERDTLS_LOC

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_PIN)
	private String SELLERDTLS_PIN

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.SELLERDTLS_STCD)
	private String SELLERDTLS_STCD

	;
	@JsonIgnore
	@Transient
	//@Column(name = GstInvoiceEntityConstant.SELLER_PHNO)
	private String SELLERDTLS_PH;
	@JsonIgnore
	@Transient
	//@Column(name = GstInvoiceEntityConstant.SELLER_EMAIL)
	private String SELLERDTLS_EM;
	@Transient
	@JsonIgnore
	private String BuyerDtls = "BuyerDtls";
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_GSTIN)
	private String BUYERDTLS_GSTIN;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_LGLNM)
	private String BUYERDTLS_LGLNM

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_TRDNM)
	private String BUYERDTLS_TRDNM

	;
	@JsonIgnore
    @Column(name = GstInvoiceEntityConstant.BUYERDTLS_POS)
	private String BUYERDTLS_POS

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_ADDR1)
	private String BUYERDTLS_ADDR1

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_ADDR2)
	private String BUYERDTLS_ADDR2

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_LOC)
	private String BUYERDTLS_LOC

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_STCD)
	private String BUYERDTLS_STCD

	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.BUYERDTLS_PIN)
	private String BUYERDTLS_PIN

	;
	@JsonIgnore
	@Transient
	//@Column(name = GstInvoiceEntityConstant.BUYER_PHNO)
	private String BUYERDTLS_PH

	;
	@JsonIgnore
	@Transient
	//@Column(name = GstInvoiceEntityConstant.BUYER_EMAIL)
	private String BUYERDTLS_EM

	;
	@Transient
	@JsonIgnore
	private String DispDtls = "DispDtls";
	@JsonProperty(value = "BEm")
	@Column(name = GstInvoiceEntityConstant.DISPDTLS_NM)
	private String DISPDTLS_NM

	;
	@JsonProperty(value = "DisAddr1")
	@Column(name = GstInvoiceEntityConstant.DISPDTLS_ADDR1)
	private String DISPDTLS_ADDR1

	;
	@JsonProperty(value = "DisAddr2")
	@Transient
	@Column(name = GstInvoiceEntityConstant.DISPDTLS_ADDR2)
	private String DISPDTLS_ADDR2

	;
	@JsonProperty(value = "DisLoc")
	@Column(name = GstInvoiceEntityConstant.DISPDTLS_LOC)
	private String DISPDTLS_LOC

	;
	@JsonProperty(value = "DisPin")
	@Column(name = GstInvoiceEntityConstant.DISPDTLS_PIN)
	private String DISPDTLS_PIN

	;
	@JsonProperty(value = "DisStcd")
	@Column(name = GstInvoiceEntityConstant.DISPDTLS_STCD)
	private String DISPDTLS_STCD

	;

	@Transient
	@JsonIgnore
	private String ShipDtls = "ShipDtls";

	@JsonProperty(value = "ShipGstin")
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_GSTIN)
	private String SHIPDTLS_GSTIN;

	@JsonProperty(value = "ShipLglNm")
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_LGLNM)
	private String SHIPDTLS_LGLNM

	;
	@JsonProperty(value = "ShipTrdNm")
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_TRDNM)
	private String SHIPDTLS_TRDNM

	;
	@JsonProperty(value = "ShipAddr1")
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_ADDR1)
	private String SHIPDTLS_ADDR1

	;
	@JsonProperty(value = "ShipAddr2")
	@Transient
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_ADDR2)
	private String SHIPDTLS_ADDR2

	;
	@JsonProperty(value = "ShipLoc")
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_LOC)
	private String SHIPDTLS_LOC

	;
	@JsonProperty(value = "ShipPin")
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_PIN)
	private String SHIPDTLS_PIN

	;
	@JsonProperty(value = "ShipStcd")
	@Column(name = GstInvoiceEntityConstant.SHIPDTLS_STCD)
	private String SHIPDTLS_STCD

	;
	@Transient
	@JsonIgnore
	private String ValDtls = "ValDtls";

	@JsonProperty(value = "TotAssVal")
	@Column(name = GstInvoiceEntityConstant.VALDTLS_ASSVAL)
	private String VALDTLS_ASSVAL;
	@JsonProperty(value = "TotCgstVal")
	@Column(name = GstInvoiceEntityConstant.TotCgstVal)
	private String VALDTLS_CGSTVAL;
	@JsonProperty(value = "TotSgstVal")
	@Column(name = GstInvoiceEntityConstant.TotSgstVal)
	private String VALDTLS_SGSTVAL;

	@Column(name = GstInvoiceEntityConstant.TotIgstVal)
	@JsonProperty(value = "TotIgstVal")
	private String VALDTLS_IGSTVAL;
	@Column(name = GstInvoiceEntityConstant.TotCesVal)
	@JsonProperty(value = "TotCesVal")
	private String VALDTLS_CESVAL;
	@Column(name = GstInvoiceEntityConstant.TotStCesVal)
	@JsonProperty(value = "TotStCesVal")
	private String VALDTLS_STCESVAL;
	@Column(name = GstInvoiceEntityConstant.TotDiscount)
	@JsonProperty(value = "TotDiscount")
	private String VALDTLS_DISCOUNT

	;
	@Column(name = GstInvoiceEntityConstant.TotOthChrg)
	@JsonProperty(value = "TotOthChrg")
	private String VALDTLS_OTHCHRG

	;
	@Column(name = GstInvoiceEntityConstant.TotRndOffAmt)
	@JsonProperty(value = "TotRndOffAmt")
	private String VALDTLE_RNDOFFAMT

	;
	@JsonProperty(value = "TotInvval")
	@Column(name = GstInvoiceEntityConstant.TotInvval)
	private String VALDTLS_TOTINVVAL

	;
	@Column(name = GstInvoiceEntityConstant.TotInvValFc)
	@JsonProperty(value = "TotInvValFc")
	private String VALDTLS_TOTINVVALFC

	;
	@Transient
	@JsonIgnore
	private String PayDtls = "PayDtls";
	@Transient
	@JsonProperty(value = "PayNm")
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_NM)
	private String PAYDTLS_NM

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_MODE)
	@JsonProperty(value = "PayMode")
	private String PAYDTLS_MODE

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_FININSBR)
	@JsonProperty(value = "PayFinInsBr")
	private String PAYDTLS_FININSBR

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_PAYTERM)
	@JsonProperty(value = "PayTerm")
	private String PAYDTLS_PAYTERM

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_PAYINSTR)
	@JsonProperty(value = "PayInstr")
	private String PAYDTLS_PAYINSTR

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_CRTRN)
	@JsonProperty(value = "PayCrtrn")
	private String PAYDTLS_CRTRN

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_DIRDR)
	@JsonProperty(value = "PayDirDr")
	private String PAYDTLS_DIRDR

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_CRDAY)
	@JsonProperty(value = "PayCrDay")
	private String PAYDTLS_CRDAY

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_PAIDAMT)
	@JsonProperty(value = "PayPaidAmt")
	private String PAYDTLS_PAIDAMT

	;
	@Transient
	@JsonProperty(value = "PayPaymtDue")
	private String PAYDTLS_PAYMTDUE

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PAYDTLS_ACCDET)
	@JsonProperty(value = "PayAcctDet")
	private String PAYDTLS_ACCDET

	;
	@Transient
	@JsonIgnore
	private String RefDtls = "RefDtls";
	@Column(name = GstInvoiceEntityConstant.REF_INV_REMARK)
	@Transient
	@JsonProperty(value = "RefInvRm")
	private String REFDTLS_INVRM

	;
	@Transient
	@JsonProperty(value = "InvStDt")
	@Column(name = "REF_INV_START_DATE")
	private String REFDTLS_INVSTDT;
	@Transient
	@JsonProperty(value = "InvEndDt")
	@Column(name = "REF_INV_END_DATE")
	private String REFDTLS_INVENDDT;
	@Transient
	@JsonProperty(value = "InvNo")
	@Column(name = "PRE_INV_NO")
	private String REFDTLS_PRECDOCDTLS_INVNO

	;
	@JsonProperty(value = "InvDt")
	@Column(name = "PRE_INV_DATE")
	@Transient
	private String REFDTLS_PRECDOCDTLS_INVDT;
	@JsonProperty(value = "OthRefNo")
	@Column(name = "OTHER_REF_NO")
	@Transient
	private String REFDTLS_PRECDOCDTLS_OTHREFNO;
	@JsonProperty(value = "RecAdvRefr")
	@Column(name = "REC_ADV_REF")
	@Transient
	private String REFDTLS_CONTRDTLS_RECADVREFR;

	@JsonProperty(value = "RecAdvDt")
	@Column(name = "REC_ADV_DATE")
	@Transient
	private String REFDTLS_CONTRACT_RECADVDT;
	@JsonProperty(value = "TendRefr")
	@Transient
	@Column(name = "TEND_REF_NO")
	private String REFDTLS_CONTRDTLS_TENDREFR;
	@JsonProperty(value = "ContrRefr")
	@Transient
	@Column(name = "CONTRACT_REF")
	private String REFDTLS_CONTRDTLS_CONTRREFR;
	@JsonProperty(value = "ExtRefr")
	@Transient
	@Column(name = "EXTERNAL_REF")
	private String REFDTLS_CONTRDTLS_EXTREFR;
	@JsonProperty(value = "ProjRefr")
	@Transient
	@Column(name = "PROJECT_REF")
	private String REFDTLS__CONTRDTLS_PROJREFR;
	@JsonProperty(value = "PORefr")
@Transient
	@Column(name = "PO_REF")
	private String REFDTLS_CONTRDTLS_POREFR

	;
	@JsonProperty(value = "PORefDt")
	@Column(name = "PO_REF_DATE")
	@Transient
	private String REFDTLS_CONTRACT_POREFDT;

	@Transient
	@JsonIgnore
	private String AddlDocDtls = "AddlDocDtls";

	@JsonProperty(value = "Url")
	@Column(name = "ADD_DOC_URL")
	@Transient
	private String ADDLDTLS_ADDLDOCUMENT_URL

	;
	@JsonProperty(value = "Docs")
	@Column(name = "ADD_DOC")
	@Transient
	private String ADDLDTLS_ADDLDOCUMENT_DOCS

	;
	@JsonProperty(value = "InfoDtls")
	@Column(name = "ADD_INFO_DTLS")
	@Transient
	private String ADDLDTLS_ADDLDOCUMENT_INFO

	;

	@Transient
	@JsonIgnore
	private String ExpDtls = "ExpDtls";
	@JsonProperty(value = "ExpShipBNo")
	@Column(name = "EXP_SHIP_BILL_NO")
	@Transient
	private String EXPDTLS_SHIPBNO;
	@JsonProperty(value = "ExpShipBDt")
	@Column(name = "EXP_SHIP_BILL_DATE")
	@Transient
	private String EXPDTLS_SHIPBDT;
	@JsonProperty(value = "ExpPort")
	@Column(name = "EXPORT_PORT_CODE")
	@Transient
	private String EXPDTLS_PORT;
	@JsonProperty(value = "ExpRefClm")
	@Column(name = "EXPORT_REF_CLM")
	@Transient
	private String EXPDTLS_REFCLM;
	@JsonProperty(value = "ExpForCur")
	@Column(name = "EXPORT_CURRENCY")
	@Transient
	private String EXPDTLS_FORCUR

	;
	@JsonProperty(value = "ExpCntCode")
	@Column(name = "EXPORT_COUNTRY")
	@Transient
	private String EXPDTLS_CNTCODE

	;
	@JsonProperty(value = "ExpDuty")
	@Column(name = "EXPORT_DUTY")
	@Transient
	private String EXPDTLS_EXPDUTY;

	// need to check ballapur
	
	@Transient
	@JsonProperty(value = "EwbNo")
	// @Column(name = "EWAYBILL_NO")
	private String EWB_NO;
	@JsonProperty(value = "EwbDt")
	// @Column(name = "VALID_FROM")
	@Transient
	private String EWB_DATE;
	@JsonProperty(value = "EwbValidTill")
	//@Column(name = "VALID_UPTO")
	@Transient
	private String EWB_VALID_TILL;
	// need to check ballapur

	//@Column(name = "EWB_STATUS")
	@Transient
	private String eWBSTATUS;

	

	

	

	//TRANSDISTANCE
	;
	@Transient
	@JsonIgnore
	private String EwbDtls = "EwbDtls";

	@JsonProperty(value = "TransId")
	@Column(name = "TRANS_ID")
	@Transient
	private String EWBDTLS_TRANSID;
	@JsonProperty(value = "TransName")
	@Column(name = "TRANS_NAME")
	@Transient
	private String EWBDTLS_TRANSNAME

	;
	@JsonProperty(value = "TransMode")
	@Column(name = "TRANS_MODE")
	@Transient
	private String EWBDTLS_TRANSMODE;
	@JsonProperty(value = "Distance")
	@Column(name = "TRANS_DISTANCE")
	@Transient
	private String EWBDTLS_DISTANCE

	;
	@JsonProperty(value = "TransDocNo ")
	@Column(name = "TRANS_DOC_NO")
	@Transient
	private String EWBDTLS_TRANSDOCNO;
	@JsonProperty(value = "TransDocDt")
	@Column(name = "TRANS_DOC_DATE")
	@Transient
	private String EWBDTLS_TRANSDOCDT;
	@JsonProperty(value = "VehNo")
	@Column(name = "VEHICLE_NO")
	@Transient
	private String EWBDTLS_VEHNO;
	@JsonProperty(value = "VehType")
	@Column(name = "VEHICLE_TYPE")
	@Transient
	private String EWBDTLS_VEHTYPE;
	@JsonProperty(value = "Irn")
	@Column(name = GstInvoiceEntityConstant.IRN_NUMBER)
	private String IRN_NUMBER

	;
	@JsonIgnore
	//@Transient
	@Column(name = GstInvoiceEntityConstant.QR_CODE)
	private String QR_CODE;
	@JsonIgnore
	@Column(name = "ACK_NO")
	private String ACKNO

	;

	private String ACK_DATE;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.iRNSTATUS)
	private String iRNSTATUS;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.ERROR_MESSAGE)
	private String ERROR_MESSAGE;
	@JsonIgnore
	@Column(name = "CREATION_DATE")
	private Date CREATION_DATE;
	@JsonIgnore
	@Column(name = "CREATED_BY")
	private String CREATED_BY

	;
	@JsonIgnore
	@Column(name = "LAST_UPDATE_DATE")
	private Date LAST_UPDATED_DATE;
	@JsonIgnore
	@Column(name = "LAST_UPDATED_BY")
	private String LAST_UPDATED_BY

	;
	@Transient
	@JsonIgnore
	private String QR_IMAGE_PATH
	;
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.QR_IMAGE_FILE_NAME)
	private String QR_IMAGE_FILE_NAME;
	
	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.TRX_ID)
	private String TRX_ID;
	
	@JsonIgnore
	@Column(name = "IRP_REQUEST", columnDefinition = "BLOB")
	private byte[] IRP_REQUEST;
	@JsonIgnore
	@Column(name = "IRP_RESPONSE", columnDefinition = "BLOB")
	private byte[] IRP_RESPONSIE;
	
	
	@Column(name = GstInvoiceEntityConstant.CANCEL_IRN_STATUS)
	private String cANCELIRNSTATUS;
	
	@JsonIgnore
	@Column(name=GstInvoiceEntityConstant.CANCEL_DATE)
	private Date CANCEL_DATE;
	
	@JsonIgnore
	@Column(name=GstInvoiceEntityConstant.CANCEL_CODE)
	private String CANCEL_CODE;
	@JsonIgnore
	@Column(name=GstInvoiceEntityConstant.CANCEL_REASON)
	private String CANCEL_REASON;

	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.CANCEL_IRN_REQUEST, columnDefinition = "BLOB")
	private byte[] CANCEL_IRN_REQUEST;

	@JsonIgnore
	@Column(name = GstInvoiceEntityConstant.CANCEL_IRN_RESPONSE, columnDefinition = "BLOB")
	private byte[] CANCEL_IRN_RESPONSE;

	@JsonIgnore
	@Transient
	@Column(name = "EWB_REQUEST", columnDefinition = "BLOB")
	private byte[] EWB_REQUEST;

	@JsonIgnore
	@Transient
	@Column(name = "EWB_RESPONSE", columnDefinition = "BLOB")
	private byte[] EWB_RESPONSE;

	@JsonIgnore
	@Transient
	private String organizationId;

}
