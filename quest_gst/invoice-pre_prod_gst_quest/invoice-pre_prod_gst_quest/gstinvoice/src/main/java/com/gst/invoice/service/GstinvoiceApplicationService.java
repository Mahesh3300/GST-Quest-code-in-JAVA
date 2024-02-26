package com.gst.invoice.service;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.gst.invoice.controller.GstinvoiceApplicationController;
import com.gst.invoice.entity.GstInvoiceDistributerEWB;
import com.gst.invoice.entity.GstInvoiceEWBEntity;
import com.gst.invoice.entity.GstInvoiceEntity;
import com.gst.invoice.entity.GstInvoiceItemsEntity;
import com.gst.invoice.entity.GstInvoiceOutPutResponse;
import com.gst.invoice.entity.GstInvoiceOutPutResponseJson;
import com.gst.invoice.entity.GstInvoiceOutPutResponseJsonEWB;
import com.gst.invoice.entity.GstInvoiceOutPutResponseJsonInfo;
import com.gst.invoice.entity.GstInvoiceRACustomerTrEntity;
import com.gst.invoice.entity.GstInvoiceShipmentDetailsEWB;
import com.gst.invoice.entity.GstInvoiceWEPISSummaryEntity;
import com.gst.invoice.entity.GstinvoiceApplicationEntityEWB;
import com.gst.invoice.repository.GstInvoiceMTLMaterialTransactionRepo;
import com.gst.invoice.repository.GstInvoiceRACustomerTransactionRepo;
import com.gst.invoice.repository.GstInvoiceWEPISSummaryRepo;
import com.gst.invoice.repository.GstinvoiceApplicationItemRepo;
import com.gst.invoice.repository.GstinvoiceApplicationRepo;
import com.gst.invoice.repository.GstinvoiceEWBApplicationRepo;

@Service
@ConfigurationProperties(prefix = "image")
public class GstinvoiceApplicationService {
	// P-Succuss
	// E-ERROR
	// I-Inprogress
	// C-Cancel

	@Autowired
	GstinvoiceApplicationRepo gstinvoiceApplicationRepo;

	@Autowired
	GstInvoiceRACustomerTransactionRepo gstInvoiceRACustomerTransactionRepo;
	@Autowired
	GstInvoiceMTLMaterialTransactionRepo gstInvoiceMTLMaterialTransactionRepo;

	GstInvoiceRACustomerTrEntity gstInvoiceRACustomerTransaction = new GstInvoiceRACustomerTrEntity();
	@Autowired
	GstInvoiceWEPISSummaryRepo gstInvoiceWEPISSummaryRepo;

	GstInvoiceWEPISSummaryEntity gstInvoiceWEPISSummaryEntity = new GstInvoiceWEPISSummaryEntity();
	com.gst.invoice.entity.GstInvoiceMTLMaterialTrEntity gstInvoiceMTLMaterialTrEntity = new com.gst.invoice.entity.GstInvoiceMTLMaterialTrEntity();
	@Autowired
	GstinvoiceApplicationItemRepo gstinvoiceApplicationItemRepo;

	@Autowired
	GstinvoiceEWBApplicationRepo gstinvoiceEWBApplicationRepo;

	@Autowired
	GstinvoiceApplicationController gstinvoiceApplicationController;

	@Autowired
	GstInvoiceIrnCancel gstInvoiceIrnCancel;

	@Autowired
	GstInvoiceEwbCancel gstInvoiceEwbCancel;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${image.filepath}")
	private String filepath;

	@Value("${apiheader.Ocp-Apim-Subscription-Key}")
	private String Ocp_Apim_Subscription_Key;
	@Value("${apiheader.sourcetype}")
	private String sourcetype;
	@Value("${apiheader.referenceno}")
	private String referenceno;
	@Value("${apiheader.outputtype}")
	private String outputtype;
	@Value("${apiheader.Location}")
	private String Location;
	@Value("${apiheader.ShipDisp}")
	private String ShipDisp;

	@Value("${apiheader.ewb_response_request}")
	private String ewb_response_request;
	@Value("${apiheader.ewb_generate_request}")
	private String ewb_generate_request;
	@Value("${apiheader.ewb_cancel_request}")
	private String ewb_cancel_request;

	@Value("${apiheader.irn_response_request}")
	private String irn_response_request;
	@Value("${apiheader.irn_generate_request}")
	private String irn_generate_request;
	@Value("${apiheader.irn_cancel_request}")
	private String irn_cancel_request;

	// apiheader.Ocp-Apim-Subscription-Key= d2443b75a2ad49b6880c2a94d3678369
	// apiheader.Gstin= gstinNumber
	// apiheader.sourcetype= ERP
	// apiheader.referenceno= WEP001
	// apiheader.outputtype= JSON
	// apiheader.Location= BNG
	// apiheader.SignedValue= N

	// @Scheduled(cron = "* 0 0 8-10 * *")
	@Scheduled(fixedDelayString = "${scheduled.cron.delay}", initialDelay = 1000)
	public void getData() {

		getGstInvoiceResponse("");
		getIRNCancelPostGstApiResponse("");
		// generateEwayBillByIRn("");
		// cancelEwayBillByIRn("");

	}

