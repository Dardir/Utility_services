package com.utils.service.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceCaller {

    public <T, K> K sendRestRequest(String url, Class<?> responseClass) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            K resp = (K) restTemplate.getForObject(url, responseClass);
            return resp;
        } catch (Exception e) {
            return null;
        }
    }
}
