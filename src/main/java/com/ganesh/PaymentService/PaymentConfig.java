package com.ganesh.PaymentService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
