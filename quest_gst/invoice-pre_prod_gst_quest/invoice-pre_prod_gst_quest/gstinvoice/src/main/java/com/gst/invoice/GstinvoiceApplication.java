package com.gst.invoice;

import java.util.concurrent.Executor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@EnableAspectJAutoProxy
@EnableRetry
@ComponentScan(basePackages = { "com.gst.invoice" })
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = { "com.gst.invoice.repository" })
@EntityScan(basePackages = { "com.gst.invoice.entity" })
public class GstinvoiceApplication implements CommandLineRunner {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
	    return new ConcurrentTaskScheduler(); //single threaded by default
	}
	
	
	 @Bean
	    public Executor taskExecutor() {
	        return new SimpleAsyncTaskExecutor();
	   }

		/*
		 * @Autowired private GstinvoiceApplicationService gnvoiceApplicationService;
		 */
	public static void main(String[] args) {
		// SpringApplication.run(GstinvoiceApplication.class, args);
		SpringApplication application = new SpringApplication(GstinvoiceApplication.class);
		
		//application.setWebEnvironment(ObjectUtils.isEmpty(args));
		application.addListeners(new ApplicationPidFileWriter("./shutdownewb.pid"));
		application.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * // TODO Auto-generated method stub
	 * System.out.println("EXECUTING : command line runner");
	 * 
	 * for (int i = 0; i < args.length; ++i) { System.out.println("arg:" + args[i]);
	 * if (!args[i].startsWith("--")) {
	 * 
	 * String str = args[i];
	 * 
	 * if (str.startsWith("irncancel")) {
	 * 
	 * if (str.contains(":")) {
	 * gnvoiceApplicationService.getIRNCancelPostGstApiResponse(str); }
	 * 
	 * } else if (str.startsWith("qrcode")) { if (str.contains(":")) {
	 * gnvoiceApplicationService.getQrCodeFromIRN("", str.split(":")[1], "N"); }
	 * 
	 * } else if (str.startsWith("ewbcancel")) { if (str.contains(":")) { //String
	 * s[] = str.split(":"); gnvoiceApplicationService.cancelEwayBillByIRn(str); //
	 * ewbcancel:10040492:2:Cancelled the order
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * }else if (str.startsWith("ewbgen")) { if (str.contains(":")) { String s[] =
	 * str.split(":"); gnvoiceApplicationService.generateEwayBillByIRn(s[1]); //
	 * ewbcancel:10040492:2:Cancelled the order
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * else { gnvoiceApplicationService.getGstInvoiceResponse(str); }
	 * 
	 * System.exit(0);
	 * 
	 * } } }
	 */

}
