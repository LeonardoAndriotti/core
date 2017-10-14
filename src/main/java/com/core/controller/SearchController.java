package com.core.controller;

import com.core.DTO.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class SearchController {


    public void getEmployee() throws RestClientException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductDTO>> rateResponse =
                restTemplate.exchange("https://api-product.herokuapp.com/product",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDTO>>() {
                        });
        List<ProductDTO> product = rateResponse.getBody();
        System.out.println(product.get(0).getName());
    }


    public static void main(String[] args) throws IOException {
        new SearchController().getEmployee();
    }
}
