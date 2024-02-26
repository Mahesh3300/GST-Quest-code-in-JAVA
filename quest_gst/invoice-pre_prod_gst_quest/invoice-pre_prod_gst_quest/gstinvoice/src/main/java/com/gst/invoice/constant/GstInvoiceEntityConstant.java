package com.gst.invoice.constant;

public class GstInvoiceEntityConstant {

	public final static String TotAssVal = "VALDTLS_ASSVAL";
	public final static String TotCgstVal = "VALDTLS_CGSTVAL";
	public final static String TotSgstVal = "VALDTLS_SGSTVAL";
	public final static String TotIgstVal = "VALDTLS_IGSTVAL";
	public final static String TotCesVal = "VALDTLS_CESVAL";
	public final static String TotStCesVal = "VALDTLS_STCESVAL";
	public final static String TotDiscount = "VALDTLS_DISCOUNT";
	public final static String TotOthChrg = "VALDTLS_OTHCHRG";
	public final static String TotRndOffAmt = "VALDTLE_RNDOFFAMT";
	public final static String TotInvval = "VALDTLS_TOTINVVAL";
	public final static String TotInvValFc = "VALDTLS_TOTINVVALFC";
	
	public final static String TRX_ID="TRX_ID";

	public final static String XX_GST_HEADER_TABLE = "XXQUEST_EINV_DETAILS_STG";
	public final static String XX_GST_EWB_HDR_TBL = "XXQUEST_EINV_DETAILS_STG";

	public final static String XX_GST_LINE_ITEM_TABLE = "XXQUEST_EINV_DETAILS_STG";
	public final static String XX_GST_SCHEMA = "QUAPPS";

	public final static String DOCDTLS_TYP = "DOCUMENT_TYPES";

	// @Column(name = "DOC_NO")
	public final static String dOCDTLS = "INVOICE_NUMBER";

	// @Column(name = "DOC_DATE")
	public final static String DOCDTLS_DT = "INVOICE_DATE_NEW";

	public final static String DocDtls = "DocDtls";

	public final static String TranDtls = "TranDtls";

	public final static String TRANDTLS_TAX_SCH = "TAX_SCHEMA";

	// @Column(name = "TRANS_CATEGORY")
	public final static String TRANDTLS_SUP_TYP = "TYPE_OF_TRANSACTION";

	// @Column(name = "REG_REV")
	public final static String TRANDTLS_REG_REV = "REVERSE_CHARGE";

	// @Column(name = "ECOM_GSTN")
	public final static String TRANDTLS_ECM_GSTIN = "";

	// @Column(name = "IGST_INTRA")
	public final static String TRANDTLS_IGST_ON_INTRA = "IGSTONINTRA";

	public final static String SellerDtls = "SellerDtls";

	// @Column(name = "SELLER_GSTN")
	public final static String SELLERDTLS_GSTIN = "SUPPLIER_GSTIN";

	// @Column(name = "SELLER_LGLNAME")
	public final static String SELLERDTLS_LGLNM = "SUPPLIER_NAME";

	// @Column(name = "SELLER_TRDNAME")
	public final static String SELLERDTLS_TRDNM

			= "SUPPLIER_NAME";

	// @Column(name = "SELLER_ADDRESS1")
	public final static String SELLERDTLS_ADDR1

			= "SUPPLIER_ADDRESS";

	// @Column(name = "SELLER_ADDRESS2")
	public final static String SELLERDTLS_ADDR2

			= "SUPPLIER_ADDRESS2";

	// @Column(name = "SELLER_LOC")
	public final static String SELLERDTLS_LOC

			= "SUPPLIER_PLACE";

	// @Column(name = "SELLER_PIN")
	public final static String SELLERDTLS_PIN

			= "SUPPLIER_PINCODE";

	// @Column(name = "SELLER_STATECODE")
	public final static String SELLERDTLS_STCD

			= "SELLER_ST_CODE";

	// @Column(name = "SELLER_PHNO")
	public final static String SELLERDTLS_PH = "";

	// @Column(name = "SELLER_EMAIL")
	public final static String SELLERDTLS_EM = "";

	public final static String BuyerDtls = "BuyerDtls";

	// @Column(name = "BUYER_GSTN")
	public final static String BUYERDTLS_GSTIN = "BUYER_GSTIN";

