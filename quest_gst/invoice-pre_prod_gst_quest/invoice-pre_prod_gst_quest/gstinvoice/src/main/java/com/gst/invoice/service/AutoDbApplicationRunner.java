package com.gst.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class AutoDbApplicationRunner implements ApplicationRunner {
	@Autowired
	private GstinvoiceApplicationService gnvoiceApplicationService;
    public void run(ApplicationArguments args) {
        if (ObjectUtils.isEmpty(args.getSourceArgs())) {
            return; // Regular web application
        }else {
        	//gnvoiceApplicationService.getGstInvoiceResponse(args.getSourceArgs()[0]);
        	System.out.println("Siva Test"+args.getSourceArgs());
        }
       
    }

}