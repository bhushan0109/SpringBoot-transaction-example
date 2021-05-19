package com.tx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableTransactionManagement//not compulsary
public class FlightServiceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceExampleApplication.class, args);
	}

}
