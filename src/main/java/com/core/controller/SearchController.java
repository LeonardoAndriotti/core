package com.core.controller;

import com.core.DTO.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SearchController {

    @GetMapping(value = "/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> searchProduct(@PathVariable String product) throws RestClientException, IOException {

        String url = "https://api-product.herokuapp.com/product/" + product;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ProductDTO>> response =
                restTemplate.exchange(url,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDTO>>() {
                        });
         return response.getBody();
    }
}