	// @Column(name = "BUYER_LGLNAME")
	public final static String BUYERDTLS_LGLNM

			= "BUYER_LEGAL_NAME";

	// @Column(name = "BUYER_TRDNAME")
	public final static String BUYERDTLS_TRDNM

			= "BUYER_TRADE_NAME";

	public final static String BUYERDTLS_POS

			= "PLACE_OF_SUPPLY";

	// @Column(name = "BUYER_ADDRESS1")
	public final static String BUYERDTLS_ADDR1

			= "BUYER_ADDRESS";

	// @Column(name = "BUYER_ADDRESS2")
	public final static String BUYERDTLS_ADDR2

			= "BUYER_ADDRESS2";

	// @Column(name = "BUYER_LOC")
	public final static String BUYERDTLS_LOC

			= "BUYER_STATE_CODE";

	// @Column(name = "BUYER_STATECODE")
	public final static String BUYERDTLS_STCD

			= "BUYER_ST_CODE";

	// @Column(name = "BUYER_PIN")
	public final static String BUYERDTLS_PIN

			= "BUYER_PINCODE";

	// @Column(name = "BUYER_PHNO")
	public final static String BUYERDTLS_PH

			= "";

	// @Column(name = "BUYER_EMAIL")
	public final static String BUYERDTLS_EM

			= "";

	public final static String DispDtls = "DispDtls";
	// @JsonProperty(value = "BEm")
	// @Column(name = "DISP_TRDNAME")
	public final static String DISPDTLS_NM

			= "DISPATCH_FROM_COMPANY_NAME";
	// @JsonProperty(value = "DisAddr1")
	// @Column(name = "DISP_ADDRESS1")
	public final static String DISPDTLS_ADDR1

			= "DISPATCH_FROM_ADDRESS";
	// @JsonProperty(value = "DisAddr2")
	// @Column(name = "DISP_ADDRESS2")
	public final static String DISPDTLS_ADDR2

			= "";
	// @JsonProperty(value = "DisLoc")
	// @Column(name = "DISP_LOC")
	public final static String DISPDTLS_LOC

			= "DISPATCH_FROM_PLACE";
	// @JsonProperty(value = "DisPin")
	// @Column(name = "DISP_PIN")
	public final static String DISPDTLS_PIN

			= "DISPATCH_FROM_PINCODE";
	// @JsonProperty(value = "DisStcd")
	// @Column(name = "DISP_STATECODE")
	public final static String DISPDTLS_STCD

			= "DISPATCH_STATE_CODE";

	public final static String ShipDtls = "ShipDtls";
	// @JsonProperty(value = "ShipGstin")
	// @Column(name = "SHIP_GSTN")

	public final static String SHIPDTLS_GSTIN = "SHIP_TO_GSTIN";

	// @JsonProperty(value = "ShipLglNm")
	// @Column(name = "SHIP_LGLNAME")
	public final static String SHIPDTLS_LGLNM

			= "SHIP_TO_LEGAL_NAME";
	// @JsonProperty(value = "ShipTrdNm")
	// @Column(name = "SHIP_TRDNAME")
	public final static String SHIPDTLS_TRDNM

			= "SHIP_TO_TRADE_NAME";
	// @JsonProperty(value = "ShipAddr1")
	// @Column(name = "SHIP_ADDRESS1")
	public final static String SHIPDTLS_ADDR1

			= "SHIP_TO_ADDRESS";
	// @JsonProperty(value = "ShipAddr2")
	// @Column(name = "SHIP_ADDRESS2")
	public final static String SHIPDTLS_ADDR2

			= "";
	// @JsonProperty(value = "ShipLoc")
	// @Column(name = "SHIP_LOC")
	public final static String SHIPDTLS_LOC

			= "SHIP_TO_PLACE";
	// @JsonProperty(value = "ShipPin")
	// @Column(name = "SHIP_PIN")
	public final static String SHIPDTLS_PIN

			= "SHIP_TO_PINCODE";
	// @JsonProperty(value = "ShipStcd")
	// @Column(name = "SHIP_STATECODE")
	public final static String SHIPDTLS_STCD

			= "SHIP_TO_STATE_CODE";

	public final static String ValDtls = "ValDtls";

	// @JsonProperty(value = "TotAssVal")
	// @Column(name = "TAXABLE_AMT"

