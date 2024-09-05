package com.utils.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
public class UtilityServiceApplication {

	public static void main(String[] args) {
		 System.setProperty("http.proxyHost", "172.20.200.20");
	        System.setProperty("http.proxyPort", "8080");

	        System.setProperty("https.proxyHost", "172.20.200.20");
	        System.setProperty("https.proxyPort", "8080");
	        

			System.setProperty("javax.net.ssl.trustStore", "/mnt/secrets/sms");
		    System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

		SpringApplication.run(UtilityServiceApplication.class, args);
	}

}
