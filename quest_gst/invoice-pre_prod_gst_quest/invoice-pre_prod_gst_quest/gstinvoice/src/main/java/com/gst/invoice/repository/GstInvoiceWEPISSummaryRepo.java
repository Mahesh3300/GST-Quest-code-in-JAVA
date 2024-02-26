package com.gst.invoice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gst.invoice.entity.GstInvoiceWEPISSummaryEntity;

public interface GstInvoiceWEPISSummaryRepo extends JpaRepository<GstInvoiceWEPISSummaryEntity, String> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE WEPIS_GST_INV_SUMMARY_DETAILS SET attribute1=:attribute11,attribute2=:attribute12,attribute3=:attribute13,attribute4=:attribute14,attribute5=:attribute15 WHERE CUS_SEQ = :CUS_SEQ", nativeQuery = true)
	int updateAttributes(@Param("attribute11") String attribute11, @Param("attribute12") String attribute12,
			@Param("attribute13") String attribute13, @Param("attribute14") String attribute14,
			@Param("attribute15") String attribute15, @Param("CUS_SEQ") String CUS_SEQ);

}
