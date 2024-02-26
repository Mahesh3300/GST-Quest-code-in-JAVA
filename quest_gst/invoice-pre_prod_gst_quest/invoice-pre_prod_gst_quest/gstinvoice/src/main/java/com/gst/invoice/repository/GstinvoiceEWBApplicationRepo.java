package com.gst.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gst.invoice.entity.GstInvoiceEWBEntity;
import com.gst.invoice.entity.GstInvoiceEntity;

public interface GstinvoiceEWBApplicationRepo  extends JpaRepository<GstInvoiceEWBEntity, String>{

	
	//List<GstInvoiceEWBEntity> findByIRNSTATUS(String  process);
	//List<GstInvoiceEWBEntity> findByCANCELIRNSTATUS(String  process);
	//List<GstInvoiceEWBEntity> findByDOCDTLS(String  process);
	List<GstInvoiceEWBEntity> findByEWBSTATUS(String  process);
	List<GstInvoiceEWBEntity> findByCANCELFLAG(String  process);
	
	
	//List<GstInvoiceEntity> findByDOCDTLSAndOrganizationId(String  process,String organizationId);
	
	
	
	
}
