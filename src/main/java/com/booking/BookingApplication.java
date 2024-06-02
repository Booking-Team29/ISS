package com.booking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.booking.domain")
public class BookingApplication {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

}
