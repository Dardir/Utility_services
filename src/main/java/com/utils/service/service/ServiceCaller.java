package com.utils.service.service;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class ServiceCaller {

    @Value("${proxy.host}")
    private String proxyHost;

    @Value("${proxy.port}")
    private int proxyport;

    public <T, K> K sendRestRequest(String url, Class<?> responseClass) {
        try {
        	Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(proxyHost, proxyport));
        	SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        	requestFactory.setProxy(proxy);
            RestTemplate restTemplate = new RestTemplate(requestFactory);
            K resp = (K) restTemplate.getForObject(url, responseClass);
            return resp;
        } catch (Exception e) {
            System.out.println("we encountered error while trying to connect to the server which is :" + e.getMessage());
            return null;
        }
    }
}
