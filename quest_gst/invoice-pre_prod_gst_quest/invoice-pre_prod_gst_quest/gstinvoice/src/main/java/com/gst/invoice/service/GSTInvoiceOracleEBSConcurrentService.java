package com.gst.invoice.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;
@Component
@ConditionalOnNotWebApplication
public class GSTInvoiceOracleEBSConcurrentService  implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************************** CONSOLE APP *********************************");
		
	}

	
	
	
	
}
