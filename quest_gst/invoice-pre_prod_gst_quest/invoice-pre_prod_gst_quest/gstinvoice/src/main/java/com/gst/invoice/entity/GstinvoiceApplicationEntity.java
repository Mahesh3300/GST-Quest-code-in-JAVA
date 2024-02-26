package com.gst.invoice.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class GstinvoiceApplicationEntity {

	@JsonProperty(value = "Version")
	private String Version = "1.1";

	@JsonProperty(value = "Irn")
	private String Irn = null;
	@JsonProperty(value = "TranDtls")
	private GstInvoiceTransaction TranDtls;
	@JsonProperty(value = "DocDtls")
	private GstInvoiceDoc DocDtls;

	@JsonProperty(value = "SellerDtls")
	private GstInvoiceSeller SellerDtls;

	@JsonProperty(value = "BuyerDtls")
	private GstInvoiceBuyer BuyerDtls;

	@JsonProperty(value = "DispDtls")
	private GstInvoiceDistributer DispDtls;

	@JsonProperty(value = "ShipDtls")
	private GstInvoiceShipmentDetails ShipDtls;
	@JsonProperty(value = "ItemList")
	private List<GstInvoiceItemsEntity> ItemList;
	@JsonProperty(value = "ValDtls")
	private GstInvoiceValidationDetails ValDtls;
	@JsonProperty(value = "PayDtls")
	private GstInvoicePaymenttDetails PayDtls;
	@JsonProperty(value = "RefDtls")
	private GstInvoiceRefDetails RefDtls;
	@JsonProperty(value = "AddlDocDtls")
	private List<GstInvoiceAdditionalDoc> AddlDocDtls;
	@JsonProperty(value = "ExpDtls")
	private GstInvoiceExpDetails ExpDtls;
	@JsonProperty(value = "EwbDtls")
	private GstInvoiceEwbDetails EwbDtls;

}
