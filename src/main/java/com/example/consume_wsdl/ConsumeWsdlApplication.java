package com.example.consume_wsdl;

import com.example.consume_wsdl.wsdlPackage.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ConsumeWsdlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeWsdlApplication.class, args);
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**                                                                      **");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**            Tara consuming soap web service is ready                  **");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**                                                                      **");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
		System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
	}
	@Bean
	CommandLineRunner lookup(CountryClient quoteClient){
		return args -> {
			String country ="Spain";
			if (args.length >0){
				country =args[0];
			}
			GetCountryResponse response =quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}

}