	public final static String VALDTLS_ASSVAL = "VALDTLS_ASSVAL";

	// @JsonProperty(value = "TotCgstVal")
	public final static String VALDTLS_CGSTVAL = "VALDTLS_CGSTVAL";

	// @JsonProperty(value = "TotSgstVal")
	public final static String VALDTLS_SGSTVAL = "VALDTLS_SGSTVAL";

	// @JsonProperty(value = "TotIgstVal")
	public final static String VALDTLS_IGSTVAL = "VALDTLS_IGSTVAL";

	// @JsonProperty(value = "TotCesVal")
	public final static String VALDTLS_CESVAL = "VALDTLS_CESVAL";

	// @JsonProperty(value = "TotStCesVal")
	public final static String VALDTLS_STCESVAL = "VALDTLS_STCESVAL";

	// @JsonProperty(value = "TotDiscount")
	public final static String VALDTLS_DISCOUNT

			= "VALDTLS_DISCOUNT";

	// @JsonProperty(value = "TotOthChrg")
	public final static String VALDTLS_OTHCHRG

			= "VALDTLS_OTHCHRG";

	// @JsonProperty(value = "TotRndOffAmt")

	public final static String VALDTLE_RNDOFFAMT

			= "VALDTLE_RNDOFFAMT";
	// @JsonProperty(value = "TotInvval")
	// @Column(name = "TOTAL_AMT")
	public final static String VALDTLS_TOTINVVAL

			= "VALDTLS_TOTINVVAL";

	// @JsonProperty(value = "TotInvValFc")

	public final static String VALDTLS_TOTINVVALFC

			= "VALDTLS_TOTINVVALFC";

	public final static String PayDtls = "PayDtls";
	// @JsonProperty(value = "PayNm")
	// @Column(name = "PAYEE_NAME")
	public final static String PAYDTLS_NM

			= "";
	// @Column(name = "PAYMENT_MODE")
	// @JsonProperty(value = "PayMode")
	public final static String PAYDTLS_MODE

			= "";
	// @Column(name = "BRANCH_IFSC")
	// @JsonProperty(value = "PayFinInsBr")
	public final static String PAYDTLS_FININSBR

			= "";
	// @Column(name = "PAYMENT_TERM")
	// @JsonProperty(value = "PayTerm")
	public final static String PAYDTLS_PAYTERM

			= "";
	// @Column(name = "PAYMENT_INSTRUCTIONS")
	// @JsonProperty(value = "PayInstr")
	public final static String PAYDTLS_PAYINSTR

			= "";
	// @Column(name = "CREDIT_TRANSFER")
	// @JsonProperty(value = "PayCrtrn")
	public final static String PAYDTLS_CRTRN

			= "";
	// @Column(name = "DIRECT_DEBIT")
	// @JsonProperty(value = "PayDirDr")
	public final static String PAYDTLS_DIRDR

			= "";
	// @Column(name = "CREDIT_DAYS")
	// @JsonProperty(value = "PayCrDay")
	public final static String PAYDTLS_CRDAY

			= "";
	// @Column(name = "PAID_AMT")
	// @JsonProperty(value = "PayPaidAmt")
	public final static String PAYDTLS_PAIDAMT

			= "";

	// @JsonProperty(value = "PayPaymtDue")
	public final static String PAYDTLS_PAYMTDUE

			= "";
	// @Column(name = "PAY_ACCT_DTLS")
	// @JsonProperty(value = "PayAcctDet")
	public final static String PAYDTLS_ACCDET

			= "";

	public final static String RefDtls = "RefDtls";
	// @Column(name = "REF_INV_REMARK")
	// @JsonProperty(value = "RefInvRm")
	public final static String REF_INV_REMARK

			= "";
	// @JsonProperty(value = "InvStDt")
	// @Column(name = "REF_INV_START_DATE")
	public final static String REF_INV_START_DATE = "";
	// @JsonProperty(value = "InvEndDt")
	// @Column(name = "REF_INV_END_DATE")
	public final static String REF_INV_END_DATE = "";
	// @JsonProperty(value = "InvNo")
	// @Column(name = "PRE_INV_NO")
	public final static String PRE_INV_NO

