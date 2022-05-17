package org.sid.enset.billingservice;

import com.google.common.annotations.Beta;
import org.sid.enset.billingservice.dtos.InvoiceRequestDto;
import org.sid.enset.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner (InvoiceService invoiceService)
	{
		return args-> {
			invoiceService.save(new InvoiceRequestDto(BigDecimal.TEN,"C01"));
			invoiceService.save(new InvoiceRequestDto(BigDecimal.ZERO,"C01"));
			invoiceService.save(new InvoiceRequestDto(BigDecimal.ONE,"C02"));


		};
	}

}
