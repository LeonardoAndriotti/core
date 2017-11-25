package com.core.controller;

import com.core.DTO.CarrerDTO;
import com.core.DTO.ProductDTO;
import com.core.DTO.RelCarrerProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarrerController {

    @RequestMapping(value = "/carrer/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable BigDecimal id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> rateResponse =
                restTemplate.exchange("http://localhost:8980/carrer/" + id,
                        HttpMethod.DELETE, null, String.class);

        return rateResponse.getBody();
    }

    @RequestMapping(value = "/carrer/{idUser}", method = RequestMethod.GET)
    public List<RelCarrerProductDTO> getAllCarrerProduct(@PathVariable BigDecimal idUser) throws RestClientException {

        List<CarrerDTO> carrer = getCarrer(idUser);
        List<ProductDTO> products = getAllProduct(idUser);
        List<RelCarrerProductDTO> relCarrerProductList = new ArrayList<>();
        RelCarrerProductDTO aux = new RelCarrerProductDTO();
        for (int i = 0; i < carrer.size(); i++) {
            RelCarrerProductDTO relCarrerProduct = new RelCarrerProductDTO();
            relCarrerProduct.setId(carrer.get(i).getId());
            relCarrerProduct.setIdUser(carrer.get(i).getIdUser());
            relCarrerProduct.setIdProduto(products.get(i).getId());
            relCarrerProduct.setName(products.get(i).getName());
            relCarrerProduct.setImage(products.get(i).getImage());
            relCarrerProduct.setPrice(products.get(i).getPrice());
            relCarrerProduct.setQuantidade(carrer.get(i).getQuantidade());
            relCarrerProduct.setShopping(products.get(i).getShopping());
            relCarrerProduct.setTotal(products.get(i).getPrice().multiply(relCarrerProduct.getQuantidade()));

            relCarrerProductList.add(relCarrerProduct);
        }
        return relCarrerProductList;
    }

    public List<ProductDTO> getAllProduct(@PathVariable BigDecimal idUser) throws RestClientException {
        List<CarrerDTO> carrer = getCarrer(idUser);
        List<ProductDTO> products = new ArrayList<>();

        for (int i = 0; i < carrer.size(); i++) {
            products.add(getProduct(carrer.get(i).getIdProduto()));
        }
        return products;
    }

    public List<CarrerDTO> getCarrer(BigDecimal idUser) throws RestClientException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CarrerDTO>> rateResponse =
                restTemplate.exchange("http://localhost:8980/carrer/" + idUser,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CarrerDTO>>() {
                        });
        List<CarrerDTO> carrer = rateResponse.getBody();
        return carrer;
    }

    public ProductDTO getProduct(BigDecimal id) throws RestClientException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductDTO> rateResponse =
                restTemplate.exchange("http://localhost:8092/product/" + id,
                        HttpMethod.GET, null, new ParameterizedTypeReference<ProductDTO>() {
                        });
        ProductDTO produto = rateResponse.getBody();
        return produto;
    }
}
