package com.gst.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gst.invoice.entity.GstInvoiceRACustomerTrEntity;

public interface GstInvoiceRACustomerTransactionRepo extends JpaRepository<GstInvoiceRACustomerTrEntity, String> {

}
