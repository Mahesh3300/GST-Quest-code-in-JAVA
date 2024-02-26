package com.gst.invoice.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Immutable;

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
@Immutable
@EqualsAndHashCode
public class GstInvoiceDoc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6895159088886554471L;
	private String DocTyp;
	private String DocNo;
	//need set format
	private String DocDt;

	
}