			= "";
	// @JsonProperty(value = "InvDt")
	// @Column(name = "PRE_INV_DATE")
	public final static String REFDTLS_PRECDOCDTLS_INVDT = "";
	// @JsonProperty(value = "OthRefNo")
	// @Column(name = "OTHER_REF_NO")
	public final static String REFDTLS_PRECDOCDTLS_OTHREFNO = "";
	// @JsonProperty(value = "RecAdvRefr")
	// @Column(name = "REC_ADV_REF")
	public final static String REFDTLS_CONTRDTLS_RECADVREFR = "";

	// @JsonProperty(value = "RecAdvDt")
	// @Column(name = "REC_ADV_DATE")
	public final static String REFDTLS_CONTRACT_RECADVDT = "";
	// @JsonProperty(value = "TendRefr")
	// @Column(name = "TEND_REF_NO")
	public final static String REFDTLS_CONTRDTLS_TENDREFR = "";
	// @JsonProperty(value = "ContrRefr")
	// @Column(name = "CONTRACT_REF")
	public final static String REFDTLS_CONTRDTLS_CONTRREFR = "";
	// @JsonProperty(value = "ExtRefr")
	// @Column(name = "EXTERNAL_REF")
	public final static String REFDTLS_CONTRDTLS_EXTREFR = "";
	// @JsonProperty(value = "ProjRefr")
	// @Column(name = "PROJECT_REF")
	public final static String REFDTLS__CONTRDTLS_PROJREFR = "";
	// @JsonProperty(value = "PORefr")

	// @Column(name = "PO_REF")
	public final static String REFDTLS_CONTRDTLS_POREFR

			= "";
	// @JsonProperty(value = "PORefDt")
	// @Column(name = "PO_REF_DATE")
	public final static String REFDTLS_CONTRACT_POREFDT = "";

	public final static String AddlDocDtls = "AddlDocDtls";

	// @JsonProperty(value = "Url")
	// @Column(name = "ADD_DOC_URL")
	public final static String ADDLDTLS_ADDLDOCUMENT_URL

			= "";
	// @JsonProperty(value = "Docs")
	// @Column(name = "ADD_DOC")
	public final static String ADDLDTLS_ADDLDOCUMENT_DOCS

			= "";
	// @JsonProperty(value = "InfoDtls")
	// @Column(name = "ADD_INFO_DTLS")
	public final static String ADDLDTLS_ADDLDOCUMENT_INFO

			= "";

	public final static String ExpDtls = "ExpDtls";
	// @JsonProperty(value = "ExpShipBNo")
	// @Column(name = "EXP_SHIP_BILL_NO")
	public final static String EXPDTLS_SHIPBNO = "";
	// @JsonProperty(value = "ExpShipBDt")
	// @Column(name = "EXP_SHIP_BILL_DATE")
	public final static String EXPDTLS_SHIPBDT = "";
	// @JsonProperty(value = "ExpPort")
	// @Column(name = "EXPORT_PORT_CODE")
	public final static String EXPDTLS_PORT = "";
	// @JsonProperty(value = "ExpRefClm")
	// @Column(name = "EXPORT_REF_CLM")
	public final static String EXPDTLS_REFCLM = "";
	// @JsonProperty(value = "ExpForCur")
	// @Column(name = "EXPORT_CURRENCY")
	public final static String EXPDTLS_FORCUR

			= "";
	// @JsonProperty(value = "ExpCntCode")
	// @Column(name = "EXPORT_COUNTRY")
	public final static String EXPDTLS_CNTCODE

			= "";
	// @JsonProperty(value = "ExpDuty")
	// @Column(name = "EXPORT_DUTY")
	public final static String EXPDTLS_EXPDUTY = "";

	// need to check ballapur

	// @JsonProperty(value = "EwbNo")
	// //@Column(name = "TRANS_ID")
	public final static String EWB_NO = "";
	// @JsonProperty(value = "EwbDt")

	// //@Column(name = "TRANS_CATEGORY")
	public final static String TRANS_CATEGORY = "";
	// @JsonProperty(value = "EwbValidTill")

	// //@Column(name = "TRANS_CATEGORY")
	public final static String EWB_VALID_TILL = "";
	// need to check ballapur

	// @Column(name = "EWB_STATUS")
	public final static String EWB_STATUS = "";

	public final static String EwbDtls = "EwbDtls";

