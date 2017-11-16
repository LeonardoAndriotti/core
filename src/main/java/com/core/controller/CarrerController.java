package com.core.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.core.DTO.CarrerDTO;
import com.core.DTO.ProductDTO;


public class CarrerController {
	
	
	public List<ProductDTO> getAllProduct(int id) throws RestClientException, IOException{
		
		List<CarrerDTO> carrer = getCarrer(id);
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		for (int i = 0; i < carrer.size(); i++) {
			System.out.println(carrer.get(i).getIdproduto());
        }
		for (int i = 0; i < carrer.size(); i++) {
			products.add(getProduct(carrer.get(i).getIdproduto()));
			System.out.println(products.get(i).getName());
			System.out.println(products.get(i).getPrice());
		}
		return products;
	}
	
	 public List<CarrerDTO> getCarrer(int id) throws RestClientException, IOException {
		 RestTemplate restTemplate = new RestTemplate();
			 ResponseEntity<List<CarrerDTO>> rateResponse =
		                restTemplate.exchange("http://localhost:8091/carrer/iduser/"+id,
		                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CarrerDTO>>() {
		                        });
			 	List<CarrerDTO> carrer = rateResponse.getBody();
				return carrer;
	    }
	 
	 public ProductDTO getProduct(BigDecimal id) throws RestClientException, IOException {
		RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<ProductDTO> rateResponse =
	                restTemplate.exchange("http://localhost:8093/product/"+id,
	                        HttpMethod.GET, null, new ParameterizedTypeReference<ProductDTO>() {
	                        });
	        ProductDTO produto = rateResponse.getBody();
			return produto;
	    }


	    public static void main(String[] args) throws IOException {
	        new CarrerController().getAllProduct(1);
	    }

}
