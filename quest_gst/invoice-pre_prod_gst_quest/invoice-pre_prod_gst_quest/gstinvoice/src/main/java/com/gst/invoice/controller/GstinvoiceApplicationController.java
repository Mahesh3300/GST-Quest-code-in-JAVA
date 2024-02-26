package com.gst.invoice.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gst.invoice.entity.GstInvoiceAdditionalDoc;
import com.gst.invoice.entity.GstInvoiceBuyer;
import com.gst.invoice.entity.GstInvoiceDistributer;
import com.gst.invoice.entity.GstInvoiceDoc;
import com.gst.invoice.entity.GstInvoiceEntity;
import com.gst.invoice.entity.GstInvoiceEwbDetails;
import com.gst.invoice.entity.GstInvoiceExpDetails;
import com.gst.invoice.entity.GstInvoiceItemsAttributeEntity;
import com.gst.invoice.entity.GstInvoiceItemsBatchEntity;
import com.gst.invoice.entity.GstInvoiceItemsEntity;
import com.gst.invoice.entity.GstInvoicePaymenttDetails;
import com.gst.invoice.entity.GstInvoiceRefDetails;
import com.gst.invoice.entity.GstInvoiceRefDetails.ContrDtls;
import com.gst.invoice.entity.GstInvoiceRefDetails.PrecDocDtls;
import com.gst.invoice.entity.GstInvoiceSeller;
import com.gst.invoice.entity.GstInvoiceShipmentDetails;
import com.gst.invoice.entity.GstInvoiceTransaction;
import com.gst.invoice.entity.GstInvoiceValidationDetails;
import com.gst.invoice.entity.GstinvoiceApplicationEntity;
import com.gst.invoice.service.GstinvoiceApplicationService;

@RestController("invoice")
@RequestMapping("gst/invoice")
@CrossOrigin(origins = "*")
public class GstinvoiceApplicationController {

	@Autowired
	GstinvoiceApplicationService gstinvoiceApplicationService;
	GstinvoiceApplicationEntity invoiceApplicationEntity = new GstinvoiceApplicationEntity();

