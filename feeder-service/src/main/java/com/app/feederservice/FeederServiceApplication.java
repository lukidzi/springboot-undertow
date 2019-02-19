package com.app.feederservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FeederServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeederServiceApplication.class, args);
	}


	@RestController
	class ExampleEndpoint{

		@GetMapping(value = "/data")
		public String getData(){
			return "Sample data";
		}
	}
}