	// @JsonProperty(value = "TransId")
	// @Column(name = "TRANS_ID")
	public final static String EWBDTLS_TRANSID = "";
	// @JsonProperty(value = "TransName")
	// @Column(name = "TRANS_NAME")
	public final static String EWBDTLS_TRANSNAME

			= "";
	// @JsonProperty(value = "TransMode")
	// @Column(name = "TRANS_MODE")
	public final static String EWBDTLS_TRANSMODE = "";
	// @JsonProperty(value = "Distance")
	// @Column(name = "TRANS_DISTANCE")
	public final static String EWBDTLS_DISTANCE

			= "";
	// @JsonProperty(value = "TransDocNo ")
	// @Column(name = "TRANS_DOC_NO")
	public final static String EWBDTLS_TRANSDOCNO = "";
	// @JsonProperty(value = "TransDocDt")
	// @Column(name = "TRANS_DOC_DATE")
	public final static String EWBDTLS_TRANSDOCDT = "";
	// @JsonProperty(value = "VehNo")
	// @Column(name = "VEHICLE_NO")
	public final static String EWBDTLS_VEHNO = "";
	// @JsonProperty(value = "VehType")
	// @Column(name = "VEHICLE_TYPE")
	public final static String EWBDTLS_VEHTYPE = "";
	// @JsonProperty(value = "Irn")
	// @Column(name = "IRN_NO")
	public final static String IRN_NUMBER

			= "IRN";

	// @Column(name = "QR_CODE")
	public final static String QR_CODE = "SIGNED_QR_CODE";

	// @Column(name = "ACK_NO")
	public final static String ACKNO

			= "";

	public final static String ACK_DATE = "";

	// @Column(name = "IRN_STATUS")
	public final static String iRNSTATUS = "IRN_STATUS";

	// @Column(name = "ERROR_MSG")
	public final static String ERROR_MESSAGE = "ERROR_MSG";

	// @Column(name = "CREATION_DATE")
	public final static String CREATION_DATE = "";

	// @Column(name = "CREATED_BY")
	public final static String CREATED_BY

			= "";

	// @Column(name = "LAST_UPDATE_DATE")
	public final static String LAST_UPDATED_DATE = "";

	// @Column(name = "LAST_UPDATED_BY")
	public final static String LAST_UPDATED_BY

			= "";

	public final static String QR_IMAGE_PATH

			= "";

	public final static String QR_IMAGE_FILE_NAME = "QR_CODE_FILENAME";

	// @Column(name = "IRP_REQUEST", columnDefinition = "BLOB")
	public final static String IRP_REQUEST = "";

	// @Column(name = "IRP_RESPONSE", columnDefinition = "BLOB")
	public final static String IRP_RESPONSIE = "";

	public final static String CANCEL_IRN_STATUS = "CANCEL_IRN_STATUS";

	public final static String CANCEL_DATE = "CANCEL_DATE";

	public final static String CANCEL_CODE = "CANCEL_CODE";


	// @Column(name = "CANCEL_IRN_REQUEST", columnDefinition = "BLOB")
	public final static String CANCEL_IRN_REQUEST = "CANCEL_IRN_REQUEST";

	// @Column(name = "CANCEL_IRN_RESPONSE", columnDefinition = "BLOB")
	public final static String CANCEL_IRN_RESPONSE = "CANCEL_IRN_RESPONSE";

	// @Column(name = "EWB_REQUEST", columnDefinition = "BLOB")
	public final static String EWB_REQUEST = "";

	// @Column(name = "EWB_RESPONSE", columnDefinition = "BLOB")
	public final static String EWB_RESPONSE = "";

	public final static String organizationId = "";

//	@Column(name = "SI_NO")
	public final static String SlNo

			= "TRX_LINE_NUMBER";
	// @Column(name = "ITEM_DESC")
	public final static String PrdDesc

			= "ITEM_DESCRIPTION";
	// @Column(name = "IS_SERVICE")
	public final static String IsServc

			= "SERVICE_ITEM_FLAG";
	// @Column(name = "HSN_CODE")
	public final static String HsnCd

			= "HSN_CODE";

	// @Column(name = "BAR_CODE")
	public final static String Barcde = "";

	// @Column(name = "BATCH_NAME")
	public final static String ITEMLIST_ITEM_BCHDTLS_NM = "";
	// @Column(name = "BATCH_EXP_DATE")
	public final static String ITEMLIST_ITEM_BCHDTLS_EXPDT = "";
	// @Column(name = "BATCH_WARRANTY_DATE")
	public final static String ITEMLIST_ITEM_BCHDTLS_WRDT = "";