	@SuppressWarnings("unchecked")
	@GetMapping()
	public ResponseEntity<String> getInvoiceData() {

		String gson = gsonOutPut("", "");
		return new ResponseEntity<>(gson, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * @param gstinvoiceApplicationEntity
	 * @return
	 */
	public String gsonOutPut(String docNumber, String orgNumber) {

		String responseJson = "";
		List<GstInvoiceEntity> gstinvoiceApplicationEntity = null;
		if (docNumber.equalsIgnoreCase("")) {
			gstinvoiceApplicationEntity = gstinvoiceApplicationService.getGstData();
		} else {
			gstinvoiceApplicationEntity = gstinvoiceApplicationService.getGstData(docNumber);
		}

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().create();

		if (gstinvoiceApplicationEntity.size() > 0) {
			List<PrecDocDtls> ll = new ArrayList();
			GstInvoiceEntity ainvo = gstinvoiceApplicationEntity.get(0);
			ll.add(new GstInvoiceRefDetails().new PrecDocDtls(ainvo.getREFDTLS_PRECDOCDTLS_INVNO(),
					ainvo.getREFDTLS_PRECDOCDTLS_INVDT(), ainvo.getREFDTLS_PRECDOCDTLS_OTHREFNO()));

			Map<String, Object> claims = new HashMap<String, Object>();

			claims.put("Version", "1.1");
			claims.put("Irn", "null");

			String ds2 = "";
			ds2 = new SimpleDateFormat("dd/MM/yyyy").format(ainvo.getDOCDTLS_DT());//dd/mm/yyyy

//System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(ainvo.getDOCDTLS_DT()));

//System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(ainvo.getDOCDTLS_DT()));
			// TODO Auto-generated catch block
			System.out.println(ds2);

			// TranDtls.TaxSch
			invoiceApplicationEntity.setDocDtls(new GstInvoiceDoc(ainvo.getDOCDTLS_TYP(), ainvo.getDOCDTLS(), ds2));
			invoiceApplicationEntity.setTranDtls(new GstInvoiceTransaction("GST", ainvo.getTRANDTLS_SUP_TYP(),
					ainvo.getTRANDTLS_REG_REV(), ainvo.getTRANDTLS_ECM_GSTIN(), ainvo.getTRANDTLS_IGST_ON_INTRA()));
			invoiceApplicationEntity.setSellerDtls(new GstInvoiceSeller(ainvo.getSELLERDTLS_GSTIN(),
					ainvo.getSELLERDTLS_LGLNM(), ainvo.getSELLERDTLS_TRDNM(), ainvo.getSELLERDTLS_ADDR1(),
					ainvo.getSELLERDTLS_ADDR2(), ainvo.getSELLERDTLS_LOC(), ainvo.getSELLERDTLS_PIN()!=null?new BigDecimal(ainvo.getSELLERDTLS_PIN()):null,
					ainvo.getSELLERDTLS_STCD(), ainvo.getSELLERDTLS_PH(), ainvo.getSELLERDTLS_EM()));

			invoiceApplicationEntity.setBuyerDtls(new GstInvoiceBuyer(ainvo.getBUYERDTLS_GSTIN(),
					ainvo.getBUYERDTLS_LGLNM(), ainvo.getBUYERDTLS_TRDNM(), ainvo.getBUYERDTLS_STCD(),

					ainvo.getBUYERDTLS_ADDR1(), ainvo.getBUYERDTLS_ADDR2(), ainvo.getBUYERDTLS_LOC(),
					ainvo.getBUYERDTLS_STCD(), ainvo.getBUYERDTLS_PIN()!=null?new BigDecimal(ainvo.getBUYERDTLS_PIN()):null, ainvo.getBUYERDTLS_PH(),
					ainvo.getBUYERDTLS_EM()));

			invoiceApplicationEntity.setDispDtls(new GstInvoiceDistributer(ainvo.getDISPDTLS_NM(),
					ainvo.getDISPDTLS_ADDR1(), ainvo.getDISPDTLS_ADDR2(), ainvo.getDISPDTLS_LOC(),

					ainvo.getDISPDTLS_PIN()!=null?new BigDecimal(ainvo.getDISPDTLS_PIN()):null, ainvo.getDISPDTLS_STCD()));

			invoiceApplicationEntity.setShipDtls(new GstInvoiceShipmentDetails(ainvo.getSHIPDTLS_GSTIN(),
					ainvo.getSHIPDTLS_LGLNM(), ainvo.getSHIPDTLS_TRDNM(), ainvo.getSHIPDTLS_ADDR1(),

					ainvo.getSHIPDTLS_ADDR2(), ainvo.getSHIPDTLS_LOC(), ainvo.getSHIPDTLS_PIN()!=null?new BigDecimal(ainvo.getSHIPDTLS_PIN()):null,
					ainvo.getSHIPDTLS_STCD()));

			invoiceApplicationEntity.setPayDtls(new GstInvoicePaymenttDetails(ainvo.getPAYDTLS_NM(),
					ainvo.getPAYDTLS_MODE(), ainvo.getPAYDTLS_FININSBR(), ainvo.getPAYDTLS_PAYTERM(),

					ainvo.getPAYDTLS_PAYINSTR(), ainvo.getPAYDTLS_CRTRN(), ainvo.getPAYDTLS_DIRDR(),
					new BigDecimal(ainvo.getPAYDTLS_CRDAY() != null ? ainvo.getPAYDTLS_CRDAY() : "0.00"),
					new BigDecimal(ainvo.getPAYDTLS_PAIDAMT() != null ? ainvo.getPAYDTLS_PAIDAMT() : "0.00"),
					new BigDecimal(ainvo.getPAYDTLS_PAYMTDUE() != null ? ainvo.getPAYDTLS_PAYMTDUE() : "0.00"),
					ainvo.getPAYDTLS_ACCDET()));

			List<ContrDtls> contrDtlslist = new ArrayList();
			contrDtlslist.add(new GstInvoiceRefDetails().new ContrDtls(ainvo.getREFDTLS_CONTRDTLS_RECADVREFR(),
					ainvo.getREFDTLS_CONTRACT_RECADVDT(), ainvo.getREFDTLS_CONTRDTLS_TENDREFR(),
					ainvo.getREFDTLS_CONTRDTLS_CONTRREFR(), ainvo.getREFDTLS_CONTRDTLS_EXTREFR(),
					ainvo.getREFDTLS__CONTRDTLS_PROJREFR(), ainvo.getREFDTLS_CONTRDTLS_POREFR(),
					ainvo.getREFDTLS_CONTRACT_POREFDT()));
			invoiceApplicationEntity.setRefDtls(new GstInvoiceRefDetails(ainvo.getREFDTLS_INVRM(),
					new GstInvoiceRefDetails().new DocPerdDtls(ainvo.getREFDTLS_INVSTDT(), ainvo.getREFDTLS_INVENDDT()),
					ll, contrDtlslist));

			List<GstInvoiceAdditionalDoc> sss = new ArrayList<>();
			sss.add(new GstInvoiceAdditionalDoc(ainvo.getADDLDTLS_ADDLDOCUMENT_URL(),
					ainvo.getADDLDTLS_ADDLDOCUMENT_DOCS(), ainvo.getADDLDTLS_ADDLDOCUMENT_INFO()));
			invoiceApplicationEntity.setAddlDocDtls(sss);

			invoiceApplicationEntity.setExpDtls(new GstInvoiceExpDetails(ainvo.getEXPDTLS_SHIPBNO(),
					ainvo.getEXPDTLS_SHIPBDT(), ainvo.getEXPDTLS_PORT(), ainvo.getEXPDTLS_REFCLM(),
					ainvo.getEXPDTLS_FORCUR(), ainvo.getEXPDTLS_CNTCODE(),
					new BigDecimal(ainvo.getEXPDTLS_EXPDUTY() != null ? ainvo.getEXPDTLS_EXPDUTY() : "0.00")));

			invoiceApplicationEntity.setEwbDtls(new GstInvoiceEwbDetails(ainvo.getEWBDTLS_TRANSID(),
					ainvo.getEWBDTLS_TRANSNAME(), ainvo.getEWBDTLS_TRANSMODE(),
					new BigDecimal(ainvo.getEWBDTLS_DISTANCE() != null ? ainvo.getEWBDTLS_DISTANCE() : "0.00"),
					ainvo.getEWBDTLS_TRANSDOCNO(), ainvo.getEWBDTLS_TRANSDOCDT(), ainvo.getEWBDTLS_VEHNO(),
					ainvo.getEWBDTLS_VEHTYPE()));

			invoiceApplicationEntity.setValDtls(new GstInvoiceValidationDetails(
					new BigDecimal(ainvo.getVALDTLS_ASSVAL() != null ? ainvo.getVALDTLS_ASSVAL() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_CGSTVAL() != null ? ainvo.getVALDTLS_CGSTVAL() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_SGSTVAL() != null ? ainvo.getVALDTLS_SGSTVAL() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_IGSTVAL() != null ? ainvo.getVALDTLS_IGSTVAL() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_CESVAL() != null ? ainvo.getVALDTLS_CESVAL() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_STCESVAL() != null ? ainvo.getVALDTLS_STCESVAL() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_DISCOUNT() != null ? ainvo.getVALDTLS_DISCOUNT() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_OTHCHRG() != null ? ainvo.getVALDTLS_OTHCHRG() : "0.00"),
					new BigDecimal(ainvo.getVALDTLE_RNDOFFAMT() != null ? ainvo.getVALDTLE_RNDOFFAMT() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_TOTINVVAL() != null ? ainvo.getVALDTLS_TOTINVVAL() : "0.00"),
					new BigDecimal(ainvo.getVALDTLS_TOTINVVALFC() != null ? ainvo.getVALDTLS_TOTINVVALFC() : "0.00")));

			List<GstInvoiceItemsEntity> listItem = gstinvoiceApplicationService.getItemData(ainvo.getDOCDTLS());
			// if CGST_RATE is not null then ItemList.Item.GstRt=CGST_RATE*2 elsif
			// ItemList.Item.GstRt=IGST_RATE end if
			for (GstInvoiceItemsEntity itemList : listItem) {
				System.out.println("With    NullSerialize:" + gson.toJson(invoiceApplicationEntity));
				List<GstInvoiceItemsAttributeEntity> AttribDtls = new ArrayList<GstInvoiceItemsAttributeEntity>();
				GstInvoiceItemsAttributeEntity ddd = new GstInvoiceItemsAttributeEntity();
				ddd.setAttNm(itemList.getITEMLIST_ITEM_ATTRIBDTLS_NM());
				ddd.setAttVal(itemList.getITEMLIST_ITEM_ATTRIBDTLS_VAL());
				AttribDtls.add(ddd);
				GstInvoiceItemsBatchEntity BchDtls = new GstInvoiceItemsBatchEntity();
				BchDtls.setBchExpDt(itemList.getITEMLIST_ITEM_BCHDTLS_EXPDT());
				BchDtls.setBchNm(itemList.getITEMLIST_ITEM_BCHDTLS_NM());
				BchDtls.setBchWrDt(itemList.getITEMLIST_ITEM_BCHDTLS_WRDT());
				itemList.setBchDtls(BchDtls);
				itemList.setAttribDtls(AttribDtls);

			}
			invoiceApplicationEntity.setItemList(listItem);

			System.out.println(invoiceApplicationEntity);
			responseJson = gson.toJson(invoiceApplicationEntity);
			System.out.println("siva1" + responseJson);
		}
		return responseJson;
	}

}
