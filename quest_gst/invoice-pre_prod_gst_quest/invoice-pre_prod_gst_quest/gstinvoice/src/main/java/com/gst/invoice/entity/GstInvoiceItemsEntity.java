package com.gst.invoice.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
@Entity
@Table(name = GstInvoiceEntityConstant.XX_GST_LINE_ITEM_TABLE, schema = GstInvoiceEntityConstant.XX_GST_SCHEMA)
public class GstInvoiceItemsEntity {

	@Id
	@Column(name = GstInvoiceEntityConstant.SlNo)
	private String SlNo

	;
	@Column(name = GstInvoiceEntityConstant.PrdDesc)
	private String PrdDesc

	;
	@Column(name = GstInvoiceEntityConstant.IsServc)
	private String IsServc

	;
	@Column(name = GstInvoiceEntityConstant.HsnCd)
	private String HsnCd

	;

	@Transient
	@Column(name = GstInvoiceEntityConstant.Barcde)
	private String Barcde;

	@JsonIgnore
	@Transient
	@Column(name = GstInvoiceEntityConstant.ITEMLIST_ITEM_BCHDTLS_NM)
	private String ITEMLIST_ITEM_BCHDTLS_NM;;
	@JsonIgnore
	@Transient
	@Column(name = GstInvoiceEntityConstant.ITEMLIST_ITEM_BCHDTLS_EXPDT)
	private String ITEMLIST_ITEM_BCHDTLS_EXPDT;
	@JsonIgnore
	@Transient
	@Column(name = GstInvoiceEntityConstant.ITEMLIST_ITEM_BCHDTLS_WRDT)
	private String ITEMLIST_ITEM_BCHDTLS_WRDT;
	
	
	
	

	@Column(name = GstInvoiceEntityConstant.Qty)
	private BigDecimal Qty;

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.FreeQty)
	private BigDecimal FreeQty;

	@Column(name = GstInvoiceEntityConstant.Unit)
	private String Unit;
	@Column(name = GstInvoiceEntityConstant.UnitPrice)
	private BigDecimal UnitPrice;
	
	@Column(name = GstInvoiceEntityConstant.TotAmt,insertable = false, updatable = false)
	private BigDecimal TotAmt;
	

	
	@Transient
	@Column(name = GstInvoiceEntityConstant.Discount)
	private BigDecimal Discount;
	@Column(name = GstInvoiceEntityConstant.PreTaxVal,insertable = false, updatable = false)
	private BigDecimal PreTaxVal;
	@Column(name = GstInvoiceEntityConstant.AssAmt,insertable = false, updatable = false)
	private BigDecimal AssAmt;

	@Column(name = GstInvoiceEntityConstant.GstRt)
	private BigDecimal GstRt

	;
	@Column(name = GstInvoiceEntityConstant.IgstAmt)
	private BigDecimal IgstAmt

	;
	@Column(name = GstInvoiceEntityConstant.CgstAmt)
	private BigDecimal CgstAmt

	;
	@Column(name = GstInvoiceEntityConstant.SgstAmt)
	private BigDecimal SgstAmt

	;
	@Column(name = GstInvoiceEntityConstant.CesRt)
	private BigDecimal CesRt

	;
	@Column(name = GstInvoiceEntityConstant.CesAmt)
	private BigDecimal CesAmt

	;
	@Column(name = GstInvoiceEntityConstant.CesNonAdvlAmt)
	private BigDecimal CesNonAdvlAmt

	;
	@Column(name = GstInvoiceEntityConstant.StateCesRt)
	private BigDecimal StateCesRt

	;
	@Column(name = GstInvoiceEntityConstant.StateCesAmt)
	private BigDecimal StateCesAmt

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.StateCesNonAdvlAmt)
	private BigDecimal StateCesNonAdvlAmt

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.OthChrg)
	private BigDecimal OthChrg

	;
	@Column(name = GstInvoiceEntityConstant.TotItemVal)
	private BigDecimal TotItemVal

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.OrdLineRef)
	private String OrdLineRef

	;
	@Transient
	@Column(name = GstInvoiceEntityConstant.PrdSlNo)
	private String PrdSlNo

	;

	@JsonIgnore
	@Transient
	@Column(name = GstInvoiceEntityConstant.ITEMLIST_ITEM_ORGCNTRY)
	private String ITEMLIST_ITEM_ORGCNTRY

	;
	@JsonIgnore
	@Transient
	@Column(name = GstInvoiceEntityConstant.ITEMLIST_ITEM_ATTRIBDTLS_NM)
	private String ITEMLIST_ITEM_ATTRIBDTLS_NM

	;
	@JsonIgnore
	@Transient
	@Column(name = GstInvoiceEntityConstant.ITEMLIST_ITEM_ATTRIBDTLS_VAL)
	private String ITEMLIST_ITEM_ATTRIBDTLS_VAL

	;

	@Transient
	private List<GstInvoiceItemsAttributeEntity> AttribDtls;

	@Transient
	private GstInvoiceItemsBatchEntity BchDtls;

	@Column(name = GstInvoiceEntityConstant.dOCDTLS)
	private String dOCDTLSNO;

	@JsonIgnore
	@Transient
	private String organizationId;
}
