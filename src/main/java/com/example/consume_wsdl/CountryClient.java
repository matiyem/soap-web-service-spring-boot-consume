package com.example.consume_wsdl;

import com.example.consume_wsdl.wsdlPackage.GetCountryRequest;
import com.example.consume_wsdl.wsdlPackage.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * created by Atiye Mousavi
 * Date: 8/4/2021
 * Time: 9:18 AM
 */

public class CountryClient extends WebServiceGatewaySupport {
    private static final Logger log= LoggerFactory.getLogger(CountryClient.class);
    @Autowired
    Environment environment;

    public GetCountryResponse getCountry(String country){
        GetCountryRequest request=new GetCountryRequest();
        request.setName(country);
        log.info("Requesting location for " + country);
        GetCountryResponse response= (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(environment.getProperty("wsdl.url"),request,new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;

    }

}
