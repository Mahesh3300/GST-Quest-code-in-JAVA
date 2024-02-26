package com.gst.invoice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gst.invoice.entity.GstInvoiceMTLMaterialTrEntity;

public interface GstInvoiceMTLMaterialTransactionRepo extends JpaRepository<GstInvoiceMTLMaterialTrEntity, String> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE MTL_MATERIAL_TRANSACTIONS SET attribute11=:attribute11,attribute12=:attribute12,attribute13=:attribute13,attribute14=:attribute14,attribute15=:attribute15 WHERE organization_id = :organization_id and shipment_number = :shipment_number", nativeQuery = true)
	int updateAttributes(@Param("attribute11") String attribute11, @Param("attribute12") String attribute12,
			@Param("attribute13") String attribute13, @Param("attribute14") String attribute14,
			@Param("attribute15") String attribute15, @Param("organization_id") String organization_id,
			@Param("shipment_number") String shipment_number);

}