	// @Column(name = "QUANTITY")
	public final static String Qty = "ITEM_QUANTITY";

	// @Column(name = "FREE_QUANTITY")
	public final static String FreeQty = "";

	// @Column(name = "UOM")
	public final static String Unit = "UOM";
	// @Column(name = "UNIT_PRICE")
	public final static String UnitPrice = "ITEM_RATE_PER_QUANTITY";
	// @Column(name = "TOT_AMT")
	public final static String TotAmt = "TAXABLE_VALUE";
	// @Column(name = "DISCOUNT")
	public final static String Discount = "";
	// @Column(name = "PRE_TAX_VAL")
	public final static String PreTaxVal = "TAXABLE_VALUE";
	// @Column(name = "ASS_AMT")
	public final static String AssAmt = "TAXABLE_VALUE";

	// @Column(name = "GST_RATE")
	public final static String GstRt

			= "GST_RATE";
	// @Column(name = "IGST_AMT")
	public final static String IgstAmt

			= "IGST_AMOUNT";
	// @Column(name = "CGST_AMT")
	public final static String CgstAmt

			= "CGST_AMOUNT";
	// @Column(name = "SGST_AMT")
	public final static String SgstAmt

			= "SGST_AMOUNT";
	// @Column(name = "CESS_RATE")
	public final static String CesRt

			= "CESS_RATE";
	// @Column(name = "CESS_AMT")
	public final static String CesAmt

			= "CESS_AMOUNT";
//	@Column(name = "CESS_NONAD_AMT")
	public final static String CesNonAdvlAmt

			= "CESS_NON_ADVOL_AMOUNT";
//	@Column(name = "STATECESS_RATE")
	public final static String StateCesRt

			= "STATE_CESS";
	// @Column(name = "STATECESS_AMT")
	public final static String StateCesAmt

			= "STATE_CESS_AMOUNT";
	// @Column(name = "STATECESS_NONAD_AMT")
	public final static String StateCesNonAdvlAmt

			= "STATE_CESS_AMOUNT";
	// @Column(name = "OTHER_CHARGES")
	public final static String OthChrg

			= "";
	// @Column(name = "TOTAL_ITEM_VAL")
	public final static String TotItemVal

			= "TOTAL_LINE_VALUE";

	public final static String OrdLineRef

			= "";
	// @Column(name = "SERIAL_NUMBER")
	public final static String PrdSlNo

			= "";

	// @Column(name = "ORG_COUNTRY")
	public final static String ITEMLIST_ITEM_ORGCNTRY

			= "";
//	@Column(name = "ATTR_NAME")
	public final static String ITEMLIST_ITEM_ATTRIBDTLS_NM

			= "";

	// @Column(name = "DOC_NO")
	public static final String ITEMLIST_ITEM_ATTRIBDTLS_VAL = "";
    public static final String CANCEL_REASON = "CANCEL_REASON";
    
    
    public static final String GST_UPDATE_QUERY="UPDATE "+XX_GST_SCHEMA+"."+XX_GST_HEADER_TABLE +"  SET IRN_STATUS=:IRNSTATUS,ERROR_MSG=:ERRORMSG,IRP_REQUEST=:IRPREQUEST,IRN=:IRNNUMBER,ACK_DATE=:ACKDATE,ACK_NO=:ACKNO,IRP_RESPONSE=:IRPRESPONSE,SIGNED_QR_CODE=:SIGNEDQRCODE,QR_CODE_FILENAME=:QRCODEFILENAME WHERE INVOICE_NUMBER = :INVOICENUMNEW ";
    public static final String GST_UPDATE_QUERY_C="UPDATE "+XX_GST_SCHEMA+"."+XX_GST_HEADER_TABLE +"   SET IRN_STATUS=:IRNSTATUS,CANCEL_IRN_STATUS=:CANCELIRNSTATUS,CANCEL_IRN_REQUEST=:CANCELIRNREQUEST,CANCEL_IRN_RESPONSE=:CANCELIRNRESPONSE,CANCEL_DATE=:CANCEL_DATE WHERE INVOICE_NUMBER = :INVOICENUMNEW ";

}
