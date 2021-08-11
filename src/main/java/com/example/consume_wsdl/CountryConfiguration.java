package com.example.consume_wsdl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * created by Atiye Mousavi
 * Date: 8/4/2021
 * Time: 11:44 AM
 */
@Configuration
public class CountryConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
//        باید به پکیجی که در generatePackage است در فایل pom یکی باشد
        marshaller.setContextPath("com.example.consume_wsdl.wsdlPackage");
        return marshaller;
    }
    @Bean
    public CountryClient countryClient(Jaxb2Marshaller marshaller){
        CountryClient client=new CountryClient();
        client.setDefaultUri("http://localhost:8081/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
