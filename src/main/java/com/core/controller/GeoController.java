package com.core.controller;

import com.core.CoreApplication;
import com.core.DTO.ShopDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GeoController {

    public List<ShopDTO> getShopList (String gridCode){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ShopDTO>> responseEntity =
                restTemplate.exchange("https://api-user.herokuapp.com/product",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ShopDTO>>() {
                        });
        List<ShopDTO> shopDTOList = responseEntity.getBody();
        CoreApplication.ShopGrid.put(gridCode, shopDTOList);

        return shopDTOList;
    }

}