	/**
	 * 
	 */
	public void getGstInvoiceResponse(String docNumber) {
		System.out.println("sample json");

		String orgNumber = "";
		String invType = "";
//inv_no1:83:'INV'
		if (docNumber.contains(":")) {
			String s[] = docNumber.split(":");
			docNumber = s[0];
			orgNumber = s[1];
			invType = s[2];

		}

		List<GstInvoiceEntity> listEntity = null;
		try {
			if (docNumber.equalsIgnoreCase("")) {
				listEntity = getGstData();
			} else {
				listEntity = getGstData(docNumber);
			}

			if (listEntity != null && listEntity.size() > 0) {

				String jsonData = "";

				jsonData = gstinvoiceApplicationController.gsonOutPut(docNumber, orgNumber);

				// listEntity.get(0).setIRNSTATUS("I");

				String gstinNumber = listEntity.get(0).getSELLERDTLS_GSTIN();
				// String gstinNumber = "29AAACD5108M000";
				// updateGstHeaderTable(listEntity.get(0));
				String irnResponse = getPostGstApiResponse(jsonData, gstinNumber, listEntity);
				listEntity.get(0).setIRP_RESPONSIE(irnResponse.getBytes());

				Gson gson = new Gson();
				GstInvoiceOutPutResponse organisation = null;

				organisation = extractedJson(irnResponse, gson);
				System.out.println("irnResponse : " + organisation);
				if (null != organisation) {

					if (organisation.getOutputResponse().getStatus().equalsIgnoreCase("ACT")) {
						listEntity.get(0).setIRNSTATUS("P");
						extractedIrnStatus(listEntity, organisation);

						if (!invType.equalsIgnoreCase("STN") && !invType.equalsIgnoreCase("CONSINV")) {
							// raCustomerSave(listEntity, organisation);
							// gstInvoiceRACustomerTransactionRepo.save(gstInvoiceRACustomerTransaction);
						} else if (invType.equalsIgnoreCase("STN")) {
							/*
							 * mtlCustomerSave(listEntity, organisation);
							 * gstInvoiceMTLMaterialTransactionRepo.updateAttributes(
							 * gstInvoiceMTLMaterialTrEntity.getAttribute11(),gstInvoiceMTLMaterialTrEntity.
							 * getAttribute12(),
							 * gstInvoiceMTLMaterialTrEntity.getAttribute13(),gstInvoiceMTLMaterialTrEntity.
							 * getAttribute14(),gstInvoiceMTLMaterialTrEntity.getAttribute15()
							 * ,gstInvoiceMTLMaterialTrEntity.getOrg_id(),gstInvoiceMTLMaterialTrEntity.
							 * getTrx_number());
							 */
						} else if (invType.equalsIgnoreCase("CONSINV")) {
							/// wEPISSummarySave(listEntity, organisation);
							/*
							 * gstInvoiceWEPISSummaryRepo.updateAttributes(gstInvoiceWEPISSummaryEntity.
							 * getATTRIBUTE1(),gstInvoiceWEPISSummaryEntity.getATTRIBUTE2(),
							 * gstInvoiceWEPISSummaryEntity.getATTRIBUTE3(),gstInvoiceWEPISSummaryEntity.
							 * getATTRIBUTE4(),gstInvoiceWEPISSummaryEntity.getATTRIBUTE5()
							 * ,gstInvoiceWEPISSummaryEntity.getCUS_SEQ());
							 */
						}

					} else {
						if (organisation.getOutputResponse().getErrorDetails() instanceof ArrayList) {

							ArrayList li = (ArrayList) organisation.getOutputResponse().getErrorDetails();
							boolean flag = false;
							for (Object ooo : li) {

								if (ooo.toString().contains("ErrorMessage=Duplicate IRN")) {
									flag = true;
									listEntity.get(0).setIRNSTATUS("P");
									for (GstInvoiceOutPutResponseJsonInfo desc : organisation.getOutputResponse()
											.getInfoDtls()) {
										organisation.getOutputResponse().setIrn(desc.getDesc().getIrn());
										generateQRCodeImage(listEntity, gstinNumber, gson, organisation);
										String response = getQrCodeFromIRN(gstinNumber,
												organisation.getOutputResponse().getIrn(), "Y");

										// response=getGetIRNResponse("b9e0bfd366a2c06acbeb2c039705bf3595db5e5b6516a559b8e290f7ce03dcfe",
										// gstinNumber);
										response = response.replaceAll("\"InfoDtls\":\"\"", "\"InfoDtls\":null");
										organisation = extractedJson(response, gson);
										extractedIrnStatus(listEntity, organisation);
										// raCustomerSave(listEntity, organisation);
										// gstInvoiceRACustomerTransactionRepo.save(gstInvoiceRACustomerTransaction);
									}
								}

							}

							if (!flag) {
								listEntity.get(0).setIRNSTATUS("E");
								listEntity.get(0).setERROR_MESSAGE("Please refer the IRP_RESPONSE field");
							}

						} else {
							listEntity.get(0).setIRNSTATUS("E");
							listEntity.get(0).setERROR_MESSAGE("Please refer the IRP_RESPONSE field");
						}

					}

					if (organisation.getOutputResponse().getEwbNo() != null
							&& organisation.getOutputResponse().getEwbNo().length() > 1) {
						listEntity.get(0).setEWBSTATUS("P");
					}

					listEntity.get(0).setEWB_NO(organisation.getOutputResponse().getEwbNo());
					listEntity.get(0).setEWB_DATE(organisation.getOutputResponse().getEwbDt());
					listEntity.get(0).setEWB_VALID_TILL(organisation.getOutputResponse().getEwbValidTill());
					// String gstinNumber=listEntity.get(0).getSELLERDTLS_GSTIN();
					String response = "";
					if (organisation.getOutputResponse().getIrn() != null
							&& organisation.getOutputResponse().getIrn().length() > 0) {
						generateQRCodeImage(listEntity, gstinNumber, gson, organisation);

					} else {
						// generateQRCodeImage(listEntity, gstinNumber, gson, organisation);
					}

					updateGstHeaderTable(listEntity.get(0));
				} else {
					if (irnResponse.contains("\"Status\":\"ACT\"")) {

						System.out.println("Succuss with error message ");
						listEntity.get(0).setIRNSTATUS("P");
						listEntity.get(0).setERROR_MESSAGE("Succuss with error message pls refer error response");
						updateGstHeaderTable(listEntity.get(0));

					} else {
						listEntity.get(0).setIRNSTATUS("E");
						listEntity.get(0).setERROR_MESSAGE("Please refer the IRP_RESPONSE field");
						updateGstHeaderTable(listEntity.get(0));
					}
				}

			} else {
				System.out.println("No records to process any IRN number generation");
			}
		} catch (Exception e) {
			if (!e.getMessage().contains("SSLHandshakeException")) {
				if (null != listEntity && listEntity.size() > 0) {
					// listEntity = getGstData();
					listEntity.get(0).setIRNSTATUS("E");
					listEntity.get(0).setERROR_MESSAGE("Please refer the IRP_RESP");
					listEntity.get(0).setIRP_RESPONSIE(e.getMessage().getBytes());
					updateGstHeaderTable(listEntity.get(0));
				} else {
					listEntity = getGstData();
					listEntity.get(0).setIRNSTATUS("E");
					listEntity.get(0).setERROR_MESSAGE("Please refer the IRP_RESP");
					listEntity.get(0).setIRP_RESPONSIE(e.getMessage().getBytes());
					updateGstHeaderTable(listEntity.get(0));
				}
			}

			e.printStackTrace();
		}
	}

	public void updateGstHeaderTable(GstInvoiceEntity gstInvoiceEntity) {
		// @Param("IRNSTATUS") String IRNSTATUS, @Param("ERRORMSG") String ERRORMSG,
		/// @Param("IRPREQUEST") byte[] IRPREQUEST, @Param("IRNNUMBER") String
		// IRNNUMBER,
		// @Param("ACKDATE") String ACKDATE, @Param("ACKNO") String ACKNO,
		// @Param("IRPRESPONSE") byte[] IRPRESPONSE,@Param("INVOICENUMNEW"
		gstinvoiceApplicationRepo.updateAttributesHeaderTable(gstInvoiceEntity.getIRNSTATUS(),
				gstInvoiceEntity.getERROR_MESSAGE(), gstInvoiceEntity.getIRP_REQUEST(),
				gstInvoiceEntity.getIRN_NUMBER(), gstInvoiceEntity.getACK_DATE(), gstInvoiceEntity.getACKNO(),
				gstInvoiceEntity.getIRP_RESPONSIE(), gstInvoiceEntity.getQR_CODE(),
				gstInvoiceEntity.getQR_IMAGE_FILE_NAME(), gstInvoiceEntity.getDOCDTLS());// dOCDTLS

	}

	public void cancelIrn(GstInvoiceEntity gstInvoiceEntity) {
		//@Param("IRNSTATUS") String IRNSTATUS, @Param("ERRORMSG") String ERRORMSG,
		///@Param("IRPREQUEST") byte[] IRPREQUEST, @Param("IRNNUMBER") String IRNNUMBER,
		//@Param("ACKDATE") String ACKDATE, @Param("ACKNO") String ACKNO,
		//@Param("IRPRESPONSE") byte[] IRPRESPONSE,@Param("INVOICENUMNEW"
		gstinvoiceApplicationRepo.cancelIrnNumber(gstInvoiceEntity.getIRNSTATUS(), 
				gstInvoiceEntity.getCANCELIRNSTATUS(), gstInvoiceEntity.getCANCEL_IRN_REQUEST(), gstInvoiceEntity.getCANCEL_IRN_RESPONSE(), gstInvoiceEntity.getCANCEL_DATE()
				,gstInvoiceEntity.getDOCDTLS());//dOCDTLS
		
		
	}

