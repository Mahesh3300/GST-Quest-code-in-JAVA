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
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = GstInvoiceEntityConstant.XX_GST_EWB_HDR_TBL, schema = GstInvoiceEntityConstant.XX_GST_SCHEMA)
public class GstInvoiceEWBEntity {

	@JsonIgnore
	@Id
	@Column(name = "DOCNO")
	private String dOCNO;

	// need to check ballapur

	@JsonProperty(value = "EwbNo")
	@Column(name = "EWAYBILL_NO")
	private String EWB_NO;
	@JsonProperty(value = "EwbDt")
	@Column(name = "VALID_FROM")
	private String EWB_DATE;
	@JsonProperty(value = "EwbValidTill")
	@Column(name = "VALID_UPTO")
	private String EWB_VALID_TILL;
	// need to check ballapur

	@Column(name = "EWB_STATUS")
	private String eWBSTATUS;

	@Column(name = "PROCESS_STATUS")
	private String pROCESS_STATUS;

	// TRANSDISTANCE
	;
	@Transient
	@JsonIgnore
	private String EwbDtls = "EwbDtls";

	@JsonProperty(value = "TransId")
	@Column(name = "TRANSPORTERID")
	private String EWBDTLS_TRANSID;
	@JsonProperty(value = "TransName")
	@Column(name = "TRANSPORTERNAME")
	private String EWBDTLS_TRANSNAME

	;
	@JsonProperty(value = "TransMode")
	@Column(name = "TRANSMODE")
	private String EWBDTLS_TRANSMODE;
	@JsonProperty(value = "Distance")
	@Column(name = "TRANSDISTANCE")
	private String EWBDTLS_DISTANCE

	;
	@JsonProperty(value = "TransDocNo ")
	@Column(name = "TRANSDOCNO")
	private String EWBDTLS_TRANSDOCNO;
	// @Transient
	@JsonProperty(value = "TransDocDt")
	@Column(name = "TRANSDOCDATE")
	private Date EWBDTLS_TRANSDOCDT;
	@JsonProperty(value = "VehNo")
	@Column(name = "VEHICLENO")
	private String EWBDTLS_VEHNO;
	@JsonProperty(value = "VehType")
	@Column(name = "VEHICLETYPE")
	private String EWBDTLS_VEHTYPE;
	@JsonProperty(value = "Irn")

	@Transient
	@JsonIgnore
	private String ExpShipDtls = "ExpShipDtls";
	@JsonProperty(value = "Addr1")
	@Column(name = "FROMADDR1")
	private String ExpShipAddr1;

	@JsonProperty(value = "Addr2")
	@Column(name = "FROMADDR2")
	private String ExpShipAddr2;

	@JsonProperty(value = "Loc")
	@Column(name = "FROMPLACE")
	private String ExpShipLoc;

	@JsonProperty(value = "Pin")
	@Column(name = "FROMPINCODE")
	private String ExpShipPin;

	@JsonProperty(value = "Stcd")
	@Column(name = "FROMSTATECODE")
	private String ExpShipStcd

	;

	@Transient
	@JsonIgnore
	private String ExpDtls = "DispDtls";
	@JsonProperty(value = "Nm")
	@Column(name = "TOTRDNAME")
	private String DispNm;

	@JsonProperty(value = "Addr1")
	@Column(name = "TOADDR1")
	private String DispAddr1;

	@JsonProperty(value = "Addr2")
	@Column(name = "TOADDR2")
	private String DispAddr2;

	@JsonProperty(value = "Loc")
	@Column(name = "TOPLACE")
	private String DispLoc;
	@JsonProperty(value = "Pin")
	@Column(name = "TOPINCODE")
	private String DispPin

	;

	@JsonProperty(value = "Stcd")
	@Column(name = "TOSTATECODE")
	private String DispStcd

	;

	// need to check

	@Transient
	@Column(name = "IRN_NO")
	private String IRN_NUMBER

	;

	@JsonIgnore
	@Column(name = "ERROR_MSG")
	private String ERROR_MESSAGE;
	@JsonIgnore
	@Transient
	@Column(name = "CREATION_DATE")
	private Date CREATION_DATE;
	
	@JsonIgnore
	@Column(name = "CANCEL_DATE")
	private Date cANCEL_DATED;
	@JsonIgnore
	@Column(name = "CREATED_BY")
	private String CREATED_BY

	;
	@JsonIgnore
	@Transient
	@Column(name = "LAST_UPDATE_DATE")
	private Date LAST_UPDATED_DATE;
	@JsonIgnore
	@Column(name = "LAST_UPDATED_BY")
	private String LAST_UPDATED_BY;
	
	
	@JsonIgnore
	@Column(name = "CANCEL_FLAG")
	private String cANCELFLAG;
	  
	@JsonIgnore
	@Column(name = "CANCEL_CODE")
	private String CANCEL_CODE;
	@JsonIgnore
	@Column(name = "CANCEL_REMARK")
	private String CANCEL_REMARK;
	
	

	
	@Transient
	@JsonIgnore
	private String QR_IMAGE_PATH

	;
	@Transient
	@JsonIgnore
	private String QR_IMAGE_FILE_NAME;

	@JsonIgnore
	@Column(name = "EWB_REQUEST", columnDefinition = "BLOB")
	private byte[] EWB_REQUEST;

	@JsonIgnore
	@Column(name = "EWB_RESPONSE", columnDefinition = "BLOB")
	private byte[] EWB_RESPONSE;
	
	@JsonIgnore
	@Column(name = "CANCEL_EWB_REQ", columnDefinition = "BLOB")
	private byte[] CANCEL_EWB_REQ;

	@JsonIgnore
	@Column(name = "CANCEL_EWB_RESP", columnDefinition = "BLOB")
	private byte[] CANCEL_EWB_RESP;
	
	//FOR EWB CANCELLATION: CANCEL_DATE,CANCEL_EWB_REQ,CANCEL_EWB_RESP IN TABLE : XX_GST_EWB_HDR_TBL

	@JsonIgnore
	@Transient
	private String organizationId;

}
