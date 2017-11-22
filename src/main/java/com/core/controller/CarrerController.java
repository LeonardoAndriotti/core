package com.core.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.core.DTO.CarrerDTO;
import com.core.DTO.ProductDTO;
import com.core.DTO.RelCarrerProductDTO;

@RestController
public class CarrerController {
	
	@RequestMapping(value = "/carrer/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable BigDecimal id) {
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<String> rateResponse =
	                restTemplate.exchange("http://localhost:8091/carrer/"+id,
	                        HttpMethod.DELETE, null, String.class);
		 	
			return rateResponse.getBody();
	}
	
//	@RequestMapping(value = "/carrer/update/{id}", method = RequestMethod.GET)
//	public String update(@PathVariable BigDecimal id) {
//		 RestTemplate restTemplate = new RestTemplate();
//		 ResponseEntity<String> rateResponse =
//	                restTemplate.exchange("http://localhost:8091/carrer/"+id,
//	                        HttpMethod.GET, null, String.class);
//		 	
//			return rateResponse.getBody();
//	}
	
	@RequestMapping(value ="/carrer/{iduser}", method= RequestMethod.GET)
	public List<RelCarrerProductDTO> getAllCarrerProduct(@PathVariable BigDecimal iduser) throws RestClientException, IOException {
		
		List<CarrerDTO> carrer = getCarrer(iduser);
		List<ProductDTO> products = getAllProduct(iduser);
		List<RelCarrerProductDTO> relCarrerProductList = new ArrayList<RelCarrerProductDTO>();
		RelCarrerProductDTO aux = new RelCarrerProductDTO();
		for (int i = 0; i < carrer.size(); i++) {
			RelCarrerProductDTO relCarrerProduct = new RelCarrerProductDTO();
			relCarrerProduct.setId(carrer.get(i).getId());
			relCarrerProduct.setIduser(carrer.get(i).getIduser());
			relCarrerProduct.setIdproduto(products.get(i).getId());
			relCarrerProduct.setName(products.get(i).getName());
			relCarrerProduct.setImage(products.get(i).getImage());
			relCarrerProduct.setPrice(products.get(i).getPrice());
			relCarrerProduct.setQuant(carrer.get(i).getQuant());
			relCarrerProduct.setShopping(products.get(i).getShopping());
			relCarrerProduct.setTotal(products.get(i).getPrice().multiply(relCarrerProduct.getQuant()));
			
			relCarrerProductList.add(relCarrerProduct);
		}
		for (int i = 0; i < relCarrerProductList.size(); i++) {
			
			System.out.println("==============");
			System.out.println("IDUSER: "+ relCarrerProductList.get(i).getIduser());
			System.out.println("IDPRODUTO: "+ relCarrerProductList.get(i).getIdproduto());
			System.out.println("NAME: "+ relCarrerProductList.get(i).getName());
			System.out.println("IMAGE: "+ relCarrerProductList.get(i).getImage());
			System.out.println("PRICE: "+ relCarrerProductList.get(i).getPrice());
			System.out.println("QUANT: "+ relCarrerProductList.get(i).getQuant());
			System.out.println("SHOPPING: "+ relCarrerProductList.get(i).getShopping());
			System.out.println("TOTAL: "+ relCarrerProductList.get(i).getTotal());
		}
		return relCarrerProductList;
	}
	
	public List<ProductDTO> getAllProduct(@PathVariable BigDecimal iduser) throws RestClientException, IOException{
		List<CarrerDTO> carrer = getCarrer(iduser);
		List<ProductDTO> products = new ArrayList<ProductDTO>();

		for (int i = 0; i < carrer.size(); i++) {
			products.add(getProduct(carrer.get(i).getIdproduto()));
			System.out.println(products.get(i).getName());
			System.out.println(products.get(i).getPrice());
		}
		return products;
	}
	
	 public List<CarrerDTO> getCarrer(BigDecimal iduser) throws RestClientException, IOException {
		 RestTemplate restTemplate = new RestTemplate();
			 ResponseEntity<List<CarrerDTO>> rateResponse =
		                restTemplate.exchange("http://localhost:8091/carrer/iduser/"+iduser,
		                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CarrerDTO>>() {
		                        });
			 	List<CarrerDTO> carrer = rateResponse.getBody();
				return carrer;
	 }
	 
	 public ProductDTO getProduct(BigDecimal id) throws RestClientException, IOException {
		RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<ProductDTO> rateResponse =
	                restTemplate.exchange("http://localhost:8092/product/"+id,
	                        HttpMethod.GET, null, new ParameterizedTypeReference<ProductDTO>() {
	                        });
	        ProductDTO produto = rateResponse.getBody();
			return produto;
	 }


//	    public static void main(String[] args) throws IOException {
//	    	BigDecimal one = new BigDecimal(2);
//	        new CarrerController().getAllCarrerProduct(one);
//	    }

}
