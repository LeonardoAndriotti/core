package com.core.service;

import com.core.DTO.ShopDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

public class Geo {

    public static HashMap<String, List<ShopDTO>> shopGrid;

    public static List<ShopDTO> getContainShopList(String key){
        if (!shopGrid.containsKey(key)){
            shopGrid.put(key, getShopDTOS(key));
        }
        return shopGrid.get(key);
    }

    private static List<ShopDTO> getShopDTOS(@RequestParam("gridCode") String gridCode) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ShopDTO>> responseEntity =
                restTemplate.exchange("https://api-user.herokuapp.com/product",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ShopDTO>>() {
                        });
        List<ShopDTO> shopDTOList = responseEntity.getBody();
        shopGrid.put(gridCode, shopDTOList);
        return shopDTOList;
    }

}