	private GstInvoiceOutPutResponse extractedJson(String irnResponse, Gson gson) {
		GstInvoiceOutPutResponse organisation = null;
		try {
			irnResponse = irnResponse.replaceAll("\"InfoDtls\":\"\"", "\"InfoDtls\":null");

			if (irnResponse.contains("\"Status\":\"ACT\"")) {

				if (irnResponse.contains("\"InfoDtls\"")) {
					irnResponse = irnResponse.substring(0, irnResponse.lastIndexOf(",\"InfoDtls\":")) + "}}";

				}
			}
			organisation = gson.fromJson(irnResponse, GstInvoiceOutPutResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return organisation;
	}

	private void raCustomerSave(List<GstInvoiceEntity> listEntity, GstInvoiceOutPutResponse organisation) {
		gstInvoiceRACustomerTransaction.setAttribute12(organisation.getOutputResponse().getIrn());
		gstInvoiceRACustomerTransaction.setAttribute13(organisation.getOutputResponse().getAckNo());
		gstInvoiceRACustomerTransaction.setAttribute14(organisation.getOutputResponse().getAckDt());
		gstInvoiceRACustomerTransaction.setAttribute15(listEntity.get(0).getDOCDTLS() + ".png");
		gstInvoiceRACustomerTransaction.setTrx_number(listEntity.get(0).getDOCDTLS());
		gstInvoiceRACustomerTransaction.setOrg_id(listEntity.get(0).getOrganizationId());
	}

	private void mtlCustomerSave(List<GstInvoiceEntity> listEntity, GstInvoiceOutPutResponse organisation) {
		gstInvoiceMTLMaterialTrEntity.setAttribute12(organisation.getOutputResponse().getIrn());
		gstInvoiceMTLMaterialTrEntity.setAttribute13(organisation.getOutputResponse().getAckNo());
		gstInvoiceMTLMaterialTrEntity.setAttribute14(organisation.getOutputResponse().getAckDt());
		gstInvoiceMTLMaterialTrEntity.setAttribute15(listEntity.get(0).getDOCDTLS() + ".png");
		gstInvoiceMTLMaterialTrEntity.setTrx_number(listEntity.get(0).getDOCDTLS());
		gstInvoiceMTLMaterialTrEntity.setOrg_id(listEntity.get(0).getOrganizationId());
	}

	private void wEPISSummarySave(List<GstInvoiceEntity> listEntity, GstInvoiceOutPutResponse organisation) {
		gstInvoiceWEPISSummaryEntity.setATTRIBUTE2(organisation.getOutputResponse().getIrn());
		gstInvoiceWEPISSummaryEntity.setATTRIBUTE3(organisation.getOutputResponse().getAckNo());
		gstInvoiceWEPISSummaryEntity.setATTRIBUTE4(organisation.getOutputResponse().getAckDt());
		gstInvoiceWEPISSummaryEntity.setATTRIBUTE5(listEntity.get(0).getDOCDTLS() + ".png");
		gstInvoiceWEPISSummaryEntity.setCUS_SEQ(listEntity.get(0).getDOCDTLS());
	}

	private void extractedIrnStatus(List<GstInvoiceEntity> listEntity, GstInvoiceOutPutResponse organisation) {
		listEntity.get(0).setIRN_NUMBER(organisation.getOutputResponse().getIrn());
		listEntity.get(0).setACK_DATE(organisation.getOutputResponse().getAckDt());
		listEntity.get(0).setACKNO(organisation.getOutputResponse().getAckNo());
		listEntity.get(0).setQR_CODE(organisation.getOutputResponse().getSignedQRCode());

	}

	private void generateQRCodeImage(List<GstInvoiceEntity> listEntity, String gstinNumber, Gson gson,
			GstInvoiceOutPutResponse organisation) {

		int size = organisation.getOutputResponse().getSignedQRCode() != null
				? organisation.getOutputResponse().getSignedQRCode().length()
				: 0;
		if (size == 0) {
			String response = getQrCodeFromIRN(gstinNumber, organisation.getOutputResponse().getIrn(), "N");
			response = response.replaceAll("\"InfoDtls\":\"\"", "\"InfoDtls\":null");
			organisation = extractedJson(response, gson);
			System.out.println("irnResponse : " + organisation);
		}
		String filePath = filepath + listEntity.get(0).getTRX_ID() + ".gif";
		size = organisation.getOutputResponse().getSignedQRCode() != null
				? organisation.getOutputResponse().getSignedQRCode().length()
				: 0;
		if (size != 0) {
			String fileType = "gif";
			File qrFile = new File(filePath);
			try {

				GstInvoiceQRCodeGenaratorService.createQRImage(qrFile,
						organisation.getOutputResponse().getSignedQRCode(), size, fileType);
				listEntity.get(0).setQR_IMAGE_PATH(listEntity.get(0).getTRX_ID() + ".gif");
				listEntity.get(0).setQR_IMAGE_FILE_NAME(listEntity.get(0).getTRX_ID() + ".gif");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param gstinNumber
	 * @param organisation
	 * @return
	 */
	public String getQrCodeFromIRN(String gstinNumber, String irn, String signedValue) {
		String response;
		response = getGetIRNResponse(irn, gstinNumber, signedValue);
		return response;
	}

	public String getQrCodeFromIRN(String gstinNumber, String irn, String signedValue, String org_id) {
		String response;
		response = getGetIRNResponse(irn, gstinNumber, signedValue);
		return response;
	}

	public String getPostResponse() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8990/gst/invoice", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	public String getEWBResponse(String irn, String gstinNumber) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);//
		headers.add("sourcetype", sourcetype);// ERP
		headers.add("referenceno", referenceno);// WEP001
		headers.add("outputtype", outputtype);
		headers.add("Location", Location);// BNG
		headers.add("Gstin", gstinNumber);// BNG

		// headers.add("SignedValue", signedvalue);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);// https://api.wepgst.com/asp/sa/Einvoice/v1.03/GenerateIRN
		return restTemplate.exchange(ewb_response_request + irn, HttpMethod.GET, entity, String.class).getBody();
	}

	public String getGetIRNResponse(String irn, String gstinNumber, String signedvalue) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);//
		headers.add("sourcetype", sourcetype);// ERP
		headers.add("referenceno", referenceno);// WEP001
		headers.add("outputtype", outputtype);
		headers.add("Location", Location);// BNG
		headers.add("SignedValue", "N");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);// https://api.wepgst.com/asp/sa/Einvoice/v1.03/GenerateIRN
		return restTemplate.exchange(irn_response_request + irn, HttpMethod.GET, entity, String.class).getBody();
	}

	public String generateEwayBillByIRn(String docNumber) {
		List<GstInvoiceEWBEntity> listEntity = null;
		String response = "";
		try {
			listEntity = getGstDataEWBIrn();

			if (listEntity.size() > 0) {
				GstInvoiceEWBEntity gstInvoiceEWBEntity = listEntity.get(0);

				GstInvoiceEntity gstInvoiceEntity = getGstData(gstInvoiceEWBEntity.getDOCNO()).get(0);

				System.out.println("gstInvoiceEntity::::::::::::::::::" + gstInvoiceEntity);
				System.out.println("gstInvoiceEWBEntity::::::::::::::::::" + gstInvoiceEWBEntity);
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				headers.add("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
				headers.add("Gstin", gstInvoiceEntity.getSELLERDTLS_GSTIN());
				headers.add("sourcetype", sourcetype);
				headers.add("referenceno", referenceno);
				headers.add("outputtype", outputtype);
				headers.add("Location", Location);
				headers.add("ShipDisp", ShipDisp);
				Map<String, GstInvoiceOutPutResponseJson> hashtt = new HashMap<String, GstInvoiceOutPutResponseJson>();
				headers.setContentType(MediaType.APPLICATION_JSON);

				GstinvoiceApplicationEntityEWB gstinvoiceApplicationEntityEWB = new GstinvoiceApplicationEntityEWB();

				gstinvoiceApplicationEntityEWB.setIrn(gstInvoiceEntity.getIRN_NUMBER());

				gstinvoiceApplicationEntityEWB.setTransId(gstInvoiceEWBEntity.getEWBDTLS_TRANSID());
				gstinvoiceApplicationEntityEWB.setTransName(gstInvoiceEWBEntity.getEWBDTLS_TRANSNAME());
				gstinvoiceApplicationEntityEWB.setTransMode(gstInvoiceEWBEntity.getEWBDTLS_TRANSMODE());
				gstinvoiceApplicationEntityEWB
						.setDistance(new BigDecimal(gstInvoiceEWBEntity.getEWBDTLS_DISTANCE() != null
								&& gstInvoiceEWBEntity.getEWBDTLS_DISTANCE().length() > 0
										? gstInvoiceEWBEntity.getEWBDTLS_DISTANCE()
										: "0"));
				gstinvoiceApplicationEntityEWB.setTransDocNo(gstInvoiceEWBEntity.getEWBDTLS_TRANSDOCNO());
				gstinvoiceApplicationEntityEWB.setTransDocNo(gstInvoiceEWBEntity.getEWBDTLS_TRANSDOCNO());
				String ds2 = "";
				ds2 = gstInvoiceEWBEntity.getEWBDTLS_TRANSDOCDT() != null
						? new SimpleDateFormat("dd/MM/yyyy").format(gstInvoiceEWBEntity.getEWBDTLS_TRANSDOCDT())
						: null;// dd/mm/yyyy
				System.out.println("EWB Date formate:::::+ds2" + ds2);
				gstinvoiceApplicationEntityEWB.setTransDocDt(ds2);
				gstinvoiceApplicationEntityEWB.setVehNo(gstInvoiceEWBEntity.getEWBDTLS_VEHNO());
				gstinvoiceApplicationEntityEWB.setVehType(gstInvoiceEWBEntity.getEWBDTLS_VEHTYPE());

				GstInvoiceShipmentDetailsEWB ExpShipDtls = new GstInvoiceShipmentDetailsEWB();
				ExpShipDtls.setAddr1(gstInvoiceEWBEntity.getExpShipAddr1());
				ExpShipDtls.setAddr2(gstInvoiceEWBEntity.getExpShipAddr2());
				ExpShipDtls.setLoc(gstInvoiceEWBEntity.getExpShipLoc());
				ExpShipDtls.setPin(new BigDecimal(
						gstInvoiceEWBEntity.getExpShipPin() != null && gstInvoiceEWBEntity.getExpShipPin().length() > 0
								? gstInvoiceEWBEntity.getExpShipPin()
								: "0"));
				ExpShipDtls.setStcd(gstInvoiceEWBEntity.getExpShipStcd());
				gstinvoiceApplicationEntityEWB.setExpShipDtls(ExpShipDtls);
				GstInvoiceDistributerEWB DispDtls = new GstInvoiceDistributerEWB();
				DispDtls.setStcd(gstInvoiceEWBEntity.getDispStcd());
				DispDtls.setPin(new BigDecimal(
						gstInvoiceEWBEntity.getDispPin() != null && gstInvoiceEWBEntity.getDispPin().length() > 0
								? gstInvoiceEWBEntity.getDispPin()
								: "0"));
				DispDtls.setNm(gstInvoiceEWBEntity.getDispNm());
				DispDtls.setLoc(gstInvoiceEWBEntity.getDispLoc());
				DispDtls.setAddr1(gstInvoiceEWBEntity.getDispAddr1());
				DispDtls.setAddr2(gstInvoiceEWBEntity.getDispAddr2());

				gstinvoiceApplicationEntityEWB.setDispDtls(DispDtls);
				// GstInvoiceIrnCancel gstInvoiceIrnCancel = new GstInvoiceIrnCancel();
				HttpEntity<String> entity = new HttpEntity<String>(new Gson().toJson(gstinvoiceApplicationEntityEWB),
						headers);

				RestTemplate restTemplate = new RestTemplate();

				response = restTemplate.postForObject(ewb_generate_request, entity, String.class);

				GstInvoiceOutPutResponseJsonEWB stInvoiceewb = new Gson().fromJson(response,
						GstInvoiceOutPutResponseJsonEWB.class);
				listEntity.get(0).setEWB_REQUEST(entity.toString().getBytes());
				listEntity.get(0).setEWB_RESPONSE(response.getBytes());
				if (stInvoiceewb.getOutputResponse().getStatus() != null
						&& stInvoiceewb.getOutputResponse().getStatus().equalsIgnoreCase("1")) {
					gstInvoiceEWBEntity.setEWBSTATUS("P");
					listEntity.get(0).setEWB_NO(stInvoiceewb.getOutputResponse().getEwbNo());
					listEntity.get(0).setEWB_DATE(stInvoiceewb.getOutputResponse().getEwbDt());
					listEntity.get(0).setEWB_VALID_TILL(stInvoiceewb.getOutputResponse().getEwbValidTill());
					gstInvoiceEWBEntity.setPROCESS_STATUS("P");
					if (stInvoiceewb.getOutputResponse().getInfoDtls() instanceof ArrayList) {
						ArrayList li = (ArrayList) stInvoiceewb.getOutputResponse().getInfoDtls();
						if (li.size() > 0) {
							for (Object str : li) {

								if (str.toString().contains("Desc=Pin-")) {
									String distance = str.toString().split(",")[1];
									distance = distance.replaceAll("Desc=Pin-Pin calc distance:", "")
											.replaceAll("KM", "").replaceAll("}", "");

									listEntity.get(0).setEWBDTLS_DISTANCE(distance.trim());

								}

								// Desc=Pin-Pin calc distance: 1493KM

							}
						}

					}

				} else {
					boolean flag = false;
					if (stInvoiceewb.getOutputResponse().getErrorDetails() instanceof ArrayList) {

						ArrayList li = (ArrayList) stInvoiceewb.getOutputResponse().getErrorDetails();

						for (Object ooo : li) {

							if (ooo.toString().contains("ErrorMessage=EwayBill is already generated for this IRN")) {
								flag = true;
								String response1 = getEWBResponse(gstInvoiceEntity.getIRN_NUMBER(),
										gstInvoiceEntity.getSELLERDTLS_GSTIN());
								stInvoiceewb = new Gson().fromJson(response1, GstInvoiceOutPutResponseJsonEWB.class);
								if (stInvoiceewb.getOutputResponse().getStatus() != null
										&& stInvoiceewb.getOutputResponse().getStatus().equalsIgnoreCase("ACT")) {
									gstInvoiceEWBEntity.setEWBSTATUS("P");
									listEntity.get(0).setEWB_NO(stInvoiceewb.getOutputResponse().getEwbNo());
									listEntity.get(0).setEWB_DATE(stInvoiceewb.getOutputResponse().getEwbDt());
									listEntity.get(0)
											.setEWB_VALID_TILL(stInvoiceewb.getOutputResponse().getEwbValidTill());
									gstInvoiceEWBEntity.setPROCESS_STATUS("P");
								}
							}

						}
					}

					// private Object ErrorDetails;
					if (!flag) {
						gstInvoiceEWBEntity.setEWBSTATUS("E");
						gstInvoiceEWBEntity.setPROCESS_STATUS("E");
					}
				}

				System.out.println("gstInvoiceEntity::::::::::::::::::" + listEntity.get(0));

				gstinvoiceEWBApplicationRepo.save(listEntity);
			} else {
				System.out.println("::::no records for ewb generation:::::");
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() != null) {
				if (!e.getMessage().contains("SSLHandshakeException")) {
					if (null != listEntity && listEntity.size() > 0) {
						listEntity.get(0).setEWBSTATUS("E");
						listEntity.get(0).setPROCESS_STATUS("E");
						listEntity.get(0).setERROR_MESSAGE("Please refer the EWB_RESP");
						listEntity.get(0).setEWB_RESPONSE(e.getMessage().getBytes());
						gstinvoiceEWBApplicationRepo.saveAndFlush(listEntity.get(0));
					} else {
						listEntity = getGstDataEWBIrn();//
						listEntity.get(0).setEWBSTATUS("E");
						listEntity.get(0).setPROCESS_STATUS("E");
						listEntity.get(0).setERROR_MESSAGE("Please refer the EWB_RESP");
						listEntity.get(0).setEWB_RESPONSE(e.getMessage().getBytes());
						gstinvoiceEWBApplicationRepo.saveAndFlush(listEntity.get(0));
					}
				}
			} else {
				if (null != listEntity && listEntity.size() > 0) {
					listEntity.get(0).setEWBSTATUS("E");
					listEntity.get(0).setPROCESS_STATUS("E");
					listEntity.get(0).setERROR_MESSAGE("Please refer the EWB_RESP");
					listEntity.get(0).setEWB_RESPONSE("Exception ".getBytes());
					gstinvoiceEWBApplicationRepo.saveAndFlush(listEntity.get(0));
				} else {
					listEntity = getGstDataEWBIrn();//
					listEntity.get(0).setEWBSTATUS("E");
					listEntity.get(0).setPROCESS_STATUS("E");
					listEntity.get(0).setERROR_MESSAGE("Please refer the EWB_RESP");
					listEntity.get(0).setEWB_RESPONSE("Exception ".getBytes());
					gstinvoiceEWBApplicationRepo.saveAndFlush(listEntity.get(0));
				}
			}

		}
		return response;

	}

	@SuppressWarnings("deprecation")
	public String cancelEwayBillByIRn(String docNumber) {

		// CANCEL_FLAG = 'N' after success full P, in case error E

		// update CANCEL_DATE in table XX_GST_EWB_HDR_TBL
		String response = "";
		List<GstInvoiceEWBEntity> listEntity = null;
		try {
			listEntity = getGstDataEWBIrnCancel();
			if (listEntity.size() > 0) {
				GstInvoiceEWBEntity gstInvoiceEWBEntity = listEntity.get(0);

				gstInvoiceEwbCancel.setEwbNo(gstInvoiceEWBEntity.getEWB_NO());

				gstInvoiceEwbCancel.setCancelRsnCode(gstInvoiceEWBEntity.getCANCEL_CODE());
				gstInvoiceEwbCancel.setCancelRmrk(gstInvoiceEWBEntity.getCANCEL_REMARK());
				GstInvoiceEntity gstInvoiceEntity = getGstData(gstInvoiceEWBEntity.getDOCNO()).get(0);
				String requestJson = new Gson().toJson(gstInvoiceEwbCancel);
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				headers.add("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
				headers.add("Gstin", gstInvoiceEntity.getSELLERDTLS_GSTIN());
				headers.add("sourcetype", sourcetype);
				headers.add("referenceno", referenceno);
				headers.add("outputtype", outputtype);
				headers.add("Location", Location);
				headers.add("SignedValue", "Y");
				headers.add("ValueDetails", "Y");
				Map<String, GstInvoiceOutPutResponseJson> hashtt = new HashMap<String, GstInvoiceOutPutResponseJson>();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

				RestTemplate restTemplate = new RestTemplate();

				response = restTemplate.postForObject(ewb_cancel_request, entity, String.class);
				listEntity.get(0).setCANCEL_EWB_REQ(entity.toString().getBytes());
				listEntity.get(0).setCANCEL_EWB_RESP(response.getBytes());
				GstInvoiceEwbCancelResponse stInvoiceIrnCancel = new Gson().fromJson(response,
						GstInvoiceEwbCancelResponse.class);

				if (stInvoiceIrnCancel.getOutputResponse().getEwayBillNo() != null && stInvoiceIrnCancel
						.getOutputResponse().getEwayBillNo().equalsIgnoreCase(gstInvoiceEWBEntity.getEWB_NO())) {
					gstInvoiceEWBEntity.setEWBSTATUS("C");
					gstInvoiceEWBEntity.setCANCELFLAG("C");
					gstInvoiceEWBEntity.setPROCESS_STATUS("C");
					gstInvoiceEWBEntity.setCANCEL_DATED(new Date());
					// FOR IRN CANCELLATION: CANCEL_DATE IN TABLE : XX_GST_EINV_HDR_TBL
					// FOR EWB CANCELLATION: CANCEL_DATE,CANCEL_EWB_REQ,CANCEL_EWB_RESP IN TABLE :
					// XX_GST_EWB_HDR_TBL
				} else {

					boolean flag = false;
					if (stInvoiceIrnCancel.getOutputResponse().getErrorDetails() instanceof ArrayList) {

						ArrayList li = (ArrayList) stInvoiceIrnCancel.getOutputResponse().getErrorDetails();

						for (Object ooo : li) {

							if (ooo.toString().contains("ErrorMessage=Authentication Error")) {
								flag = true;

							}

						}
					}
					if (!flag) {
						gstInvoiceEWBEntity.setCANCELFLAG("E");
					}
					// gstInvoiceEWBEntity.setEWBSTATUS("E");

				}

				gstinvoiceEWBApplicationRepo.save(listEntity);
			} else {
				System.out.println("::::no records for ewb cancelation:::::");
			}
		} catch (Exception e) {
			if (!e.getMessage().contains("SSLHandshakeException")) {
				if (null != listEntity && listEntity.size() > 0) {
					listEntity.get(0).setCANCELFLAG("E");
					listEntity.get(0).setERROR_MESSAGE("Please refer the IRP_RESP");
					listEntity.get(0).setCANCEL_EWB_RESP(e.getMessage().getBytes());
					gstinvoiceEWBApplicationRepo.saveAndFlush(listEntity.get(0));
				} else {
					listEntity = getGstDataEWBIrnCancel();
					listEntity.get(0).setCANCELFLAG("E");
					listEntity.get(0).setERROR_MESSAGE("Please refer the IRP_RESP");
					listEntity.get(0).setCANCEL_EWB_RESP(e.getMessage().getBytes());
					gstinvoiceEWBApplicationRepo.saveAndFlush(listEntity.get(0));
				}
				e.printStackTrace();
			}
		}
		return response;
	}

	public String getGetGstNumberResponse(String senderGstNumber, String gstinNumber) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
		headers.add("Gstin", gstinNumber);
		headers.add("sourcetype", sourcetype);
		headers.add("referenceno", referenceno);
		headers.add("outputtype", outputtype);
		headers.add("Location", Location);
		headers.add("SignedValue", "N");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("https://api.wepgst.com/asp/sa/Einvoice/v1.03/GetGstin?GSTIN=" + senderGstNumber,
				HttpMethod.GET, entity, String.class).getBody();
	}

	@SuppressWarnings("unchecked")
	public String getPostGstApiResponse(String String, String gstinNumber, List<GstInvoiceEntity> listEntity) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
		headers.add("Gstin", gstinNumber);
		headers.add("sourcetype", sourcetype);
		headers.add("referenceno", referenceno);
		headers.add("outputtype", outputtype);
		headers.add("Location", Location);
		headers.add("SignedValue", "N");
		headers.add("ValueDetails", "Y");
		Map<String, GstInvoiceOutPutResponseJson> hashtt = new HashMap<String, GstInvoiceOutPutResponseJson>();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(String, headers);

		RestTemplate restTemplate = new RestTemplate();
		listEntity.get(0).setIRP_REQUEST(entity.toString().getBytes());
		return restTemplate.postForObject(irn_generate_request, entity, String.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public String getIRNCancelPostGstApiResponse(String docNumber) {
		// irncancel:10040166:2:Cancelled the order

		// "CnlRsn":"1 ",
		// "CnlRem":"Wrong entry"
		List<GstInvoiceEntity> listEntity = null;
		String response = "";
		try {

			String sss[] = docNumber.split(":");

			if (docNumber.equalsIgnoreCase("")) {
				listEntity = getGstDataCancelIrn();
				gstInvoiceIrnCancel.setCnlRsn("1");
				gstInvoiceIrnCancel.setCnlRem("Wrong entry");
			} else {

				listEntity = getGstData(sss[1]);
				gstInvoiceIrnCancel.setCnlRsn(sss[2]);
				gstInvoiceIrnCancel.setCnlRem(sss[3]);
			}

			if (listEntity != null && listEntity.size() > 0) {
				GstInvoiceEntity gstInvoiceEntity = listEntity.get(0);
				gstInvoiceIrnCancel
						.setCnlRsn(gstInvoiceEntity.getCANCEL_CODE() != null ? gstInvoiceEntity.getCANCEL_CODE() : "2");
				gstInvoiceIrnCancel
						.setCnlRem(gstInvoiceEntity.getCANCEL_REASON() != null ? gstInvoiceEntity.getCANCEL_REASON()
								: "Wrong entry");
				gstInvoiceIrnCancel.setIrn(gstInvoiceEntity.getIRN_NUMBER());

				String requestJson = new Gson().toJson(gstInvoiceIrnCancel);

				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				headers.add("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
				headers.add("Gstin", gstInvoiceEntity.getSELLERDTLS_GSTIN());
				headers.add("sourcetype", sourcetype);
				headers.add("referenceno", referenceno);
				headers.add("outputtype", outputtype);
				headers.add("Location", Location);

				Map<String, GstInvoiceOutPutResponseJson> hashtt = new HashMap<String, GstInvoiceOutPutResponseJson>();
				headers.setContentType(MediaType.APPLICATION_JSON);

				HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

				RestTemplate restTemplate = new RestTemplate();

				response = restTemplate.postForObject(irn_cancel_request, entity, String.class);

				GstInvoiceIrnCancelResp stInvoiceIrnCancel = new Gson().fromJson(response,
						GstInvoiceIrnCancelResp.class);

				if (stInvoiceIrnCancel.getOutputResponse().getIrn() != null && stInvoiceIrnCancel.getOutputResponse()
						.getIrn().equalsIgnoreCase(gstInvoiceEntity.getIRN_NUMBER())) {
					gstInvoiceEntity.setCANCELIRNSTATUS("C");
					gstInvoiceEntity.setIRNSTATUS("C");
					gstInvoiceEntity.setCANCEL_DATE(new Date());// CANCEL_DATE
					// FOR IRN CANCELLATION: CANCEL_DATE IN TABLE : XX_GST_EINV_HDR_TBL
				} else {
					boolean flag = false;
					if (stInvoiceIrnCancel.getOutputResponse().getErrorDetails() instanceof ArrayList) {

						ArrayList li = (ArrayList) stInvoiceIrnCancel.getOutputResponse().getErrorDetails();

						for (Object ooo : li) {

							if (ooo.toString().contains("ErrorMessage=Authentication Error")) {
								flag = true;

							}

						}
					}
					if (!flag) {
						gstInvoiceEntity.setCANCELIRNSTATUS("E");
					}
				}

			gstInvoiceEntity.setCANCEL_IRN_REQUEST(entity.toString().getBytes());
			gstInvoiceEntity.setCANCEL_IRN_RESPONSE(response.getBytes());
			cancelIrn(listEntity.get(0));
		} else {
			System.out.println("No records to process any IRN number cancelation");
		}
		
		}catch (Exception e) {
			if(!e.getMessage().contains("SSLHandshakeException")) {
			if(null!=listEntity&&listEntity.size()>0) {
			//listEntity = getGstData();
			listEntity.get(0).setCANCELIRNSTATUS("E");
			listEntity.get(0).setERROR_MESSAGE("Please check CANCEL_IRN_RESPONSE");
			listEntity.get(0).setCANCEL_IRN_RESPONSE(response.getBytes());
			cancelIrn(listEntity.get(0));
			}else {
				listEntity = getGstDataCancelIrn();//cancel
				listEntity.get(0).setCANCELIRNSTATUS("E");
				listEntity.get(0).setERROR_MESSAGE("Please check CANCEL_IRN_RESPONSE");
				listEntity.get(0).setCANCEL_IRN_RESPONSE(response.getBytes());
				cancelIrn(listEntity.get(0));
			}
			}
		}
				return response;
	}

	public List<GstInvoiceEntity> getGstData() {
		return gstinvoiceApplicationRepo.findByIRNSTATUS("N");
	}

	public List<GstInvoiceEntity> getGstDataCancelIrn() {
		return gstinvoiceApplicationRepo.findByCANCELIRNSTATUS("N");
	}

	public List<GstInvoiceEWBEntity> getGstDataEWBIrn() {
		return gstinvoiceEWBApplicationRepo.findByEWBSTATUS("N");
	}

	public List<GstInvoiceEWBEntity> getGstDataEWBIrnCancel() {
		return gstinvoiceEWBApplicationRepo.findByCANCELFLAG("N");
	}

	public List<GstInvoiceEntity> getGstData(String docNumber) {
		return gstinvoiceApplicationRepo.findByDOCDTLS(docNumber);
	}

	/*
	 * public List<GstInvoiceEntity> getGstData(String docNumber,String orgNumber) {
	 * return
	 * gstinvoiceApplicationRepo.findByDOCDTLSAndOrganizationId(docNumber,orgNumber)
	 * ; }
	 */

	public List<GstInvoiceItemsEntity> getItemData(String docno) {

		return gstinvoiceApplicationItemRepo.findByDOCDTLSNO(docno);
	}
	/*
	 * public List<GstInvoiceItemsEntity> getItemData(String docno,String orgId) {
	 * 
	 * return
	 * gstinvoiceApplicationItemRepo.findByDOCDTLSNOAndOrganizationId(docno,orgId);
	 * }
	 */

	public static void main(String[] args) {

		String str = "{\r\n" + "    \"OutputResponse\": {\r\n" + "        \"Status\": \"0\",\r\n"
				+ "        \"DocNo\": \"200802050005\",\r\n" + "        \"data\": \"\",\r\n"
				+ "        \"ErrorDetails\": \"\",\r\n" + "        \"ErrorRecordsStatus\": \"1\",\r\n"
				+ "        \"ErrorRecords\": [\r\n" + "            {\r\n" + "                \"version\": \"1.1\",\r\n"
				+ "                \"TaxSch\": \"GST\",\r\n" + "                \"SupTyp\": \"B2B\",\r\n"
				+ "                \"RegRev\": \"N\",\r\n" + "                \"IgstOnIntra\": \"N\",\r\n"
				+ "                \"DocTyp\": \"INV\",\r\n" + "                \"DocNo\": \"200802050005\",\r\n"
				+ "                \"DocDt\": \"04/09/2020\",\r\n"
				+ "                \"SGstin\": \"02AAACD5108M1ZZ\",\r\n"
				+ "                \"SLglNm\": \"WeP Solutions Limited\",\r\n"
				+ "                \"STrdNm\": \"WeP Solutions Limited\",\r\n"
				+ "                \"SAddr1\": \"WeP Solutions Limited\",\r\n"
				+ "                \"SAddr2\": \"Plot no-87, Block I,EPIP Phase-1,Jharmajri,\",\r\n"
				+ "                \"SLoc\": \"Baddi,Himachal Pradesh\",\r\n" + "                \"SPin\": 174103,\r\n"
				+ "                \"SStcd\": \"02\",\r\n" + "                \"SPh\": \"18004259494\",\r\n"
				+ "                \"SEm\": \"contactus@wepindia.com\",\r\n"
				+ "                \"BGstin\": \"09BDCPP7082H1Z7\",\r\n"
				+ "                \"BLglNm\": \"SIDDHI VINAYAK ENTERPRISES\",\r\n"
				+ "                \"BTrdNm\": \"SIDDHI VINAYAK ENTERPRISES\",\r\n"
				+ "                \"BAddr1\": \"128 A MANSPURAM COLONY\",\r\n"
				+ "                \"BAddr2\": \"IN FRONT OF JANATA SCHOOL, AZAD CHAUK\",\r\n"
				+ "                \"BLoc\": \"GORAKHPUR,UTTAR PRADESH\",\r\n" + "                \"BPin\": 273016,\r\n"
				+ "                \"BStcd\": \"09\",\r\n" + "                \"BPos\": \"09\",\r\n"
				+ "                \"BPh\": \"9892349898\",\r\n"
				+ "                \"BEm\": \"test273016@gmail.com\",\r\n"
				+ "                \"DisTrdNm\": \"ABC Dispatch Pvt ltd\",\r\n"
				+ "                \"DisAddr1\": \"40/1A Basappa Complex\",\r\n"
				+ "                \"DisAddr2\": \"Lavelle Road\",\r\n"
				+ "                \"DisLoc\": \"Bangalore\",\r\n" + "                \"DisPin\": 560001,\r\n"
				+ "                \"DisStcd\": \"29\",\r\n" + "                \"ShipGstin\": \"09BDCPP7082H1Z7\",\r\n"
				+ "                \"ShipLglNm\": \"SIDDHI VINAYAK ENTERPRISES\",\r\n"
				+ "                \"ShipTrdNm\": \"SIDDHI VINAYAK ENTERPRISES\",\r\n"
				+ "                \"ShipAddr1\": \"SIDDHI VINAYAK ENTERPRISES,19/140 Jadeed Bazar PWD Colony\",\r\n"
				+ "                \"ShipAddr2\": \"Near Mangalam Vatika , Nadesar Varanasi,\",\r\n"
				+ "                \"ShipLoc\": \"VARANASI,UTTAR PRADESH\",\r\n"
				+ "                \"ShipPin\": 221002,\r\n" + "                \"ShipStcd\": \"09\",\r\n"
				+ "                \"SlNo\": \"1\",\r\n"
				+ "                \"PrdDesc\": \"RMFP-417379-Ricoh MP 2014AD Mono A3 MFP\",\r\n"
				+ "                \"IsServc\": \"N\",\r\n" + "                \"HsnCd\": \"8443\",\r\n"
				+ "                \"Qty\": 1.0,\r\n" + "                \"FreeQty\": 0.0,\r\n"
				+ "                \"Unit\": \"No\",\r\n" + "                \"UnitPrice\": 49500.0,\r\n"
				+ "                \"TotAmt\": 49500.0,\r\n" + "                \"Discount\": 0.0,\r\n"
				+ "                \"PreTaxVal\": 49500.0,\r\n" + "                \"AssAmt\": 49500.0,\r\n"
				+ "                \"GstRt\": 18.0,\r\n" + "                \"IgstAmt\": 8910.0,\r\n"
				+ "                \"CgstAmt\": 0.0,\r\n" + "                \"SgstAmt\": 0.0,\r\n"
				+ "                \"CesRt\": 0.0,\r\n" + "                \"CesAmt\": 0.0,\r\n"
				+ "                \"CesNonAdvlAmt\": 0.0,\r\n" + "                \"StateCesRt\": 0.0,\r\n"
				+ "                \"StateCesAmt\": 0.0,\r\n" + "                \"StateCesNonAdvlAmt\": 0.0,\r\n"
				+ "                \"OthChrg\": 0.0,\r\n" + "                \"TotItemVal\": 58410.0,\r\n"
				+ "                \"OrdLineRef\": \"NONE\",\r\n" + "                \"PayCrDay\": 0,\r\n"
				+ "                \"PayPaidAmt\": 0.0,\r\n" + "                \"PayPaymtDue\": 0.0,\r\n"
				+ "                \"RefInvRm\": \"NOT NEEDED\",\r\n"
				+ "                \"InvStDt\": \"01/11/2020\",\r\n"
				+ "                \"InvEndDt\": \"30/11/2020\",\r\n"
				+ "                \"ProjRefr\": \"20082001073\",\r\n"
				+ "                \"PORefr\": \"WMS-512879885\",\r\n" + "                \"ExpDuty\": 0.0,\r\n"
				+ "                \"TransId\": \"27AAACB0446L1ZS\",\r\n"
				+ "                \"TransName\": \"BLUE DART EXPRESS LIMITED\",\r\n"
				+ "                \"TransMode\": \"1\",\r\n" + "                \"Distance\": 4,\r\n"
				+ "                \"TransDocNo\": \"9768\",\r\n"
				+ "                \"TransDocDt\": \"29/11/2020\",\r\n"
				+ "                \"VehNo\": \"KA01AB1234\",\r\n" + "                \"VehType\": \"R\",\r\n"
				+ "                \"TotAssVal\": 49500.0,\r\n" + "                \"TotCgstVal\": 0.0,\r\n"
				+ "                \"TotSgstVal\": 0.0,\r\n" + "                \"TotIgstVal\": 8910.0,\r\n"
				+ "                \"TotCesVal\": 0.0,\r\n" + "                \"TotStCesVal\": 0.0,\r\n"
				+ "                \"TotDiscount\": 0.0,\r\n" + "                \"TotOthChrg\": 0.0,\r\n"
				+ "                \"TotRndOffAmt\": 0.0,\r\n" + "                \"TotInvVal\": 58410.0,\r\n"
				+ "                \"TotInvValFc\": 58410.0,\r\n"
				+ "                \"errormessage\": \"Gstin is not registered\",\r\n"
				+ "                \"errorcode\": \"1\"\r\n" + "            }\r\n" + "        ],\r\n"
				+ "        \"InfoDtls\": \"\"\r\n" + "    }\r\n" + "}";

		Gson gson = new Gson();

		// Converting json to object
		// first parameter should be prpreocessed json
		// and second should be mapping class
		// GstInvoiceOutPutResponse organisation = gson.fromJson(str,
		// GstInvoiceOutPutResponse.class);

		String irnResponse = "{\"OutputResponse\":{\"Status\":\"ACT\",\"AckNo\":\"112110046150929\",\"AckDt\":\"2021-02-04 22:19:00\",\"Irn\":\"128d69475b9ec19d1a54e93f41ada3b0a0d913a3fd4b5f84d7c840979df7b783\",\"Invoice\":{\"Version\":\"1.1\",\"Irn\":\"128d69475b9ec19d1a54e93f41ada3b0a0d913a3fd4b5f84d7c840979df7b783\",\"TranDtls\":{\"TaxSch\":\"GST\",\"SupTyp\":\"B2B\",\"RegRev\":\"Y\",\"IgstOnIntra\":\"N\"},\"DocDtls\":{\"Typ\":\"INV\",\"No\":\"10040723\",\"Dt\":\"31/10/2020\"},\"SellerDtls\":{\"Gstin\":\"29AAACD5108M000\",\"LglNm\":\"ABC company pvt ltd\",\"TrdNm\":\"ABC company pvt ltd\",\"Addr1\":\"BLR TOWERS, ROAD NO:3\",\"Addr2\":\"Address 2 of the supplier\",\"Loc\":\"GANDHINAGAR\",\"Pin\":560002,\"Stcd\":\"29\",\"Ph\":\"9898989898\",\"Em\":\"abc1235@gmail.com\"},\"BuyerDtls\":{\"Gstin\":\"36AAACR4512R1Z2\",\"LglNm\":\"REC LIMITED (HYDERABAD)\",\"TrdNm\":\"REC LIMITED (HYDERABAD)\",\"Pos\":\"36\",\"Addr1\":\"NPA Post, Shivarampally\",\"Addr2\":\"Hyderabad-500052, Telangana\",\"Loc\":\"HYDERABAD,TELANGANA\",\"Pin\":500001,\"Stcd\":\"36\",\"Ph\":\"9892349898\",\"Em\":\"test500001@gmail.com\"},\"DispDtls\":{\"DisTrdNm\":null,\"DisAddr1\":null,\"DisAddr2\":null,\"DisLoc\":null,\"DisPin\":0,\"DisStcd\":null},\"ShipDtls\":{\"ShipGstin\":null,\"ShipLglNm\":null,\"ShipTrdNm\":null,\"ShipLoc\":null,\"ShipAddr1\":null,\"ShipAddr2\":null,\"ShipPin\":0,\"ShipStcd\":null},\"ValDtls\":{\"AssVal\":3000.00,\"CgstVal\":0.00,\"SgstVal\":0.00,\"IgstVal\":540.00,\"CesVal\":0.00,\"StCesVal\":0.00,\"TotInvVal\":3540.0,\"Discount\":0.00,\"OthChrg\":0.00,\"RndOffAmt\":0.00,\"TotInvValFc\":0.0},\"ItemList\":[{\"ItemNo\":0,\"SlNo\":\"1\",\"IsServc\":\"Y\",\"PrdDesc\":\"GST_CLOUD-GST Cloud Subscription:01-NOV-2019:31-OCT-2020:\",\"HsnCd\":\"9973\",\"Qty\":1.0,\"FreeQty\":0.0,\"Unit\":\"OTH\",\"UnitPrice\":3000.0,\"TotAmt\":3000.0,\"Discount\":0.0,\"PreTaxVal\":3000.0,\"AssAmt\":3000.0,\"GstRt\":18.0,\"IgstAmt\":540.0,\"CgstAmt\":0.0,\"SgstAmt\":0.0,\"CesRt\":0.0,\"CesAmt\":0.0,\"CesNonAdvlAmt\":0.0,\"StateCesRt\":0.0,\"StateCesAmt\":0.0,\"StateCesNonAdvlAmt\":0.0,\"OthChrg\":0.0,\"TotItemVal\":3540.0,\"OrdLineRef\":\"NONE\"}],\"EwbDtls\":{\"TransId\":null,\"TransName\":null,\"TransMode\":null,\"Distance\":100,\"TransDocNo\":null,\"TransDocDt\":null,\"VehNo\":null,\"VehType\":null},\"RefDtls\":{\"RefInvRm\":null,\"DocPerdDtls\":{\"InvStDt\":\"01/10/2020\",\"InvEndDt\":\"31/10/2020\"},\"PrecDocDtls\":null,\"ContrDtls\":[{\"ProjRefr\":\"DIGI10191\"}]},\"AckNo\":\"112110046150929\",\"AckDt\":\"2021-02-04 22:19:00\"},\"QRCode\":{\"SellerGstin\":\"29AAACD5108M000\",\"BuyerGstin\":\"36AAACR4512R1Z2\",\"DocNo\":\"10040723\",\"DocTyp\":\"INV\",\"DocDt\":\"31/10/2020\",\"TotInvVal\":3540.0,\"ItemCnt\":1,\"MainHsnCode\":\"9973\",\"Irn\":\"128d69475b9ec19d1a54e93f41ada3b0a0d913a3fd4b5f84d7c840979df7b783\"},\"InfoDtls\":[{\"InfCd\":\"EWBERR\",\"Desc\":[{\"ErrorCode\":\"4019\",\"ErrorMessage\":\"Provide Transporter ID in order to generate Part A of e-Way Bill\"}]}]}}";

		irnResponse = irnResponse.substring(0, irnResponse.lastIndexOf(",\"InfoDtls\":")) + "}}";
//irnResponse=irnResponse.replaceAll("\"InfoDtls\":", "\"InfoDtls\":null");

		System.out.println(irnResponse);

	}

}
