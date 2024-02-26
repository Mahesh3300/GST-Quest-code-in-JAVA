package com.gst.invoice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gst.invoice.entity.GstInvoiceItemsEntity;

public interface GstinvoiceApplicationItemRepo  extends JpaRepository<GstInvoiceItemsEntity, String>{

	
	List<GstInvoiceItemsEntity> findByDOCDTLSNO(String  process);
	//List<GstInvoiceItemsEntity> findByDOCDTLSNOAndOrganizationId(String  process,String organizationId);
}
