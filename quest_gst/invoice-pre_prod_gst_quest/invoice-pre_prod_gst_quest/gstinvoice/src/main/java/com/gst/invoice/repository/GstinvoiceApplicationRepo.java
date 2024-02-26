package com.gst.invoice.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gst.invoice.constant.GstInvoiceEntityConstant;
import com.gst.invoice.entity.GstInvoiceEntity;

public interface GstinvoiceApplicationRepo  extends JpaRepository<GstInvoiceEntity, String>{

	
	List<GstInvoiceEntity> findByIRNSTATUS(String  process);
	List<GstInvoiceEntity> findByCANCELIRNSTATUS(String  process);
	List<GstInvoiceEntity> findByDOCDTLS(String  process);
	//List<GstInvoiceEntity> findByEWBSTATUS(String  process);
	
	//List<GstInvoiceEntity> findByDOCDTLSAndOrganizationId(String  process,String organizationId);
	
	@Transactional
	@Modifying
	@Query(value = GstInvoiceEntityConstant.GST_UPDATE_QUERY , nativeQuery = true)
	public int updateAttributesHeaderTable(@Param("IRNSTATUS") String IRNSTATUS, @Param("ERRORMSG") String ERRORMSG,
			@Param("IRPREQUEST") byte[] IRPREQUEST, @Param("IRNNUMBER") String IRNNUMBER,
			@Param("ACKDATE") String ACKDATE, @Param("ACKNO") String ACKNO,
			@Param("IRPRESPONSE") byte[] IRPRESPONSE,@Param("SIGNEDQRCODE") String SIGNEDQRCODE,@Param("QRCODEFILENAME") String QRCODEFILENAME,@Param("INVOICENUMNEW") String INVOICENUMNEW);
	
			@Transactional
			@Modifying
			@Query(value = GstInvoiceEntityConstant.GST_UPDATE_QUERY_C , nativeQuery = true)
			public int cancelIrnNumber(@Param("IRNSTATUS") String IRNSTATUS, @Param("CANCELIRNSTATUS") String CANCELIRNSTATUS,
					@Param("CANCELIRNREQUEST") byte[] CANCELIRNREQUEST, @Param("CANCELIRNRESPONSE") byte[]  CANCELIRNRESPONSE,
					@Param("CANCEL_DATE") Date CANCEL_DATE, @Param("INVOICENUMNEW") String INVOICENUMNEW);
			
			
}
